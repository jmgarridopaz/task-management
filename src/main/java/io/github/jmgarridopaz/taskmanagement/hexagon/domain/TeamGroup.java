package io.github.jmgarridopaz.taskmanagement.hexagon.domain;


/*
 * Value Object
 */
public class TeamGroup {

	private String id;
	private String name;
	
	
	public TeamGroup ( String id, String name ) {
		this.id = id;
		this.name = name;
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}	
	
}
