package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.Controls;
import kodlamaio.hrms.business.abstracts.AdminCerifyService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.sender.SenderService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private SenderService<EmployerDao> senderService;
	private AdminCerifyService cerifyService;
	
	public EmployerManager(EmployerDao employerDao,
			SenderService<EmployerDao> senderService,
			AdminCerifyService cerifyService) {
		super();
		this.employerDao = employerDao;
		this.senderService=senderService;
		this.cerifyService=cerifyService;
	}

	@Override
	public DataResult<List<Employer>> getall() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),
				"İş verenler listelenmiştir.");
	}

	@Override
	public Result add(Employer employer) {
		if(getByEmail(employer.getEmail()).getData() != null){
			return new ErrorResult("Sisteme kayıt mevcuttur.");
		}else {
			return this.saved(employer);
		}
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(this.employerDao.findByEmail(email));
	}

	@Override
	public DataResult<Employer> findByCompanyName(String companyName) {
		
		return new SuccessDataResult<Employer>(this.employerDao.findByCompanyName(companyName));
	}
	
	private Result saved(Employer employer) {
		if(Controls.checkEmailForEmployer(employer.getWebsite(),employer)) {
			UUID code= senderService.toProduceCode();
			senderService.send(employer.getEmail());
			if(senderService.certifyCode(code)) {  
			   if(this.cerifyService.isConfirm(employer)) {
				   employerDao.save(employer);
				   return new SuccessResult("Kaydınız Gerçekleştirildi");
			   }else {
				   return new ErrorResult("Yönetici onaylamadı.");
			   } 
			}else {
				return new ErrorResult("Onaylama Kodu onaylanmadı.");
			}
		}else {
			return new ErrorResult("Geçersiz Email.");
		}
	}

}
