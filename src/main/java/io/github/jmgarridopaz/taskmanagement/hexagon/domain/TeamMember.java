package io.github.jmgarridopaz.taskmanagement.hexagon.domain;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(email, groupId, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TeamMember)) {
			return false;
		}
		TeamMember other = (TeamMember) obj;
		return Objects.equals(email, other.email) && Objects.equals(groupId, other.groupId)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return String.format("TeamMember [id=%s, name=%s, email=%s, groupId=%s]", id, name, email, groupId);
	}	
	
}
