package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;

@RestController
@CrossOrigin
@RequestMapping("api/languages")
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService ) {
		super();
		this.languageService = languageService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid Language language ) {
		
		return this.languageService.add(language);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int languageId) {
		return this.languageService.delete(languageId);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Language>> getall(@RequestParam int candidateId){
		return this.languageService.getAllByCandidateId(candidateId);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<Language>> getAllByCandidateId(@RequestParam int candidateId){
		return this.languageService.getAllByCandidateId(candidateId);
	}
	
	
	@GetMapping("/getByLanguageId")
	public DataResult<Language> getByLanguageId(@RequestParam int languageId){
		return this.languageService.getByLanguageId(languageId);
	}
}
