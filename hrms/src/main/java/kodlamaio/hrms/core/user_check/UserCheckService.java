package kodlamaio.hrms.core.user_check;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface UserCheckService {

	boolean checkIfRealPerson(Candidate candidate);
}
