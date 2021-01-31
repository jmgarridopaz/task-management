package io.github.jmgarridopaz.taskmanagement.hexagon.domain;

import java.time.LocalDate;
import java.util.Objects;


/*
 * Entity (aggregate root)
 */
public class Task {

	private String id;
	private String title;
	private LocalDate dueDate;
	private Assignee assignee;
		
	public Task (String id, String title, LocalDate dueDate, Assignee assignee ) {
		this.id = id;
		this.title = title;
		this.dueDate = dueDate;
		this.assignee = assignee;
	}

	public String id() {
		return this.id;
	}

	public String title() {
		return this.title;
	}

	public LocalDate dueDate() {
		return this.dueDate;
	}

	public Assignee assignee() {
		return this.assignee;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}

	@Override
	public boolean equals(Object obj) {
		if ( obj == null ) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Task)) {
			return false;
		}
		Task other = (Task) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return String.format
							(
							"Task [id=%s, title=%s, dueDate=%s, assignee=%s]",
							id, title, dueDate, assignee
							);
	}
	
}
