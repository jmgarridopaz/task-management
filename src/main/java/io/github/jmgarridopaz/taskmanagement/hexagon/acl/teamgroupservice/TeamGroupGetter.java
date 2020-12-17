package io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamgroupservice;

import java.util.List;

import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Team;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamGroupService;


public class TeamGroupGetter implements TeamGroupService {

	private final ForGettingDepartments departmentRepository;
	
	public TeamGroupGetter ( ForGettingDepartments departmentRepository ) {
		this.departmentRepository = departmentRepository;
	}

	
	@Override
	public Team getTeam() {
		
		List<Department> departments = this.departmentRepository.getAllDepartments();
		String teamName = "-";
		int index = 0;
		boolean notFound = true;
		while ( (index < departments.size()) && notFound ) {
			Department department = departments.get(index);
			// The root department doesn't have any upper department 
			if ( department.upperDepartmentId() == null ) {
				teamName = department.name();
				notFound = false;
			}
			index++;
		}
		return new Team ( teamName );
	}

}
