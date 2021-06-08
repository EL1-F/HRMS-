package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SocialLink;

public interface LinkDao extends JpaRepository<SocialLink, Integer> {
	
	SocialLink getById(int linkId);

	List<SocialLink> getAllByCandidate_Id(int id);
}
