package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;


@RestController
@RequestMapping("api/candidate")
public class CandidatiesController {
	
	private CandidateService candidateService;

	@Autowired
	public CandidatiesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getall(){
		return this.candidateService.getall();
	}
	
	
	@PostMapping("/add")
	public Result add(Candidate candidate) {
		return this.candidateService.add(candidate);
	}
	
	@GetMapping("/getCv")
	public DataResult<CandidateCvDto> getCvById(@RequestParam int id){
		return (this.candidateService.getCandidateCvDtoById(id));
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int candidateId) {
		
		return this.candidateService.delete(candidateId);
	}

}
