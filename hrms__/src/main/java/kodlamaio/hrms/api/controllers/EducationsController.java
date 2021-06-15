package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;

@RestController
@CrossOrigin
@RequestMapping("api/educations")
public class EducationsController {
	
	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Education education) {
		
		return this.educationService.add(education);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int educationId) {
		
		return this.educationService.delete(educationId);
	}
	
	@GetMapping("/getByEducationId")
	public DataResult<Education> getByEducationId(@RequestParam int educationId){
		return this.educationService.getByEducationId(educationId);
	}
	
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<Education>> getAllByCandidateId(@RequestParam int candidateId){
		return this.educationService.getAllByCandidateId(candidateId);
	}
	
	
	@GetMapping("/getAllByCandidateIdOrderByGraduationDateDesc")
	public DataResult<List<Education>> 
	getAllByCandidateIdOrderByGraduationDateDesc(@RequestParam int candidateId){
		return this.educationService.getAllByCandidateIdOrderByGraduationDateDesc(candidateId);
	}

}
