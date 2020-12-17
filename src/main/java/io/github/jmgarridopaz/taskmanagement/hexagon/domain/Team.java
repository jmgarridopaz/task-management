package io.github.jmgarridopaz.taskmanagement.hexagon.domain;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Team)) {
			return false;
		}
		Team other = (Team) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return String.format("Team [name=%s]", name);
	}	
	
}
