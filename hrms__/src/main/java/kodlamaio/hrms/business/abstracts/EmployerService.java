package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	public DataResult<List<Employer>> getall();
	public Result add(Employer employer);

	public DataResult<Employer> getByEmail(String email);
	public DataResult<Employer> findByCompanyName(String companyName);
}
