package kodlamaio.hrms.core.sender;


import kodlamaio.hrms.entities.concretes.Candidate;

public class MailSender implements MailSenderService<Candidate> {
	
	String verifyCode;

	@Override
	public String toProduceCode(Candidate entity) {
		// TODO Auto-generated method stub
		this.verifyCode = String.valueOf(entity.getId())+entity.getPassword();
		 return verifyCode;	
	}

	@Override
	public void sendMail(Candidate entity) {
		System.out.println(entity.getName() +" "+entity.getLastName()+
				" kişisine e-mail gönderildi.\n"+ verifyCode);
		
	}

	@Override
	public boolean certifyCode(String code) {
		if(userCheck()) {
			if(this.verifyCode ==code) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	@Override
	public boolean userCheck() {
		//kullanıcının uzantıya tıklayıp tıklamadığı durumu simule eder
		return true;
	}

}
