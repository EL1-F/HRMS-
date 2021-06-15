package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobPositionDto;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao positionDao;

	@Autowired
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
	public DataResult<List<JobPosition>> getByJobId(int jobId) {
			return new SuccessDataResult<List<JobPosition>>
			(this.positionDao.getByJob_IdAndIsActiveTrue(jobId));
		
	}

	@Override
	public DataResult<List<JobPosition>> getByEmployer(int employerId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobPosition>>
		(this.positionDao.getByEmployer_IdAndIsActiveTrue(employerId));
	}

	@Override
	public DataResult<List<JobPosition>> getByIsActiveTrue() {
		
		return new SuccessDataResult<List<JobPosition>>(this.positionDao.getByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobPositionDto>> getByIsActiveAndEmployer_CompanyName
	(boolean isActive,String companyName) {
		
		return new SuccessDataResult<List<JobPositionDto>>
		(this.positionDao.getByIsActiveAndEmployer_CompanyName(isActive,companyName));
	}

	@Override
	public DataResult<List<JobPositionDto>> getByIsActiveAndCity_CityName(boolean isActive, String city) {
		return new SuccessDataResult<List<JobPositionDto>>
		(this.positionDao.getByIsActiveAndCity_CityName(isActive,city.toUpperCase()));
	}

	@Override
	public DataResult<List<JobPositionDto>> getJobPositionDetails() {
		return new SuccessDataResult<List<JobPositionDto>>(this.positionDao.getJobPositionDetails(),
				"Listelendi.");
	}

	@Override
	public Result updateIsActive(int jobPositionId) {
		this.positionDao.updateDeisActiveJobPosition(jobPositionId);
		return new SuccessResult("Pozisyon durumu güncellendi");
	}

	
	
	
	
}
