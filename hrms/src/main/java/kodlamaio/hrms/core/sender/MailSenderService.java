package kodlamaio.hrms.core.sender;


public interface MailSenderService<T> {
	
	String toProduceCode(T entity);
	void sendMail(T entity);
	boolean certifyCode(String code);
	boolean userCheck();

}
