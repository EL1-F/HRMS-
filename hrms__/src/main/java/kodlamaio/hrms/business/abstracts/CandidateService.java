package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

public interface CandidateService {

	public DataResult<List<Candidate>> getall();
	public Result add(Candidate candidate);
	
	public Result delete(int candidateId);
	
	public DataResult<Candidate> getByEmail(String email);
	public DataResult<Candidate> getByNationalityId(String nationalityId);
	
	public DataResult<Candidate> getById(int id);
	
	public DataResult<CandidateCvDto> getCandidateCvDtoById(int id);
}
