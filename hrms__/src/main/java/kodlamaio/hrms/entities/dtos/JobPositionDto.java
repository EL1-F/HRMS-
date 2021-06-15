package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPositionDto {
	
	private int dtoId;
	private String companyName;
	private String position;
	private String city;
	private int numberOfEmployees;
	private LocalDateTime publishDate;
	private Date applicationDeadline;
	private String timeName;
	private String wayName;

}
