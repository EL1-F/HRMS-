package kodlamaio.hrms.core.user_check;

import kodlamaio.hrms.entities.concretes.Candidate;

public class UserCheckManager implements UserCheckService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		// kendi servisimiz
		return true;
	}

}
