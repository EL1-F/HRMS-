package kodlamaio.hrms.core.imageUploaders;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface ImagesService {

	DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
