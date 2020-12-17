package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.sut;

import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamgroupservice.Department;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice.Employee;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.ForAssigningTasks;

public enum SystemUnderTest {

	HEXAGON_INITIALIZER;
	
	private HexagonInitializer instance;
	
	public void set ( HexagonInitializer hexagonInitializer ) {
		this.instance = hexagonInitializer;
	}

	public static ForAssigningTasks initWith (Department[] departments, Employee[] employees ) {
		return SystemUnderTest.HEXAGON_INITIALIZER.instance.initForAssigningTasksFrom(departments, employees);
	}
	
}
