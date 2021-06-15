package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WayOfWorkingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WayOfWorkingDao;
import kodlamaio.hrms.entities.concretes.WayOfWorking;

@Service
public class WayOfWorkingManager implements WayOfWorkingService{
	
	private WayOfWorkingDao wayDao;

	@Autowired
	public WayOfWorkingManager(WayOfWorkingDao wayDao) {
		super();
		this.wayDao = wayDao;
	}

	@Override
	public DataResult<List<WayOfWorking>> getAll() {
		return new SuccessDataResult<List<WayOfWorking>>(this.wayDao.findAll());
	}

	@Override
	public Result getById(int id) {
		this.wayDao.getById(id);
		return new SuccessResult();
	}

}
