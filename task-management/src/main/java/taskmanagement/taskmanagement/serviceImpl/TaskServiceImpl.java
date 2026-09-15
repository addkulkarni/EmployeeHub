package taskmanagement.taskmanagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskmanagement.taskmanagement.entity.Task;
import taskmanagement.taskmanagement.repository.TaskRepository;
import taskmanagement.taskmanagement.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService
{
	@Autowired
	TaskRepository taskRepository;

	@Override
	public Task addTask(Task task)
	{
		return taskRepository.save(task);
	}

	@Override
	public List<Task> getAllTasks()
	{
		return taskRepository.findAll();
	}
}
