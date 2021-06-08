package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LinkDao;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.concretes.SocialLink;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

@Service
public class LinkManager implements LinkService{

	private LinkDao linkDao;

	@Autowired
	public LinkManager(LinkDao linkDao) {
		this.linkDao = linkDao;
	}
	
	@Override
	public Result add(SocialLink link) {
		this.linkDao.save(link);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<List<SocialLink>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<SocialLink>>
		(this.linkDao.getAllByCandidate_Id(id));
	}

	@Override
	public Result delete(int linkId) {
		for(SocialLink link: this.linkDao.findAll()) {
			if(link.getId()==linkId) {
				this.linkDao.delete(link);
			}
		}
		return new SuccessResult("Silindi");
	}

	@Override
	public DataResult<SocialLink> getByLinkId(int linkId) {
		return new SuccessDataResult<SocialLink>(this.linkDao.getById(linkId));
	}

	
}
