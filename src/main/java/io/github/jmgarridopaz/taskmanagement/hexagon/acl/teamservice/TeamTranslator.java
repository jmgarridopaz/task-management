package io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamservice;

import java.util.List;

import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Team;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamService;


public class TeamTranslator {

	public TeamTranslator() {
	}
	
	public Team fromDepartment ( Department department ) {
		String teamId = department.id();
		String teamName = department.name();
		return new Team ( teamId, teamName );
	}

}
