package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer>{
	
	Education getById(int educationId);

	List<Education> getAllByCandidate_Id(int candidateId);

	List<Education> getAllByCandidate_IdOrderByGraduationDateDesc(int candidateId);
}
