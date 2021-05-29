package kodlamaio.hrms.core.sender;


import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class MailSender<T> implements SenderService<T> {
	
	UUID verifyCode;

	@Override
	public UUID toProduceCode() {
		this.verifyCode = UUID.randomUUID();
		 return verifyCode;	
	}

	@Override
	public void send(String email) {
		
		System.out.println("Gönderilen kod:\n"+ verifyCode);
		
	}

	@Override
	public boolean certifyCode(UUID code) {
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

	
	public boolean userCheck() {
		//kullanıcının uzantıya tıklayıp tıklamadığı durumu simule eder
		return true;
	}

}
