package io.github.jmgarridopaz.taskmanagement.adapters.forgettingemployees.stub;

import java.util.ArrayList;
import java.util.List;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice.Employee;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice.ForGettingEmployees;


public class ForGettingEmployeesStubAdapter implements ForGettingEmployees {

	private final Employee[] employees;
	
	public ForGettingEmployeesStubAdapter ( Employee ... employees ) {
		this.employees = employees;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		for ( Employee employee : this.employees ) {
			employeeList.add ( employee );
		}
		return employeeList;
	}
	
}
