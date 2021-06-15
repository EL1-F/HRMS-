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

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Experience;

@RestController
@CrossOrigin
@RequestMapping("api/experiences")
public class ExperiencesController {
	
	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Experience Experience) {
		return this.experienceService.add(Experience);
	}
	
	@PostMapping("/delete")
	public Result add(@RequestParam int experienceId) {
		return this.experienceService.delete(experienceId);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<Experience>> getAllByCandidateId(@RequestParam int candidateId){
		return this.experienceService.getAllByCandidateId(candidateId);
	}

	@GetMapping("/getAllByCandidateIdOrderByJobEndingDateDesc")
	public DataResult<List<Experience>> 
	getAllByCandidateIdOrderByJobEndingDateDesc(@RequestParam int candidateId){
		return this.experienceService.getAllByCandidateIdOrderByJobEndingDateDesc(candidateId);
	}

}
