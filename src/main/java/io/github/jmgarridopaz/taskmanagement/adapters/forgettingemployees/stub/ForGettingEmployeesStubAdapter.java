package io.github.jmgarridopaz.taskmanagement.adapters.forgettingemployees.stub;

import io.github.jmgarridopaz.taskmanagement.hexagon.acl.Employee;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.ForGettingEmployees;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.ForGettingUsers;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.User;


public class ForGettingEmployeesStubAdapter implements ForGettingEmployees {

	private final Employee employee;
	
	
	public ForGettingEmployeesStubAdapter ( Employee employee ) {
		this.employee = employee;
	}

	@Override
	public Employee getEmployeeFromId(String employeeId) {
		if ( ! this.employee.id().equals(employeeId) ) {
			throw new IllegalArgumentException("Employee id '"+employeeId+"' does not exist");
		}
		return this.employee;
	}

}
