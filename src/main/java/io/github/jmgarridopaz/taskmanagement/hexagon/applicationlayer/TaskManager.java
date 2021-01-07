package io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer;

import java.time.LocalDate;
import java.util.List;

import io.github.jmgarridopaz.taskmanagement.hexagon.domain.ForStoringTasks;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Team;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamService;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamMember;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamMemberService;


public class TaskManager implements ForAssigningTasks {

	private final TeamService teamGroupService;
	private final TeamMemberService teamMemberService;
	private final ForStoringTasks taskRepository;

	
	public TaskManager(TeamService teamGroupService, TeamMemberService teamMemberService, ForStoringTasks taskRepository) {
		this.teamGroupService = teamGroupService;
		this.teamMemberService = teamMemberService;
		this.taskRepository = taskRepository;
	}

	
	@Override
	public TeamWithMembers getTeamOf(String teamMemberEmail) {
		TeamMember teamMember = this.teamMemberService.getByEmail ( teamMemberEmail );
		teamMember.
	}


	@Override
	public void assignTaskToTeamMember(String taskTitle, LocalDate taskDeliveryDate, String teamMemberId) {
		// TODO Auto-generated method stub	
	}

	@Override
	public TeamMemberWithTasks getTasksAssignedTo(String teamMemberId) {
		// TODO Auto-generated method stub
		return null;
	}

}
