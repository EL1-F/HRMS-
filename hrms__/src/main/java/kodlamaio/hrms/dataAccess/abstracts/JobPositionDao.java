package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	
	
	List<JobPosition> getByEmployer_IdAndIsActiveTrue(int employerId);
	
	List<JobPosition> getByJob_IdAndIsActiveTrue(int jobId);
	
	List<JobPosition> getByIsActiveTrue();

}
