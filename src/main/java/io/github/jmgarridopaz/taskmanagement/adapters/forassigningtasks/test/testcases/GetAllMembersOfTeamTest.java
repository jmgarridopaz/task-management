package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.testcases;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.sut.SystemUnderTest;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamgroupservice.Department;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice.Employee;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.ForAssigningTasks;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.TeamWithMembers;


public class GetAllMembersOfTeamTest {

	private ForAssigningTasks forAssigningTasks;
	private TeamWithMembers teamWithMembers;

	// Before running each test in this class
	@BeforeEach
	public void resetScenarioContext() {
		this.forAssigningTasks = null;
		this.teamWithMembers = null;
	}

	@Test
	@DisplayName("GetAllMembersOfTeam Test")
	public void test() {
		givenTheFollowingDepartmentsAndEmployees ( Given.departments(), Given.employees() );
		whenIAskForAllMembersOfTeam();		
		thenIShouldGetTheFollowingTeamWithMembers  ( Then.expectedTeamWithMembers() );
	}
	

	
	private void givenTheFollowingDepartmentsAndEmployees ( Department[] departments, Employee[] employees ) {
		System.out.println("GIVEN the following departments:");
		for ( Department department : departments ) {
			System.out.println(department);
		}
		System.out.println("AND the following employees:");
		for ( Employee employee : employees ) {
			System.out.println(employee);
		}
		this.forAssigningTasks = SystemUnderTest.initWith ( departments, employees );
	}
	
	private void whenIAskForAllMembersOfTeam() {
		System.out.println("WHEN I ask for all members of team");
		this.teamWithMembers = this.forAssigningTasks.getAllMembersOfTeam();
	}
	
	private void thenIShouldGetTheFollowingTeamWithMembers ( TeamWithMembers expectedTeamWithMembers ) {
		System.out.println("THEN I should get the following team with members:");
		System.out.println ( expectedTeamWithMembers );
		assertTrue ( Objects.equals(this.teamWithMembers,expectedTeamWithMembers), "TeamWithMembers assertion error: Expected = " + expectedTeamWithMembers + ". Returned = " +  this.teamWithMembers );
	}

}
