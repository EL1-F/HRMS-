package kodlamaio.hrms.adapters;

import java.rmi.RemoteException;

import kodlamaio.hrms.core.user_check.UserCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;

public class MernisServiceAdapter implements UserCheckService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		// TODO Auto-generated method stub
		return true;
	}

}
