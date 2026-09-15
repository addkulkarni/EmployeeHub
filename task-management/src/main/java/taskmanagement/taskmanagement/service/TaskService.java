package taskmanagement.taskmanagement.service;

import taskmanagement.taskmanagement.entity.Task;

import java.util.List;

public interface TaskService
{
	Task addTask(Task task);

	List<Task> getAllTasks();
}
