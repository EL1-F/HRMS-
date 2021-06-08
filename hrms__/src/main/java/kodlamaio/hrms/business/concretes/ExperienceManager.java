package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceDao;

	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		this.experienceDao = experienceDao;
	}


	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("Eklendi.");
	}


	@Override
	public DataResult<List<Experience>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Experience>>
		(this.experienceDao.getAllByCandidate_Id(candidateId));
	}

	@Override
	public DataResult<List<Experience>> getAllByCandidateIdOrderByJobEndingDateDesc(int candidateId) {
		return new SuccessDataResult<List<Experience>>
		(this.experienceDao.findAllByCandidate_IdOrderByJobEndingDateDesc(candidateId));
	}


	@Override
	public Result delete(int experienceId) {
		for(Experience experience: this.experienceDao.findAll()) {
			if(experience.getId()==experienceId) {
				this.experienceDao.delete(experience);
			}
		}
		return new SuccessResult("Silindi");
	}
}
