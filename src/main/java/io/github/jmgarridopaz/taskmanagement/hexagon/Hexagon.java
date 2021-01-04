package io.github.jmgarridopaz.taskmanagement.hexagon
;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice.ForGettingEmployees;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice.TeamMemberGetter;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamservice.ForGettingDepartments;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamservice.TranslatingTeamService;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.ForAssigningTasks;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.TaskManager;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.ForStoringTasks;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamService;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamMemberService;


/*
 * The hexagon has a conigurable dependency on driven ports and offers driver ports 
 */
public class Hexagon {

	// Driven ports
	private final ForStoringTasks taskRepository;
	private final ForGettingDepartments departmentRepository;
	private final ForGettingEmployees employeeRepository;
	
	public Hexagon(ForStoringTasks taskRepository, ForGettingDepartments departmentRepository, ForGettingEmployees employeeRepository) {
		this.taskRepository = taskRepository;
		this.departmentRepository = departmentRepository;
		this.employeeRepository = employeeRepository;
	}

	// Driver port
	public ForAssigningTasks forAssigningTasks() {
		TeamService teamGroupService = new TranslatingTeamService(this.departmentRepository);
		TeamMemberService teamMemberService = new TeamMemberGetter(this.employeeRepository);
		return new TaskManager(teamGroupService, teamMemberService, this.taskRepository);
	}
	
}
