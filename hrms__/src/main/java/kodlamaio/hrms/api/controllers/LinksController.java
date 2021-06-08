package kodlamaio.hrms.api.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialLink;

@RestController
@RequestMapping("api/link")

public class LinksController {
	private LinkService linkService;

	@Autowired
	public LinksController(LinkService linkService) {
		super();
		this.linkService = linkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SocialLink link) {
		return this.linkService.add(link);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int linkId) {
		return this.linkService.delete(linkId);
	}
	
	@GetMapping("/getByLinkId")
	public DataResult<SocialLink> getByLinkId(@RequestParam int linkId){
		return this.linkService.getByLinkId(linkId);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<SocialLink>> getAllByCandidateId(@RequestParam int id){
		return this.linkService.getAllByCandidateId(id);
	}
	
}
