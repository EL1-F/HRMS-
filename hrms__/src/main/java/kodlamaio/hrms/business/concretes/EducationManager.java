package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;

	@Autowired
	public EducationManager(EducationDao educationDao) {
		this.educationDao = educationDao;
	}

	
	@Override
	public DataResult<List<Education>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Education>>
		(this.educationDao.getAllByCandidate_Id(candidateId));
	}

	@Override
	public DataResult<List<Education>> getAllByCandidateIdOrderByGraduationDateDesc(int candidateId) {
		return new SuccessDataResult<List<Education>>
		(this.educationDao.getAllByCandidate_IdOrderByGraduationDateDesc(candidateId));
	}


	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Eklendi");
	}


	@Override
	public Result delete(int educationId) {
		for(Education education: this.educationDao.findAll()) {
			if(education.getId()==educationId) {
				this.educationDao.delete(education);
			}
		}
		return new SuccessResult("Silindi");
	}


	@Override
	public DataResult<Education> getByEducationId(int educationId) {
		return new SuccessDataResult<Education>(this.educationDao.getById(educationId));
	}

}
