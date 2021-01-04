package io.github.jmgarridopaz.taskmanagement.adapters.forgettingdepartments.stub;

import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamservice.Department;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamservice.ForGettingDepartments;


public class ForGettingDepartmentsStubAdapter implements ForGettingDepartments {

	private final Department[] departments;
	
	public ForGettingDepartmentsStubAdapter ( Department ... departments ) {
		this.departments = departments;
	}

	@Override
	public Department getDepartmentFromId(String departmentId) {
		for ( Department department : this.departments ) {
			if ( department.id().equals(departmentId) ) {
				return department;
			}
		}
		return null;
	}

}
