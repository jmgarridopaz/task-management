package io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice;

import java.util.ArrayList;
import java.util.List;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamMember;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamMemberService;


public class TeamMemberGetter implements TeamMemberService {

	private final ForGettingEmployees employeesRepository;	
	
	public TeamMemberGetter(ForGettingEmployees employeesRepository) {
		this.employeesRepository = employeesRepository;
	}

	@Override
	public List<TeamMember> getAll() {
		List<Employee> employees = this.employeesRepository.getAllEmployees();
		List<TeamMember> teamMembers = new ArrayList<TeamMember>();
		for ( Employee employee : employees ) {
			String teamMemberId = employee.id();
			String teamMemberName = employee.firstName() + " " + employee.lastName();
			String teamMemberEmail = employee.email();
			String groupId = employee.departmentId();
			TeamMember teamMember = new TeamMember(teamMemberId, teamMemberName, teamMemberEmail, groupId);
			teamMembers.add ( teamMember );
		}
		return teamMembers;
	}

}
