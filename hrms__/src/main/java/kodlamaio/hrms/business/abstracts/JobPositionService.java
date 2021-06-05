package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobPositionDto;

public interface JobPositionService {
	
	Result add(JobPosition position);
	Result delete(JobPosition position);
	
	Result updateIsActive(int jobPositionId);
	
	DataResult<List<JobPosition>> getAll();
	DataResult<List<JobPosition>> getAllSorted();
	
	DataResult<List<JobPosition>> getByJobId(int jobId);	
	DataResult<List<JobPosition>> getByEmployer(int employerId);
	
	DataResult<List<JobPosition>> getByIsActiveTrue();
	
	DataResult<List<JobPositionDto>> getByIsActiveAndEmployer_CompanyName(boolean isActive,String companyName);
	DataResult<List<JobPositionDto>> getByIsActiveAndCity_CityName(boolean isActive, String city);
	
	DataResult<List<JobPositionDto>> getJobPositionDetails();
	

}
