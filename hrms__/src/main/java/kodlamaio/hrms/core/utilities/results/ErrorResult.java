package kodlamaio.hrms.core.utilities.results;

public class ErrorResult extends Result{
	
	public ErrorResult() {
		super(false);
		
	}
	
	public ErrorResult(String mesage) {
		super(false,mesage);
		
	}

}
