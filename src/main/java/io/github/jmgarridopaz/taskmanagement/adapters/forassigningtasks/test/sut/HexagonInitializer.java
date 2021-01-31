package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.sut;

import io.github.jmgarridopaz.taskmanagement.hexagon.acl.Employee;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.User;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.ForAssigningTasks;


public interface HexagonInitializer {

	public ForAssigningTasks initForAssigningTasksFrom ( Employee employee, User user, String nextTaskId );
		
}
