package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.stepdefinitions;

import java.util.List;
import java.util.Map;
import io.cucumber.java.en.Given;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.User;

public class UserStepDef {
	
	private final ScenarioContext scenarioContext;

	public UserStepDef( ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext ;
	}
		
	@Given("there exist this user:")
	public void there_exist_this_user ( List<Map<String,String>> dataTable ) {
		Map<String,String> row = dataTable.get(0);
		String id = row.get("ID");
		String login = row.get("LOGIN");
		String password = row.get("PASSWORD");
		User user = new User(id, login, password);
		this.scenarioContext.setUser(user);
	}
	
}
