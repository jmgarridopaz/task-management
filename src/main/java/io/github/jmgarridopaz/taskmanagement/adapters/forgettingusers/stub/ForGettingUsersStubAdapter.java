package io.github.jmgarridopaz.taskmanagement.adapters.forgettingusers.stub;

import io.github.jmgarridopaz.taskmanagement.hexagon.acl.ForGettingUsers;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.User;


public class ForGettingUsersStubAdapter implements ForGettingUsers {

	private final User user;
	
	public ForGettingUsersStubAdapter ( User user ) {
		this.user = user;
	}

	@Override
	public User getUserFromId ( String userId ) {
		if ( ! this.user.id().equals(userId) ) {
			throw new IllegalArgumentException("User id '"+userId+"' does not exist");
		}
		return this.user;
	}

}
