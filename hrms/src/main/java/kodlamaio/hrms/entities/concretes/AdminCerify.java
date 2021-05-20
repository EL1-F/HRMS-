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
@Table(name="admin_cerifies")
public class AdminCerify {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="employer_id")
	private int employerId;
	
	@Column(name="adminisrator-id")
	private int administatorId;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="confirmed_date")
	private LocalDate confirmedDate;
	
	public AdminCerify() {
		
	}

	public AdminCerify(int id, int employerId, int administatorId,
			boolean isConfirmed, LocalDate confirmedDate) {
		
		this.id = id;
		this.employerId = employerId;
		this.administatorId = administatorId;
		this.isConfirmed = isConfirmed;
		this.confirmedDate = confirmedDate;
	}

}
