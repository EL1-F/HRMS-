package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao positionDao;

	public JobPositionManager(JobPositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}

	@Override
	public Result add(JobPosition position) {

		this.positionDao.save(position);
		return new SuccessResult("Başarılı");
	}

	@Override
	public Result delete(JobPosition position) {
		this.positionDao.delete(position);
		return new SuccessResult("Silindi");
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.positionDao.findAll(),
				"Listelendi.");
	}

	@Override
	public DataResult<List<JobPosition>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"publishDate");
		return new SuccessDataResult<List<JobPosition>>(this.positionDao.findAll(sort),
				"Listelendi.");
	}

	@Override
	public DataResult<List<JobPosition>> getByPosition(String position) {
		if(this.getByIsActiveTrue(position).getData() != null) {
			return new SuccessDataResult<List<JobPosition>>
			(this.positionDao.getByPosition_JobId_Position(position));
		}else {
			return new ErrorDataResult<List<JobPosition>>("Aktif iş ilanı yoktur");
		}
		
	}

	@Override
	public DataResult<List<JobPosition>> getByCompanyName(String companyName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobPosition>>
		(this.positionDao.getByCompanyName_EmployerId_CompanyName(companyName));
	}

	@Override
	public DataResult<List<JobPosition>> getByIsActiveTrue() {
		
		return new SuccessDataResult<List<JobPosition>>(this.positionDao.getByIsActiveTrue());
	}
	
	@Override
	public DataResult<List<JobPosition>> getByIsActiveTrue(String position) {
		
		return new SuccessDataResult<List<JobPosition>>(this.positionDao.getByIsActiveTrue(position));
	}

}
