package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.sut;

import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice.Employee;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamservice.Department;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.ForAssigningTasks;


public interface HexagonInitializer {

	public ForAssigningTasks initForAssigningTasksFrom ( Department[] departments, Employee[] employees );
		
}
