package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.sut;

import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.ForAssigningTasks;


public interface HexagonInitializer {

	public ForAssigningTasks initForAssigningTasksFrom ( String[][] departments, String[][] employees );
		
}
