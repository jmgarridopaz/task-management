package io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer;

import java.util.List;

import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Team;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamMember;

/*
 * DPO : Domain Payload Object
 */
public class TeamWithMembers {

	private Team team;
	private List<TeamMember> teamMembers;
	
	
	public TeamWithMembers(Team team, List<TeamMember> teamMembers) {
		this.team = team;
		this.teamMembers = teamMembers;
	}
	
	public Team team() {
		return team;
	}
	
	public List<TeamMember> teamMembers() {
		return teamMembers;
	}
	
}
