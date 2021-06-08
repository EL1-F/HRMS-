package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer>{

	List<Experience> getAllByCandidate_Id(int candidateId);

	List<Experience> findAllByCandidate_IdOrderByJobEndingDateDesc(int candidateId);

}
