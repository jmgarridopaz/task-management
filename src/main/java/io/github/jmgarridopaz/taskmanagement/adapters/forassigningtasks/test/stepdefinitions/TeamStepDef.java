package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamMember;


public class TeamStepDef {
	
	private final ScenarioContext scenarioContext;

	public TeamStepDef( ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext ;
	}
	

	@When("employee with id {string} asks the app for the members of the team")
    public void employee_with_id_asks_the_app_for_the_members_of_the_team ( String employeeId ) {
		List<TeamMember> teamMembers = this.scenarioContext.forAssigningTasks().getAllTeamMembers();
		this.scenarioContext.setTeamMembers ( teamMembers );
    }
	
	
	@Then("I should get these team members:")
	public void i_should_get_these_team_members ( List<Map<String,String>> dataTable) {
		List<TeamMember> expectedTeamMembers = teamMembersFromDataTable ( dataTable );
		List<TeamMember> returnedTeamMembers = this.scenarioContext.teamMembers();
		assertEquals ( expectedTeamMembers, returnedTeamMembers );
    }


	private List<TeamMember> teamMembersFromDataTable(List<Map<String, String>> dataTable) {
		List<TeamMember> teamMembers = new ArrayList<TeamMember>();
		for ( Map<String,String> row : dataTable ) {
			String id = row.get("MEMBER_ID");
			String name = row.get("MEMBER_NAME");
			String email = row.get("MEMBER_EMAIL");
			String groupId = row.get("GROUP_ID");
			TeamMember teamMember = new TeamMember(id, name, email, groupId);
			teamMembers.add(teamMember);
		}
		return teamMembers;
	}
		
}
