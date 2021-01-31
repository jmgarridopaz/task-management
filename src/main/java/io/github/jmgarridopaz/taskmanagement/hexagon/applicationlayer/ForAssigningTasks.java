package io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer;

import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Task;

/*
 * Driver Port
 */
public interface ForAssigningTasks {

	public void assignTask ( AssignTaskRequest assignTaskRequest );

	public Task getTaskById ( String taskId );
	
}
