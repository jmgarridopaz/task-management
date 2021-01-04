package io.github.jmgarridopaz.taskmanagement.startup;

import io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.sut.HexagonInitializer;

import io.github.jmgarridopaz.taskmanagement.adapters.forgettingdepartments.stub.ForGettingDepartmentsStubAdapter;
import io.github.jmgarridopaz.taskmanagement.adapters.forgettingemployees.stub.ForGettingEmployeesStubAdapter;
import io.github.jmgarridopaz.taskmanagement.hexagon.Hexagon;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice.Employee;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice.ForGettingEmployees;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamservice.Department;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamservice.ForGettingDepartments;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.ForAssigningTasks;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.ForStoringTasks;


public class DependencyConfigurator implements HexagonInitializer {

	@Override
	public ForAssigningTasks initForAssigningTasksFrom ( Department[] departments, Employee[] employees) {
		
		// Init driven adapters
		ForGettingDepartments departmentRepository = new ForGettingDepartmentsStubAdapter(departments);
		ForGettingEmployees employeeRepository = new ForGettingEmployeesStubAdapter(employees);
		ForStoringTasks taskRepository = null;
		
		// Builds hexagon with a configurable dependency on driven ports
		Hexagon hexagon = new Hexagon(taskRepository, departmentRepository, employeeRepository);
		
		// Returns a driver port of the hexagon
		return hexagon.forAssigningTasks();
	}

}
