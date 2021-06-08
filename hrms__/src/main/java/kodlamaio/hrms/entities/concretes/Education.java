package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="educations")
@AllArgsConstructor
@NoArgsConstructor
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="education_id")
	private int id;
	
	@Column(name="university")
	private String university;
	
	@Column(name="department")
	private String department;
	
	@NotBlank(message = "Bu alan boş olamaz")
	@PastOrPresent
	@Column(name = "edu_beginning_date")
	private LocalDate eduBeginningDate;

	@PastOrPresent  //( message = "Tarih Bugün veya daha önce olmalıdır" ) 
	@Column(name = "graduation_date", nullable = true)
	private LocalDate graduationDate;
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;

	//fakülte ve bölüm olarak ayrılacak!!
}
