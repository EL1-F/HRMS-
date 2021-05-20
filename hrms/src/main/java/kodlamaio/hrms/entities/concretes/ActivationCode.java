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
@Table(name="activation_codes")
public class ActivationCode {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="activation_code")
	private String activationCode;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="confirmed_date")
	private LocalDate confirmedDate;
	
	public ActivationCode() {
		
	}

	public ActivationCode(int id, int userId, String activationCode,
			boolean isConfirmed, LocalDate confirmedDate) {
		
		this.id = id;
		this.userId = userId;
		this.activationCode = activationCode;
		this.isConfirmed = isConfirmed;
		this.confirmedDate = confirmedDate;
	}

}
