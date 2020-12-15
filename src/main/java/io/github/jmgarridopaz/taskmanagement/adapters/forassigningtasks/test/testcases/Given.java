package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.testcases;

import java.util.ArrayList;
import java.util.List;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamgroupservice.Department;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice.Employee;

public class Given {

	private Given() {}
	
	public static List<Department> departments() {
		Department dep1 = new Department ( "1", "Acme", "1" );
		Department dep2 = new Department ( "2", "Marketing", "1" );
		List<Department> departments = new ArrayList<Department>();
		departments.add(dep1);
		departments.add(dep2);
		return departments;
	}

	public static List<Employee> employees() {
		Employee emp1 = new Employee("1", "Juan", "Garrido", "juan@email.com", "1", "1");
		Employee emp2 = new Employee("2", "Pepe", "Pérez", "pepito@email.com", "1", "1");
		Employee emp3 = new Employee("3", "Fulano", "Mengano", "fulanito@email.com", "3", "2");
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		return employees;
	}
	
}

