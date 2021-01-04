package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test;

import io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.sut.HexagonInitializer;
import io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.sut.SystemUnderTest;


/*
 * Adapter for testing "for assigning tasks" driver port.
 * 
 * Uses Cucumber and Junit5 for running test cases (feature files)
 * 
 * Test cases need to init the driven actors the hexagon depends on with some data,
 * so the adapter has a configurable dependency on an hexagon initializer for doing it.
 * 
 */
public class ForAssigningTasksTestAdapter {

	private final HexagonInitializer hexagonInitializer;

	
	public ForAssigningTasksTestAdapter ( HexagonInitializer hexagonInitializer ) {
		this.hexagonInitializer = hexagonInitializer;
	}


	/*
	 * Launches junit5 platform with cucumber as engine,
	 * for discovering and execute feature files as test cases.
	 */
	public void run() {	
		SystemUnderTest.HEXAGON_INITIALIZER.set(this.hexagonInitializer);
		org.junit.platform.console.ConsoleLauncher.main ( new String[] { "--include-engine=cucumber", "--select-package=testcases" } );
	}
	
}
