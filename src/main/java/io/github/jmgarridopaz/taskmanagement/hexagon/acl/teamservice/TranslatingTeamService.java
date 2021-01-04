package io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamservice;

import java.util.List;

import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Team;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamService;


public class TranslatingTeamService implements TeamService {

	private final ForGettingDepartments departmentRepository;
	
	public TranslatingTeamService ( ForGettingDepartments departmentRepository ) {
		this.departmentRepository = departmentRepository;
	}

	
	@Override
	public Team getTeamFromId ( String teamId ) {
		Department department = this.departmentRepository.getDepartmentFromId ( teamId );
		String teamName = department.name();
		return new Team ( teamId, teamName );
	}

}
