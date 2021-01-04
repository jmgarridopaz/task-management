package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import io.cucumber.java.en.Given;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice.Employee;


public class EmployeeStepDef {
	
	private final ScenarioContext scenarioContext;

	public EmployeeStepDef( ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext ;
	}
	
	
	@Given("there exists these employees:")
    public void there_exists_these_employees ( List<Map<String,String>> dataTable) {
		List<Employee> emps = new ArrayList<Employee>();
		for ( Map<String,String> row : dataTable ) {
			String id = row.get("EMP_ID");
			String firstName = row.get("EMP_FIRST_NAME");
			String lastName = row.get("EMP_LAST_NAME");
			String email = row.get("EMP_EMAIL");
			boolean isManager = "yes".equalsIgnoreCase(row.get("IS_MANAGER"));
			String departmentId = row.get("DEP_ID");
			Employee emp = new Employee(id, firstName, lastName, email, isManager, departmentId);
			emps.add(emp);
		}
		this.scenarioContext.setEmployees(emps);
    }

}
