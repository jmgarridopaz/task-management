package io.github.jmgarridopaz.taskmanagement.hexagon.acl;

import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Assignee;


public final class AssigneeTranslator {

	private final Employee employee;
	private final User user;
	
	public AssigneeTranslator ( Employee employee, User user ) {
		this.employee = employee;
		this.user = user;
	}

	public Assignee assigneeFromEmployeeAndUser() {
		String assigneeId = this.employee.id();
		String assigneeName = this.user.login();
		String assigneeEmail = this.employee.email();		
		return new Assignee ( assigneeId, assigneeName, assigneeEmail );
	}

}
