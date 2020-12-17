package io.github.jmgarridopaz.taskmanagement.adapters.forassigningtasks.test.testcases;

import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teamgroupservice.Department;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.teammemberservice.Employee;
import io.github.jmgarridopaz.taskmanagement.hexagon.applicationlayer.TeamWithMembers;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Team;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.TeamMember;

public class Then {

	private Then() {}
	
	public static Department[] departments() {
		Department dep1 = new Department ( "1", "Acme", null );
		Department dep2 = new Department ( "2", "Marketing", "1" );
		return new Department[] { dep1, dep2 };
	}

	public static Employee[] employees() {
		Employee emp1 = new Employee ( "1", "Juan", "Garrido", "juanito@email.com", true, "1" );
		Employee emp2 = new Employee ( "2", "Pepe", "Pérez", "pepito@email.com", false, "1" );
		Employee emp3 = new Employee ( "3", "Fulano", "Mengano", "fulanito@email.com", true, "2" );
		return new Employee[] { emp1, emp2, emp3 };
	}

	public static TeamWithMembers expectedTeamWithMembers() {
		Team team = new Team ( "Acme" );
		TeamMember tm1 = new TeamMember ( "1", "Juan Garrido", "juanito@email.com", "1");
		TeamMember tm2 = new TeamMember ( "2", "Pepe Pérez", "pepito@email.com", "1" );
		TeamMember tm3 = new TeamMember ( "3", "Fulano Mengano", "fulanito@email.com", "2" );
		return new TeamWithMembers ( team, tm1, tm2, tm3 );
	}
	
}

