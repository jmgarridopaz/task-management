package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.stepdefinitions;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.Employee;

public class EmployeeStepDef {
	
	private final ScenarioContext scenarioContext;

	public EmployeeStepDef( ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext ;
	}
	
	@Given("there exist this employee:")
	public void there_exist_this_employee ( List<Map<String,String>> dataTable ) {
		Map<String,String> row = dataTable.get(0);
		String id = row.get("ID");
		String firstName = row.get("FIRST_NAME");
		String lastName = row.get("LAST_NAME");
		String email = row.get("EMAIL");
		String job = row.get("JOB");
		Employee employee = new Employee(id, firstName, lastName, email, job);
		this.scenarioContext.setEmployee(employee);
	}
	
}
