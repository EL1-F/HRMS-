package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;

@RestController
@CrossOrigin
@RequestMapping("api/cities")
public class CitiesController {
	
	private CityService cityservice;

	@Autowired
	public CitiesController(CityService cityservice) {
		super();
		this.cityservice = cityservice;
	}
	
	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		return this.cityservice.getAll();
	}
	
	@GetMapping("/getById")
	public Result getById(int id) {
		return this.cityservice.getById(id);
	}

}
