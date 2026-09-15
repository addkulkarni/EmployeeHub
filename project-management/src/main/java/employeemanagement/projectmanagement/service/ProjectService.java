package employeemanagement.projectmanagement.service;

import employeemanagement.projectmanagement.DTO.ProjectDetailsDTO;
import employeemanagement.projectmanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface ProjectService
{
	Page<ProjectDetailsDTO> getAllProjects(int page, int size, String sortBy, String sortDir);

	Project addProject(Project project);

	ProjectDetailsDTO getProject(Long id);
}
