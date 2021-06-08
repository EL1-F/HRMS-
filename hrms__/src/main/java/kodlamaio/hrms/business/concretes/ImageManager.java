package kodlamaio.hrms.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.imageUploaders.ImagesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.Skill;

@Service
public class ImageManager implements ImageService{
	
	private ImageDao imageDao;
	private ImagesService imagesService;

	@Autowired
	public ImageManager(ImageDao imageDao, ImagesService imagesService) {
		this.imageDao = imageDao;
		this.imagesService = imagesService;
	}


	@Override
	public Result add(Image image,  MultipartFile imageFile) {
		Map<String,String> uploadImage = this.imagesService.uploadImageFile(imageFile).getData();
		image.setImageLink(uploadImage.get("url"));
		this.imageDao.save(image);
		return new SuccessResult("Image has been added.");
	}



	@Override
	public DataResult<Image> getByCandidateId(int candidateId) {

		return new SuccessDataResult<Image>(this.imageDao.findByCandidate_Id(candidateId));
	}


	@Override
	public Result delete(int imageId) {
		for(Image image: this.imageDao.findAll()) {
			if(image.getImageId()==imageId) {
				this.imageDao.delete(image);
			}
		}
		return new SuccessResult("Silindi");
	}
}
