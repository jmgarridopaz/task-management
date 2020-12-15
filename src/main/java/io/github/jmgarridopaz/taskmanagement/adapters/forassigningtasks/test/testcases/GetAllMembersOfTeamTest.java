package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.testcases;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.sut.SystemUnderTest;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.ForAssigningTasks;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamMember;


public class GetAllMembersOfTeamTest {

	private ForAssigningTasks forAssigningTasks;
	private List<TeamMember> teamMembers;

	// Before running each test in this class
	@BeforeEach
	public void resetScenarioContext() {
		this.forAssigningTasks = null;
		this.teamMembers = null;
	}

	@Test
	@DisplayName("AvailableTeamMembers Test")
	public void test() {
		
		givenTheFollowingDepartmentsAndEmployees ( Given.departments(), Given.employees() );
		
		whenIAskForAllMembersOfTeam();
		
		String[] tm1 = new String[] { "juan", "juan@email.com", "Acme" };
		String[] tm2 = new String[] { "pepito", "pepito@email.com", "Management" };
		String[] tm3 = new String[] { "fulanito", "fulanito@email.com", "Management" };
		String[][] expectedTeamMembers = new String[][] { tm1, tm2, tm3 };		
		
		thenIShouldGetTheFollowingTeamWithMembers  ( Then.expectedTeamWithMembers() );
		
	}
	

	private void givenTheFollowingDepartmentsAndEmployees(List<Department> departments, List<Employee> employees) {
		System.out.println("GIVEN the following departments exist [id,name,upperDepartmentId,bossId]:");
		System.out.println(arraysToString(departments));
		System.out.println("AND the following employees exist [id,fullName,alias,email,departmentId]:");
		System.out.println(arraysToString(employees));
		this.forAssigningTasks = SystemUnderTest.initWith ( departments, employees );
	}

	
	private void whenIAskForTheAvailableTeamMembers() {
		System.out.println("WHEN I ask for the available team members");
		this.teamMembers = this.forAssigningTasks.getAllMembersOfTeam();
	}

	
	private void thenIShouldGetTheFollowingTeamMembers ( String[][] expectedTeamMembers ) {
		System.out.println("THEN I should get the folloing team members [alias,email,groupName]:");
		System.out.println(arraysToString(expectedTeamMembers));
		assertTrue ( equalsTeamMemberList(this.teamMembers,expectedTeamMembers), "AvailableTeamMembers assertion error: Expected = " + arraysToString (expectedTeamMembers) + ". Returned = " +  listToString(this.teamMembers) );
	}


	private String arraysToString ( String[][] fooArray ) {
		String result = "[";
		String separator;
		for ( String[] foo : fooArray ) {
			
			String fooString = "[";
			for ( String fooField : foo ) {
				separator = ( "[".equals(fooString) ? "" : "," );
				fooString = fooString + separator + fooField;
			}
			fooString += "]";
			
			separator = ( "[".equals(result) ? "" : "," );
			result = result + separator + fooString;
		}
		result += "]";
		return result;
	}

	
	private String listToString ( List<TeamMember> teamMemberList ) {
		String result = "[";
		for ( TeamMember teamMember : teamMemberList ) {
			String separador = ( ("[".equals(result)) ? "" : "," );
			String teamMemberString = "["+teamMember.nick()+","+teamMember.email()+","+teamMember.groupName()+"]";
			result = result + separador + teamMemberString;
		}
		result += "]";
		return result;
	}

	
	private boolean equalsTeamMemberList(List<TeamMember> teamMembers, String[][] expectedTeamMembers) {
		boolean equals = true;
		int numberOfExpectedTeamMembers = 0;
		for ( String[] expectedTeamMember : expectedTeamMembers ) {
			++numberOfExpectedTeamMembers;
			if ( ! expectedTeamMemberInList  ( expectedTeamMember, teamMembers ) ) {
				equals = false;
				break;
			}
		}
		return ( equals && (teamMembers.size()==numberOfExpectedTeamMembers) );
	}

	
	private boolean expectedTeamMemberInList ( String[] expectedTeamMember, List<TeamMember> teamMembers ) {
		boolean inList = false;
		for ( TeamMember teamMember : teamMembers ) {
			if ( equalsTeamMember (teamMember,expectedTeamMember) ) {
				inList = true;
			}
		}
		return inList;
	}

	
	private boolean equalsTeamMember(TeamMember teamMember, String[] expectedTeamMember) {
		return
				(
				teamMember.nick().equals(expectedTeamMember[0])
				&&
				teamMember.email().equals(expectedTeamMember[1])
				&&
				teamMember.groupName().equals(expectedTeamMember[2])
				);
	}
	
}
