package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="administrators")
@PrimaryKeyJoinColumn(name = "user_id")
@NoArgsConstructor  //parametresiz consructor
@AllArgsConstructor
public class Administrator extends User{

	@Column(name="name")
	private String name;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nationality_id")
	private String nationalityId;
	
	@Column(name="year_of_birth")
	private LocalDate yearOfBirth;

}
