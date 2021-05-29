package kodlamaio.hrms.core.utilities.results;

public class SuccessResult extends Result{

	public SuccessResult() {
		super(true);
		
	}
	
	public SuccessResult(String mesage) {
		super(true,mesage);
		
	}

}
