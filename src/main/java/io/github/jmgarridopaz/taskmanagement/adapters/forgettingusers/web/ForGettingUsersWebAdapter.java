package io.github.jmgarridopaz.taskmanagement.adapters.forgettingusers.web;

import io.github.jmgarridopaz.taskmanagement.hexagon.acl.ForGettingUsers;
import io.github.jmgarridopaz.taskmanagement.hexagon.acl.User;


public class ForGettingUsersWebAdapter implements ForGettingUsers {

	private final String restApiUrl;
	
	
	public ForGettingUsersWebAdapter ( String restApiUrl ) {
		this.restApiUrl = restApiUrl;
	}

	@Override
	public User getUserFromId(String userId) {
		// Makes a http request to the rest api method
		// Gets the JSON data
		// Translate JSON into User object
		throw new RuntimeException("Web Adapter Not Implemented");
	}
	
}
