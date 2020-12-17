package io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer;

import java.time.LocalDate;


/*
 * Driver Port
 */
public interface ForAssigningTasks {

	public TeamWithMembers getAllMembersOfTeam();
	
	public void assignTaskToTeamMember ( String taskTitle, LocalDate taskDeliveryDate, String teamMemberId );

	public TeamMemberWithTasks getTasksAssignedTo ( String teamMemberId );
	
}
