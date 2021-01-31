package io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer;

import java.time.LocalDate;


/*
 * DTO : Data Transfer Object
 */
public class AssignTaskRequest {

	private String taskTitle;
	private LocalDate taskDueDate;
	private String assigneeId;
		
	public AssignTaskRequest ( String taskTitle, LocalDate taskDueDate, String assigneeId ) {
		this.taskTitle = taskTitle;
		this.taskDueDate = taskDueDate;
		this.assigneeId = assigneeId;
	}

	public String taskTitle() {
		return taskTitle;
	}

	public LocalDate taskDueDate() {
		return taskDueDate;
	}

	public String assigneeId() {
		return assigneeId;
	}

}