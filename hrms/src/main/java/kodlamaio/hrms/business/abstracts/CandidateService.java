package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {

	public DataResult<List<Candidate>> getall();
	public Result add(Candidate candidate);
	
	public DataResult<Candidate> getByEmail(String email);
	public DataResult<Candidate> getByNationalityId(String nationalityId);
}
