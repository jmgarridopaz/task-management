package io.github.jmgarridopaz.taskmanagement.adapters.forgettingdepartments.stub;

import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamgroupservice.Department;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamgroupservice.ForGettingDepartments;


public class ForGettingDepartmentsStubAdapter implements ForGettingDepartments {

	private final String[][] departments;
	
	/*
	 * Array of departments
	 * Each departmenent is an array too with 3 strings: [id,name,upperDepartmentId]
	 */
	public ForGettingDepartmentsStubAdapter ( String[] ... departments ) {
		this.departments = departments;
	}

	/*
	 * The upper department of the root department is itself 
	 */
	@Override
	public Department getRootDepartment() {
		for ( String[] department : departments ) {
			if ( department[0].equals(department[2]) ) {
				return new Department(department[0],department[1],department[2] );
			}
		}
		return null;
	}
	
}
