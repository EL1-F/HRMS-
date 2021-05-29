package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_positions")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "city_id") //name verirken tablo adı_id şeklinde yazıyoruz
	private City city;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "job_id")
	private Job job;
	
	@Column(name="description")
	private String description;
	
	@Column(name="number_of_employees")
	private int  numberOfEmployees;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name="publish_date",columnDefinition = "Date default CURRENT_DATE")
	private LocalDate publishDate= LocalDate.now();
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="is_active", columnDefinition = "boolean default true")
	private boolean isActive;

}
