package io.github.jmgarridopaz.taskmanagement.startup;

import io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.ForAssigningTasksTestAdapter;
import io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.sut.HexagonInitializer;


public class TaskManagement {

	/*
	 * Instantiates and runs the test driver adapter for the driver port.
	 * The test adapter has a configurable dependency on a hexagon initializer instead of the hexagon itself.
	 * This is because tests cases need to init the driven side with suitable values for the tests.
	 */
	public static void main ( String[] args ) {		
		HexagonInitializer hexagonInitializer = new DependencyConfigurator();
		ForAssigningTasksTestAdapter forAssigningTasksTestAdapter = new ForAssigningTasksTestAdapter(hexagonInitializer);
		forAssigningTasksTestAdapter.run();
	}
		
}
