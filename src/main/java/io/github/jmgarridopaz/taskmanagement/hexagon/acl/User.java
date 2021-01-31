package io.github.jmgarridopaz.taskmanagement.hexagon.acl;

/*
 * DTO: Data Transfer Object
 */
public class User {

	private String id;
	private String login;
	private String password;
	
	public User(String id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public String id() {
		return id;
	}

	public String login() {
		return login;
	}

	public String password() {
		return password;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, login=%s, password=%s]", id, login, password);
	}
	
}
