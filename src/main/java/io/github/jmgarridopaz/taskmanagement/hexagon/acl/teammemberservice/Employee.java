package io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice;

/*
 * DTO: Data Transfer Object
 */
public class Employee {

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private boolean isManager;
	private String departmentId;

		
	public Employee(String id, String firstName, String lastName, String email, boolean isManager, String departmentId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isManager = isManager;
		this.departmentId = departmentId;
	}

	public String id() {
		return id;
	}

	public String firstName() {
		return firstName;
	}

	public String lastName() {
		return lastName;
	}

	public String email() {
		return email;
	}

	public boolean isManager() {
		return isManager;
	}
	
	public String departmentId() {
		return departmentId;
	}

	@Override
	public String toString() {
		return String.format(
							"Employee [id=%s, firstName=%s, lastName=%s, email=%s, isManager=%s, departmentId=%s]",
							id, firstName, lastName, email, isManager, departmentId
							);
	}
	
}
