package io.github.jmgarridopaz.taskmanagement.hexagon;

import io.github.jmgarridopaz.taskmanagement.hexagon.acl.ForGettingEmployees;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.ForGettingUsers;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.TranslatingAssigneeService;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.ForAssigningTasks;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.TaskManager;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.AssigneeService;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.ForStoringTasks;


/*
 * The hexagon has a conigurable dependency on driven ports and offers driver ports 
 */
public class Hexagon {

	// Driven ports
	private final ForGettingEmployees employeeRepository;
	private final ForGettingUsers userRepository;
	private final ForStoringTasks taskRepository;

	
	public Hexagon (  ForGettingEmployees employeeRepository, ForGettingUsers userRepository, ForStoringTasks taskRepository ) {
		this.employeeRepository = employeeRepository;
		this.userRepository = userRepository;
		this.taskRepository = taskRepository;
	}

	// Driver port
	public ForAssigningTasks forAssigningTasks() {
		AssigneeService assigneeService = new TranslatingAssigneeService ( this.employeeRepository, this.userRepository);
		return new TaskManager ( assigneeService, this.taskRepository );
	}
	
}
