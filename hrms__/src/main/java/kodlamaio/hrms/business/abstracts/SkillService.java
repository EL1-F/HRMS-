package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

public interface SkillService {

	public Result add(Skill skill);
	
	public Result delete(int skillId);
	
	public DataResult<List<Skill>> getAllByCandidateId( int candidateId);
	
}
