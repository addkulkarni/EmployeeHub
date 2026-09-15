package employeemanagement.projectmanagement.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectDetailsDTO
{
	private String projectName;
	private String status;
	private Date startDate;
	private Date endDate;
}
