package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="social_links")
@AllArgsConstructor
@NoArgsConstructor
public class SocialLink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="link_id")
	private int id;

	@Column(name = "link_address")
	private String linkAddress;
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;

}
