package io.github.jmgarridopaz.taskmanagement.adapters.forgettingdepartments.web;

import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamservice.Department;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamservice.ForGettingDepartments;


public class ForGettingDepartmentsWebAdapter implements ForGettingDepartments {

	private final String restApiUrl;
	
	
	public ForGettingDepartmentsWebAdapter(String restApiUrl) {
		this.restApiUrl = restApiUrl;
	}

	@Override
	public Department getDepartmentFromId(String departmentId) {
		// Makes a http request to the rest api method
		// Gets the JSON data
		// Translate JSON into Department objects
		throw new RuntimeException("Web Adapter Not Implemented");
	}
	
}
