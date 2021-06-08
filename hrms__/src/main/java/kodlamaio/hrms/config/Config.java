package kodlamaio.hrms.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.imageUploaders.CloudinaryService;
import kodlamaio.hrms.core.imageUploaders.ImagesService;

@Configuration
public class Config {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();  
	}
	
	@Bean // instance oluşturuyor.
    public Cloudinary cloudinary(){
		
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "elifipek",
                "api_key", "862627697274426",
                "api_secret", "8-_Y4_b8f5phpSzK8ApcOKbeaZc"
                ));
    }

}