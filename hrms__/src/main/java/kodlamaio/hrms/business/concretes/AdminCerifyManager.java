package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AdminCerifyService;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class AdminCerifyManager implements AdminCerifyService{

	
	@Override
	public boolean isConfirm(Employer employer) {
		//admin onayladı
		return true;
	}

}
