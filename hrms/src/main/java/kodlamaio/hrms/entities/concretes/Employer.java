package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employers")
public class Employer extends User {
	
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website")
	private String website;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	public Employer() {
		
	}

	public Employer(int id, String companyName, String website,
			String phoneNumber,String password, String email) {
		super(id,password,email);
		this.companyName = companyName;
		this.website = website;
		this.phoneNumber = phoneNumber;
	}

}