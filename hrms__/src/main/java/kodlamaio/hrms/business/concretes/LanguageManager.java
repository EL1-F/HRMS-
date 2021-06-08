package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

@Service
public class LanguageManager implements LanguageService{

	private LanguageDao languageDao;
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}

	@Override
	public DataResult<List<Language>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Language>>
		(this.languageDao.getAllByCandidate_Id(candidateId));
	}

	@Override
	public Result delete(int languageId) {
		for(Language language: this.getAll().getData()) {
			if(language.getId()==languageId) {
				this.languageDao.delete(language);
			}
		}
		return new SuccessResult("Silindi");
	}

	@Override
	public DataResult<Language> getByLanguageId(int languageId) {
		return new SuccessDataResult<Language>(this.languageDao.getById(languageId));
	}
}
