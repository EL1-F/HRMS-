package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

public interface LanguageService {

	public Result add(Language language);	
	
	public Result delete(int languageId);
	
	public DataResult<Language> getByLanguageId(int languageId);

	public DataResult<List<Language>> getAll();

	public DataResult<List<Language>> getAllByCandidateId(int candidateId);
}
