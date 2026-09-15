package taskmanagement.taskmanagement.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import taskmanagement.taskmanagement.entity.Task;
import taskmanagement.taskmanagement.service.TaskService;

import java.util.List;

@RestController
public class TaskController
{
	@Autowired
	TaskService taskService;

	@PostMapping("/addTask")
	public ResponseEntity<Task> addTask(@RequestBody Task task)
	{
		return new ResponseEntity<>(taskService.addTask(task), HttpStatus.OK);
	}

	@GetMapping("/getAllTasks")
	public ResponseEntity<List<Task>> getAllTasks()
	{
		return new ResponseEntity<>(taskService.getAllTasks(),HttpStatus.OK);
	}
}
