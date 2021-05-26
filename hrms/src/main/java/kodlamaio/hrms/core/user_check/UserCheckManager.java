package kodlamaio.hrms.core.user_check;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class UserCheckManager implements UserCheckService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		// kendi servisimiz
		new SuccessResult("Kimlik doğrulandı.");
		return true;
	}

}
