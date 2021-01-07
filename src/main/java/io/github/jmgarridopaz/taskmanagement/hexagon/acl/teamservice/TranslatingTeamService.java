package io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamservice;

import java.util.List;

import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Team;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamService;


public class TranslatingTeamService implements TeamService {

	private final ForGettingDepartments departmentRepository;
	private final TeamTranslator teamTranslator;
	
	public TranslatingTeamService ( ForGettingDepartments departmentRepository, TeamTranslator teamTranslator ) {
		this.departmentRepository = departmentRepository;
		this.teamTranslator = teamTranslator;
	}

	
	@Override
	public Team getTeamFromId ( String teamId ) {
		Department department = this.departmentRepository.getDepartmentFromId ( teamId );
		return this.teamTranslator.fromDepartment(department);
	}

}
