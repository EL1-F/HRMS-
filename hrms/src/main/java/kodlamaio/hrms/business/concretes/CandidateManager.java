package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.Controls;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.sender.SenderService;
import kodlamaio.hrms.core.user_check.UserCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private SenderService<Candidate> senderService;
	private UserCheckService userCheckService;

	public CandidateManager(CandidateDao candidateDao,
			SenderService<Candidate> senderService,
			UserCheckService userCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.senderService=senderService;
		this.userCheckService=userCheckService;
	}

	@Override
	public DataResult<List<Candidate>> getall() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),
				"İş arayanlar listenmiştir");
	}

	@Override
	public Result add(Candidate candidate) {
		
		if(getByEmail(candidate.getEmail()).getData() != null || 
				getByNationalityId(candidate.getNationalityId()).getData() != null){
			return new ErrorResult("Sisteme kayıt mevcuttur.");
		}else {
			this.saved(candidate);
			return new SuccessResult("Kaydınız Gerçekleştirildi");
		}
	}

	@Override
	public DataResult<Candidate> getByEmail(String email) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.findByEmail(email));
	}

	@Override
	public DataResult<Candidate> getByNationalityId(String nationalityId) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.findByNationalityId(nationalityId));
	}
	
	
	private void saved(Candidate candidate) {
	
		if(userCheckService.checkIfRealPerson(candidate)) {
			if(Controls.checkEmailForCandidate(candidate.getEmail())) {
				
				UUID code= senderService.toProduceCode();
				senderService.send(candidate.getEmail());
				if(senderService.certifyCode(code)) {
					candidateDao.save(candidate);
				}
			}
		}else {
			new ErrorResult("Kimliğiniz doğrulanamadı.");
		}
		
	}
}
