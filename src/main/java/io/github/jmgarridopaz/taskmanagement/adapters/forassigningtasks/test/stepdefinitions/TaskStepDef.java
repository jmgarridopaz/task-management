package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.AssignTaskRequest;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Assignee;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Task;


public class TaskStepDef {
	
	private final ScenarioContext scenarioContext;

	public TaskStepDef( ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext ;
	}
	
	@Given("next available task id is {string}")
	public void next_available_task_id_is ( String nextTaskId ) {
		this.scenarioContext.setNextTaskId ( nextTaskId );
	}

	@When("I do the following request for assigning a task:")
	public void i_do_the_following_request_for_assigning_a_task ( Map<String,String> column ) {
		String taskTitle = column.get("TASK_TITLE");
		LocalDate taskDueDate = LocalDate.parse ( column.get("TASK_DUE_DATE") );
		String assigneeId = column.get("ASSIGNEE_ID");
		AssignTaskRequest assignTaskRequest = new AssignTaskRequest(taskTitle, taskDueDate, assigneeId);
		this.scenarioContext.forAssigningTasks().assignTask(assignTaskRequest);
	}

	
	@Then("this task should have been stored:")
	public void this_task_should_have_been_stored ( List<Map<String,String>> dataTable ) {
		
		// Expected values
		Map<String,String> row = dataTable.get(0);
		String expectedTaskId = row.get("ID");
		String expectedTaskTitle = row.get("TITLE");
		LocalDate expectedTaskDueDate = LocalDate.parse ( row.get("DUE_DATE") );
		Assignee expectedAssignee = new Assignee ( row.get("ASSIGNEE_ID"), row.get("ASSIGNEE_NAME"), row.get("ASSIGNEE_EMAIL") );
		
		// Stored values
		String nextTaskId = this.scenarioContext.nextTaskId();
		Task storedTask = this.scenarioContext.forAssigningTasks().getTaskById(nextTaskId);
		
		// Check
		boolean storedTaskShouldeBeExpectedTask =	storedTask.id().equals(expectedTaskId) &&
													storedTask.title().equals(expectedTaskTitle) &&
													storedTask.dueDate().equals(expectedTaskDueDate) &&
													storedTask.assignee().equals(expectedAssignee);
		assertTrue ( storedTaskShouldeBeExpectedTask );		
	}
	
}
