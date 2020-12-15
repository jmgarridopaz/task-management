package io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice;

/*
 * DTO: Data Transfer Object
 */
public class Employee {

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String managerId;
	private String departmentId;

		
	public Employee(String id, String firstName, String lastName, String email, String managerId, String departmentId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.managerId = managerId;
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

	public String managerId() {
		return managerId;
	}
	
	public String departmentId() {
		return departmentId;
	}
	
}
