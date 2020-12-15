package io.github.jmgarridopaz.taskmanagement.hexagon.domain;


/*
 * Value Object
 */
public class Team {

	private String name;
	
	
	public Team ( String name ) {
		this.name = name;
	}

	public String name() {
		return name;
	}	
	
}
