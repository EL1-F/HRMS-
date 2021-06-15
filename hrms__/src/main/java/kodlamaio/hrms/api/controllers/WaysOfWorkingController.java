package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WayOfWorkingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WayOfWorking;

@RestController
@CrossOrigin
@RequestMapping("api/waysofworking")
public class WaysOfWorkingController {

	private WayOfWorkingService wayService;

	@Autowired
	public WaysOfWorkingController(WayOfWorkingService wayService) {
		super();
		this.wayService = wayService;
	}
	

	@GetMapping("/getall")
	DataResult<List<WayOfWorking>> getAll(){
		return this.wayService.getAll();
	}

	@GetMapping("/getById")
	Result getById(int id) {
		return this.wayService.getById(id);
	}
}
