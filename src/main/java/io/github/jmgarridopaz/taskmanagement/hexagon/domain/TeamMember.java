package io.github.jmgarridopaz.taskmanagement.hexagon.domain;


/*
 * Value Object
 */
public class TeamMember {

	private String id;
	private String name;
	private String email;
	private String groupId;
	
	
	public TeamMember ( String id, String name, String email, String groupId ) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.groupId = groupId;
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}

	public String email() {
		return email;
	}

	public String groupId() {
		return groupId;
	}	
	
}

