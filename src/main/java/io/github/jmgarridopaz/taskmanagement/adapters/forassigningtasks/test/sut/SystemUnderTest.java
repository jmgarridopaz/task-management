package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.sut;

import io.github.jmgarridopaz.taskmanagement.hexagon.acl.Employee;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.User;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.ForAssigningTasks;


public enum SystemUnderTest {

	HEXAGON_INITIALIZER;
	
	private HexagonInitializer instance;
	
	public void set ( HexagonInitializer hexagonInitializer ) {
		this.instance = hexagonInitializer;
	}

	public static ForAssigningTasks initWith (Employee employee, User user, String nextTaskId ) {
		return SystemUnderTest.HEXAGON_INITIALIZER.instance.initForAssigningTasksFrom(employee,user,nextTaskId);
	}
	
}
