package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.Controls;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.sender.SenderService;
import kodlamaio.hrms.core.user_check.UserCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private LanguageService languageService;
	private ExperienceService experienceService;
	private LinkService linkService;
	private ImageService imageService;
	private SkillService skillService;
	private EducationService educationService;
	private SenderService<Candidate> senderService;
	private UserCheckService userCheckService;


	public CandidateManager(CandidateDao candidateDao, LanguageService languageService,
			ExperienceService experienceService, LinkService linkService, ImageService imageService,
			SkillService skillService, EducationService educationService, SenderService<Candidate> senderService,
			UserCheckService userCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.languageService = languageService;
		this.experienceService = experienceService;
		this.linkService = linkService;
		this.imageService = imageService;
		this.skillService = skillService;
		this.educationService = educationService;
		this.senderService = senderService;
		this.userCheckService = userCheckService;
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

	@Override
	public DataResult<Candidate> getById(int Id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(Id));
	}

	@Override
	public DataResult<CandidateCvDto> getCandidateCvDtoById(int id) {
		CandidateCvDto candidateCvDto = new CandidateCvDto();
		candidateCvDto.setCandidate(this.getById(id).getData());
		candidateCvDto.setImage(this.imageService.getByCandidateId(id).getData());
		candidateCvDto.setLanguages(this.languageService.getAllByCandidateId(id).getData());
		candidateCvDto.setLinks(this.linkService.getAllByCandidateId(id).getData());
		candidateCvDto.setSkills(this.skillService.getAllByCandidateId(id).getData());
		candidateCvDto.setEducations(this.educationService.getAllByCandidateId(id).getData());
		candidateCvDto.setExperiences(this.experienceService.getAllByCandidateId(id).getData());
		return new SuccessDataResult<CandidateCvDto>(candidateCvDto, "listelendi");
	}

	@Override
	public Result delete(int candidateId) {
		for(Candidate candidate : this.getall().getData()) {
			if(candidate.getId()==candidateId) {
				this.candidateDao.delete(candidate);
			}
		}
		return new SuccessResult("Silindi.");
	}
}
