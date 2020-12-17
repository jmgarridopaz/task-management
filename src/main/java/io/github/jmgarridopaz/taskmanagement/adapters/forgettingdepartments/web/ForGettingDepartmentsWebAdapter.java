package io.github.jmgarridopaz.taskmanagement.adapters.forgettingdepartments.web;

import java.util.List;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamgroupservice.Department;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamgroupservice.ForGettingDepartments;


public class ForGettingDepartmentsWebAdapter implements ForGettingDepartments {

	private final String restApiUrl;
	
	
	public ForGettingDepartmentsWebAdapter(String restApiUrl) {
		this.restApiUrl = restApiUrl;
	}

	@Override
	public List<Department> getAllDepartments() {
		// Makes a http request to the rest api method
		// Gets the JSON data
		// Translate JSON into Department objects
		throw new RuntimeException("Web Adapter Not Implemented");
	}
	
}
