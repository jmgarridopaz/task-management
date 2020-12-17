package io.github.jmgarridopaz.taskmanagement.adapters.forgettingdepartments.stub;

import java.util.ArrayList;
import java.util.List;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamgroupservice.Department;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamgroupservice.ForGettingDepartments;


public class ForGettingDepartmentsStubAdapter implements ForGettingDepartments {

	private final Department[] departments;
	
	public ForGettingDepartmentsStubAdapter ( Department ... departments ) {
		this.departments = departments;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departmentList = new ArrayList<Department>();
		for ( Department department : this.departments ) {
			departmentList.add(department);
		}
		return departmentList;
	}
	
}
