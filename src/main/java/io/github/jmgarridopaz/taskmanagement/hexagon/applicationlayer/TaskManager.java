package io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer;

import java.time.LocalDate;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Assignee;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.AssigneeService;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.ForStoringTasks;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Task;

/*
 * Application Service
 * 
 * Business logic implementing the use cases defined at the driver port
 */
public class TaskManager implements ForAssigningTasks {

	private final AssigneeService assigneeService;
	private final ForStoringTasks taskRepository;
	
	public TaskManager ( AssigneeService assigneeService, ForStoringTasks taskRepository ) {
		this.assigneeService = assigneeService;
		this.taskRepository = taskRepository;
	}

	@Override
	public void assignTask(AssignTaskRequest assignTaskRequest) {
		String 		taskId			= this.taskRepository.nextId();
		String 		taskTitle		= assignTaskRequest.taskTitle();
		LocalDate	taskDueDate		= assignTaskRequest.taskDueDate();
		Assignee	assignee		= this.assigneeService.getFromId ( assignTaskRequest.assigneeId() );
		Task 		task			= new Task ( taskId, taskTitle, taskDueDate, assignee);
		this.taskRepository.storeTask ( task );
	}

	@Override
	public Task getTaskById ( String taskId ) {
		return this.taskRepository.findById ( taskId );
	}

}
