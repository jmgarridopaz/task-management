package io.github.jmgarridopaz.taskmanagement.hexagon.acl;

/*
 * DTO: Data Transfer Object
 */
public class Employee {

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String job;

		
	public Employee ( String id, String firstName, String lastName, String email, String job ) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.job = job;
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

	public String job() {
		return job;
	}

	@Override
	public String toString() {
		return String.format(
							"Employee [id=%s, firstName=%s, lastName=%s, email=%s, job=%s]",
							id, firstName, lastName, email, job
							);
	}
	
}
