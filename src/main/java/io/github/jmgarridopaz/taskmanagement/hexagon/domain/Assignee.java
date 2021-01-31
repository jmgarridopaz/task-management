package io.github.jmgarridopaz.taskmanagement.hexagon.domain;

import java.util.Objects;

/*
 * VO: Value Object
 */
public class Assignee {

	private String id;
	private String name;
	private String email;
	
	public Assignee ( String id, String name, String email ) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}
	
	public String email() {
		return this.email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Assignee)) {
			return false;
		}
		Assignee other = (Assignee) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return String.format("Assignee [id=%s, name=%s, email=%s]", id, name, email );
	}	
	
}
