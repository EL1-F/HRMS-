package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillDao;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.concretes.SocialLink;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

@Service
public class SkillManager implements  SkillService {

	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		this.skillDao = skillDao;
	}


	@Override
	public Result add(Skill skill) {
		this.skillDao.save(skill);
		return new SuccessResult("Eklendi");
	}
	

	@Override
	public DataResult<List<Skill>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Skill>>(this.skillDao.getAllByCandidate_Id(candidateId));
	}


	@Override
	public Result delete(int skillId) {
		for(Skill skill: this.skillDao.findAll()) {
			if(skill.getId()==skillId) {
				this.skillDao.delete(skill);
			}
		}
		return new SuccessResult("Silindi");
	}
}
