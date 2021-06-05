package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobPositionDto;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	
	
	List<JobPosition> getByEmployer_IdAndIsActiveTrue(int employerId);	
	List<JobPosition> getByJob_IdAndIsActiveTrue(int jobId);
	
	@Transactional
	@Modifying
	@Query("Update kodlamaio.hrms.entities.concretes.JobPosition SET isActive = false where id =:id")
	void updateDeisActiveJobPosition(@Param("id")int id);
	
	List<JobPosition> getByIsActiveTrue();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobPositionDto"
			+ "(jp.id,e.companyName,j.position,c.cityName,jp.numberOfEmployees,jp.publishDate,jp.applicationDeadline) "
			+ "From JobPosition jp inner join jp.employer e inner join jp.job j inner join jp.city c "
			+ " WHERE e.companyName=:companyName AND jp.isActive=:isActive")
	List<JobPositionDto> getByIsActiveAndEmployer_CompanyName(@Param("isActive") boolean isActive,
			@Param("companyName") String companyName);
	

	@Query("Select new kodlamaio.hrms.entities.dtos.JobPositionDto"
			+ "(jp.id,e.companyName,j.position,c.cityName,jp.numberOfEmployees,jp.publishDate,jp.applicationDeadline) "
			+ "From JobPosition jp inner join jp.employer e inner join jp.job j inner join jp.city c "
			+ " WHERE c.cityName=:city AND jp.isActive=:isActive")
	List<JobPositionDto> getByIsActiveAndCity_CityName(@Param("isActive") boolean isActive,
			@Param("city") String city);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobPositionDto(jp.id,e.companyName,j.position,c.cityName,jp.numberOfEmployees,jp.publishDate,jp.applicationDeadline) "
			+ "From JobPosition jp inner join jp.employer e inner join jp.job j inner join jp.city c "
			+ "where jp.isActive = true")
	List<JobPositionDto> getJobPositionDetails();
	
	//from dersek tüm alanları çeker, seçmek için select 
	
	//select * from Category c inner join Product p
	//on c.categoryId=p.categoryId >>once ana tablo(one) sonra many yazarak daha kolay olur
}
