package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import io.cucumber.java.en.Given;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamservice.Department;


public class DepartmentStepDef {
	
	private final ScenarioContext scenarioContext;

	public DepartmentStepDef( ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext ;
	}
	
	@Given("the company has these departments:")
    public void the_company_has_these_departments ( List<Map<String,String>> dataTable ) {
		List<Department> deps = new ArrayList<Department>();
		for ( Map<String,String> row : dataTable ) {
			String id = row.get("DEP_ID");
			String name = row.get("DEP_NAME");
			String upperDepartmentId = row.get("UPPER_DEP_ID");
			Department dep = new Department(id, name, upperDepartmentId);
			deps.add(dep);
		}
		this.scenarioContext.setDepartments(deps);
    }
	
}
