package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test;

import io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.runner.JUnit5Runner;
import io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.sut.HexagonInitializer;
import io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.sut.SystemUnderTest;
import io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.testcases.GetAllMembersOfTeamTest;


public class ForAssigningTasksTestAdapter {

	private final HexagonInitializer hexagonInitializer;

	
	public ForAssigningTasksTestAdapter ( HexagonInitializer hexagonInitializer ) {
		this.hexagonInitializer = hexagonInitializer;
	}

	
	public void run() {
		SystemUnderTest.HEXAGON_INITIALIZER.set(this.hexagonInitializer);
		JUnit5Runner junit5Runner = new JUnit5Runner();
		junit5Runner.runTestsOfUseCase ( GetAllMembersOfTeamTest.class );
	}
	
}
