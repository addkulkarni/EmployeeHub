package employeemanagement.projectmanagement.controller;

import employeemanagement.projectmanagement.DTO.ProjectDetailsDTO;
import employeemanagement.projectmanagement.entity.Project;
import employeemanagement.projectmanagement.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController
{
	@Autowired
	ProjectService projectService;

	private final static Logger log = LoggerFactory.getLogger(ProjectController.class);

	@GetMapping("/getAllProjects")
	public ResponseEntity<Page<ProjectDetailsDTO>> getAllProjects(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "startDate") String sortBy,@RequestParam(defaultValue = "asc") String sortDir)
	{
		log.info("Getting all the projects");
		return new ResponseEntity<>(projectService.getAllProjects(page, size, sortBy, sortDir), HttpStatus.OK);
	}

	@PostMapping("/addProject")
	public ResponseEntity<Project> addProject(@RequestBody Project project)
	{
		log.info("Adding the project to the system");
		return new ResponseEntity<>(projectService.addProject(project),HttpStatus.OK);
	}

	@GetMapping("/getProject/{id}")
	public ResponseEntity<ProjectDetailsDTO> getProject(@PathVariable Long id)
	{
		log.info("Getting details of project with id: "+id);
		return new ResponseEntity<>(projectService.getProject(id),HttpStatus.OK);
	}
}
