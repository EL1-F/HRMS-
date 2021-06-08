package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.concretes.SocialLink;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

public interface LinkService {

	public Result add(SocialLink link);
	
	public Result delete(int linkId);
	
	public DataResult<SocialLink> getByLinkId(int linkId);
		
	public DataResult<List<SocialLink>> getAllByCandidateId( int id);
}
