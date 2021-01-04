package io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer;

import java.util.List;

import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Task;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamMember;

/*
 * DPO : Domain Payload Object
 */
public class TeamMemberWithTasks {

	private TeamMember teamMember;
	private List<Task> tasks;
	
	
	public TeamMemberWithTasks(TeamMember teamMember, List<Task> tasks) {
		this.teamMember = teamMember;
		this.tasks = tasks;
	}
	
	public TeamMember teamMember() {
		return teamMember;
	}
	
	public List<Task> tasks() {
		return tasks;
	}
	
}
