package kodlamaio.hrms.business.abstracts;



import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {

	public Result add(Image image,  MultipartFile imageFile);
	
	public Result delete(int imageId);
	
	public DataResult<Image> getByCandidateId(int candidateId);
}
