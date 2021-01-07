package io.github.jmgarridopaz.taskmanagement.hexagon.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
 * VO : Value Object
 */
public class Team {
	
	private String name;
	private Set<TeamMember> teamMembers;
	
	
	public Team ( String teamName, TeamMember... teamMembers) {
		this.name = teamName;
		this.teamMembers = new HashSet<TeamMember>();
		for ( TeamMember teamMember : teamMembers ) {
			this.teamMembers.add(teamMember);
		}
	}
	
	public String name() {
		return this.name;
	}
	
	public Set<TeamMember> teamMembers() {
		return teamMembers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, teamMembers);
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
		return Objects.equals(name, other.name) && Objects.equals(teamMembers, other.teamMembers);
	}

	@Override
	public String toString() {
		return String.format("Team [name=%s, teamMembers=%s]", name, teamMembers);
	}
	
}
