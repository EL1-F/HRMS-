package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	
	
	List<JobPosition> getByCompanyName_EmployerId_CompanyName(String companyName);
	
	List<JobPosition> getByPosition_JobId_Position(String position);
	
	List<JobPosition> getByIsActiveTrue();
	
	List<JobPosition> getByIsActiveTrue(String position);

}
