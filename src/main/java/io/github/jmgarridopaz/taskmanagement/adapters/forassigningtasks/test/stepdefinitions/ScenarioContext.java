package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.stepdefinitions;

import java.util.List;

import io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.sut.SystemUnderTest;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice.Employee;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamservice.Department;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.ForAssigningTasks;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamMember;

/**
 * Class for sharing state between different steps files in one scenario.
 * 
 * It is instantiated and injected into the stepdefs by PicoContainer (DI framework).
 * 
 * Put this class in stepdefs package to be recreated for every scenario.
 * 
 * So that there won't be state leakage between scenarios.
 */
public class ScenarioContext {

	private List<Department> departments;
	private List<Employee> employees;
	private ForAssigningTasks forAssigningTasks;
	private List<TeamMember> teamMembers;

	
	public ScenarioContext() {
	}
	
	
	public void setDepartments ( List<Department> deps ) {
		this.departments = deps;		
	}


	public void setEmployees ( List<Employee> emps ) {
		this.employees = emps;
	}


	public ForAssigningTasks forAssigningTasks() {
		if ( this.forAssigningTasks == null ) {
			this.forAssigningTasks = SystemUnderTest.initWith
															(
															departments.toArray(new Department[0]),
															employees.toArray(new Employee[0])
															);
		}
		return this.forAssigningTasks;
	}


	public void setTeamMembers(List<TeamMember> teamMembers) {
		this.teamMembers = teamMembers;
	}


	public List<TeamMember> teamMembers() {
		return this.teamMembers;
	}
	
}
