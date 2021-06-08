package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

public interface ExperienceService {

	public Result add(Experience experience);
	
	public Result delete(int experienceId);
	
	public DataResult<List<Experience>> getAllByCandidateId(int candidateId);

	public DataResult<List<Experience>> getAllByCandidateIdOrderByJobEndingDateDesc(int candidateId);
}
