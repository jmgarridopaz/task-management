package io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamgroupservice;

import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Team;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamGroupService;


public class TeamGroupGetter implements TeamGroupService {

	private final ForGettingDepartments departmentRepository;
	
	public TeamGroupGetter ( ForGettingDepartments departmentRepository ) {
		this.departmentRepository = departmentRepository;
	}

	
	@Override
	public Team getTeam() {
		Department rootDepartment = this.departmentRepository.getRootDepartment();
		return new Team ( rootDepartment.name() );
	}

}
