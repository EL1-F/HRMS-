package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	
	Result add(JobPosition position);
	Result delete(JobPosition position);
	
	DataResult<List<JobPosition>> getAll();
	DataResult<List<JobPosition>> getAllSorted();
	
	DataResult<List<JobPosition>> getByJobId(int jobId);
	
	DataResult<List<JobPosition>> getByEmployer(int employerId);
	
	DataResult<List<JobPosition>> getByIsActiveTrue();
	

}
