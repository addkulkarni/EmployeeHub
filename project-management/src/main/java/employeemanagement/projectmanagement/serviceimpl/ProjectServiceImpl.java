package employeemanagement.projectmanagement.serviceimpl;

import employeemanagement.projectmanagement.DTO.ProjectDetailsDTO;
import employeemanagement.projectmanagement.entity.Project;
import employeemanagement.projectmanagement.repository.ProjectRepository;
import employeemanagement.projectmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService
{
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public Page<ProjectDetailsDTO> getAllProjects(int page, int size, String sortBy, String sortDir)
	{
		Sort sort;
		if(sortDir.equalsIgnoreCase("desc"))
		{
			sort = Sort.by(sortBy).descending();
		}
		else {
			sort = Sort.by(sortBy).ascending();
		}

		Pageable pageable = PageRequest.of(page,size,sort);
		Page<Project> project = projectRepository.findAll(pageable);
		Page<ProjectDetailsDTO> detailspage = project.map(proj->{
			ProjectDetailsDTO dto = new ProjectDetailsDTO();
			dto.setProjectName(proj.getProjectName());
			dto.setStatus(proj.getStatus());
			dto.setStartDate(proj.getStartDate());
			dto.setEndDate(proj.getEndDate());
			return dto;
		});
		return detailspage;
	}

	@Override
	public Project addProject(Project project)
	{
		return projectRepository.save(project);
	}

	@Override
	public ProjectDetailsDTO getProject(Long id)
	{
		Project project = projectRepository.findById(id).get();
		ProjectDetailsDTO dto = new ProjectDetailsDTO();
		dto.setProjectName(project.getProjectName());
		dto.setStatus(project.getStatus());
		dto.setStartDate(project.getStartDate());
		dto.setEndDate(project.getEndDate());
		return dto;
	}
}
