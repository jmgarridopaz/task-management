package io.github.jmgarridopaz.taskmanagement.startup;

import io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.sut.HexagonInitializer;
import io.github.jmgarridopaz.taskmanagement.adapters.forgettingemployees.stub.ForGettingEmployeesStubAdapter;
import io.github.jmgarridopaz.taskmanagement.adapters.forgettingusers.stub.ForGettingUsersStubAdapter;
import io.github.jmgarridopaz.taskmanagement.adapters.forstoringtasks.fake.ForStoringTasksFakeAdapter;
import io.github.jmgarridopaz.taskmanagement.hexagon.Hexagon;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.Employee;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.ForGettingEmployees;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.ForGettingUsers;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.User;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.ForAssigningTasks;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.ForStoringTasks;


public class DependencyConfigurator implements HexagonInitializer {

	@Override
	public ForAssigningTasks initForAssigningTasksFrom(Employee employee, User user, String nextTaskId) {
		
		// Init driven adapters
		ForGettingEmployees employeeRepository = new ForGettingEmployeesStubAdapter(employee);
		ForGettingUsers userRepository = new ForGettingUsersStubAdapter(user);
		ForStoringTasks taskRepository = new ForStoringTasksFakeAdapter ( nextTaskId );
		
		// Builds hexagon with a configurable dependency on driven ports
		Hexagon hexagon = new Hexagon(employeeRepository, userRepository, taskRepository);
		
		// Returns a driver port of the hexagon
		return hexagon.forAssigningTasks();
		
	}

}
