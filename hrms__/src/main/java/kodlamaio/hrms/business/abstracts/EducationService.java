package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

public interface EducationService {

	public Result add(Education education);
	
	public Result delete(int educationId);
	
	public DataResult<Education> getByEducationId(int educationId);
	
	public DataResult<List<Education>> getAllByCandidateId(int candidateId);
	
	public DataResult<List<Education>> getAllByCandidateIdOrderByGraduationDateDesc(int candidateId);
}
