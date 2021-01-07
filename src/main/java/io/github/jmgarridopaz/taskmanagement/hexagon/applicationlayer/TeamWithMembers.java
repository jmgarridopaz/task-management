package io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Team;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamMember;

/*
 * DPO : Domain Payload Object
 */
public class TeamWithMembers {

	private Team team;
	private Set<TeamMember> teamMembers;
	
	
	public TeamWithMembers(Team team, TeamMember... teamMembers) {
		this.team = team;
		this.teamMembers = new HashSet<TeamMember>();
		for ( TeamMember teamMember : teamMembers ) {
			this.teamMembers.add(teamMember);
		}
	}
	
	public Team team() {
		return team;
	}
	
	public Set<TeamMember> teamMembers() {
		return teamMembers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(team, teamMembers);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TeamWithMembers)) {
			return false;
		}
		TeamWithMembers other = (TeamWithMembers) obj;
		return Objects.equals(team, other.team) && Objects.equals(teamMembers, other.teamMembers);
	}

	@Override
	public String toString() {
		return String.format("TeamWithMembers [team=%s, teamMembers=%s]", team, teamMembers);
	}
	
}