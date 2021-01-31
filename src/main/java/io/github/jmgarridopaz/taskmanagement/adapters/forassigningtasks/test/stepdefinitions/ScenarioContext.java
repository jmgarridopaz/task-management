package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.stepdefinitions;

import io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.sut.SystemUnderTest;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.Employee;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.User;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.ForAssigningTasks;

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

	private Employee employee;
	private User user;
	private String nextTaskId;
	private ForAssigningTasks forAssigningTasks;

	
	public ScenarioContext() {
	}
	
	
	public ForAssigningTasks forAssigningTasks() {
		if ( this.forAssigningTasks == null ) {
			this.forAssigningTasks = SystemUnderTest.initWith ( employee, user, nextTaskId );
		}
		return this.forAssigningTasks;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setNextTaskId(String nextTaskId) {
		this.nextTaskId = nextTaskId;		
	}

	public String nextTaskId() {
		return this.nextTaskId;
	}

}
