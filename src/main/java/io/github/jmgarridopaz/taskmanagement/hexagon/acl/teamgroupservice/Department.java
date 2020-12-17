package io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamgroupservice;


/*
 * DTO: Data Transfer Object
 */
public class Department {

	private String id;
	private String name;
	private String upperDepartmentId;
	
	public Department(String id, String name, String upperDepartmentId) {
		this.id = id;
		this.name = name;
		this.upperDepartmentId = upperDepartmentId;
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}

	public String upperDepartmentId() {
		return upperDepartmentId;
	}

	@Override
	public String toString() {
		return String.format(
							"Department [id=%s, name=%s, upperDepartmentId=%s]",
							id, name, upperDepartmentId
							);
	}	

}
