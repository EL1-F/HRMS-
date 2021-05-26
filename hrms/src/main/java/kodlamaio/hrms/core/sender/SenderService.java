package kodlamaio.hrms.core.sender;

import java.util.UUID;

public interface SenderService<T> {
	
	UUID toProduceCode();
	void send(String email);
	boolean certifyCode(UUID code);
	

}
