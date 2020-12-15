package io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer;

import java.time.LocalDate;
import java.util.List;

import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Task;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamMember;


/*
 * Driver Port
 */
public interface ForAssigningTasks {

	public TeamWithMembers getAllMembersOfTeam();
	
	public void assignTaskToTeamMember ( String taskTitle, LocalDate taskDeliveryDate, String teamMemberId );

	public TeamMemberWithTasks getTasksAssignedTo ( String teamMemberId );
	
}
