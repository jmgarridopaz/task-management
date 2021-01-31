package io.github.jmgarridopaz.taskmanagement.hexagon.acl;

import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Assignee;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.AssigneeService;

/*
 * 
 * ACL
 * Translates external models (repositories) into our domain model
 * 
 */
public class TranslatingAssigneeService implements AssigneeService {

	private final ForGettingEmployees employeeRepository;
	private final ForGettingUsers userRepository;
	
	public TranslatingAssigneeService ( ForGettingEmployees employeeRepository, ForGettingUsers userRepository ) {
		this.employeeRepository = employeeRepository;
		this.userRepository = userRepository;
	}

	
	@Override
	public Assignee getFromId ( String assigneeId ) {
		Employee employee = this.employeeRepository.getEmployeeFromId ( assigneeId );
		User user = this.userRepository.getUserFromId ( assigneeId );
		AssigneeTranslator assigneeTranslator = new AssigneeTranslator ( employee, user );
		return assigneeTranslator.assigneeFromEmployeeAndUser();
	}

}
