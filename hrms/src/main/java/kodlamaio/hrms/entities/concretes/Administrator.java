package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="administrators")
public class Administrator extends User{
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nationality_id")
	private String nationalityId;
	
	@Column(name="year_of_birth")
	private LocalDate yearOfBirth;
	
	public Administrator() {
		
	}
	
	public Administrator(int id, String name, String lastName, String nationalityId,
			LocalDate yearOfBirth,
			String password, String email) {
		super(id,password,email);
		this.name = name;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.yearOfBirth = yearOfBirth;
	}

}
