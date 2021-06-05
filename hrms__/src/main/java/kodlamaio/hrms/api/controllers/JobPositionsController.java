package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.persistence.PostUpdate;
import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobPositionDto;

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
	
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobPosition>> getByIsActiveTrue(){
		return this.positionService.getByIsActiveTrue();
	}
	
	@GetMapping("/getByIsActiveAndEmployer_CompanyName")
	public DataResult<List<JobPositionDto>> getByIsActiveTrueAndEmployer_CompanyName
	(@RequestParam boolean isActive,@RequestParam String companyName) {
		
		return this.positionService.getByIsActiveAndEmployer_CompanyName(isActive,companyName);
	}
	
	
	@GetMapping("/getByIsActiveAndCity_CityName")
	public DataResult<List<JobPositionDto>>
	getByIsActiveTrueAndCity_CityName(@RequestParam boolean isActive, @RequestParam String city) {
		
		return this.positionService.getByIsActiveAndCity_CityName(isActive,city);
	}
	
	@GetMapping("/getJobPositionDetails")
	public DataResult<List<JobPositionDto>> getJobPositionDetails(){
		return this.positionService.getJobPositionDetails();
	}
	
	@PostMapping("/updateIsActive")
	public Result updateIsActive(int jobPositionId){
		return this.positionService.updateIsActive(jobPositionId);
	}
	

}
