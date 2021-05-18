package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="jobs")
public class Job {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="position_name")
	private String position;
	
	
	public Job() {
		
	}
	
	public Job(int id, String position) {
		super();
		this.id = id;
		this.position = position;
	}
 
}
