package kodlamaio.hrms.entities.concretes;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidates")
@EqualsAndHashCode(callSuper=false) 
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor 

public class Candidate extends User {

	
	@Column(name="name")
	private String name;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nationality_id")
	private String nationalityId;
	
	@Column(name="year_of_birth")
	private Date yearOfBirth;
	
	@Column(name="picture_url",nullable = true)
	private String pictureUrl;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Education> educations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Experience> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<SocialLink> links;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Skill> skills;
	
	@JsonIgnore
	@OneToOne(mappedBy="candidate",optional=false, fetch=FetchType.LAZY)
	private Image image;

}
