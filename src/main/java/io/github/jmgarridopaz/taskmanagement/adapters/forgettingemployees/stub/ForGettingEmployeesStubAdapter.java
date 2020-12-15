package io.github.jmgarridopaz.taskmanagement.adapters.forgettingemployees.stub;

import java.util.ArrayList;
import java.util.List;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice.Employee;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice.ForGettingEmployees;


public class ForGettingEmployeesStubAdapter implements ForGettingEmployees {

	private final String[][] employees;
	
	/*
	 * Array of employees
	 * Each employee is an array too with 6 strings: [id,firstName,lastName,email,managerId,departmentId]
	 */
	public ForGettingEmployeesStubAdapter ( String[] ... employees ) {
		this.employees = employees;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		for ( String[] employee : this.employees ) {
			employeeList.add ( new Employee(employee[0],employee[1],employee[2],employee[3],employee[4],employee[5]) );
		}
		return employeeList;
	}
	
}
