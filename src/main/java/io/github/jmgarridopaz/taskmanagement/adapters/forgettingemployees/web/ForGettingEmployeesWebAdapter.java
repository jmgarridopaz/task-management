package io.github.jmgarridopaz.taskmanagement.adapters.forgettingemployees.web;

import io.github.jmgarridopaz.taskmanagement.hexagon.acl.Employee;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.ForGettingEmployees;


public class ForGettingEmployeesWebAdapter implements ForGettingEmployees {

	private final String restApiUrl;
	
	
	public ForGettingEmployeesWebAdapter(String restApiUrl) {
		this.restApiUrl = restApiUrl;
	}

	@Override
	public Employee getEmployeeFromId ( String employeeId ) {
		// Makes a http request to the rest api method
		// Gets the JSON data
		// Translate JSON into Employee object
		throw new RuntimeException("Web Adapter Not Implemented");
	}
	
}
