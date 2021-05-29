package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/job_positions")
public class JobPositionsController {
	
	private JobPositionService positionService;

	public JobPositionsController(JobPositionService positionService) {
		super();
		this.positionService = positionService;
	}
	
	@PostMapping("/add")
	public Result add(JobPosition position) {
		return this.positionService.add(position);
	}
	
	@PostMapping("/delete")
	public Result delete(JobPosition position) {
		return this.positionService.delete(position);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.positionService.getAll();
	}
	
	
	@GetMapping("/getallSorted")
	public DataResult<List<JobPosition>> getAllSorted(){
		return this.positionService.getAllSorted();
	}
	
	
	@GetMapping("/getByJobId")
	public DataResult<List<JobPosition>> getByJobId(int jobId){
		return this.positionService.getByJobId(jobId);
	}
	
	@GetMapping("/getByEmployer")
	public DataResult<List<JobPosition>> getByEmployer(int employerId){
		return this.positionService.getByEmployer(employerId);
	}
	
	
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobPosition>> getByIsActiveTrue(){
		return this.positionService.getByIsActiveTrue();
	}

}
