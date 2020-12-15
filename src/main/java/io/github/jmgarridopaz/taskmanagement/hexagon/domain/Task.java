package io.github.jmgarridopaz.taskmanagement.hexagon.domain;

import java.time.LocalDate;
import java.util.UUID;

/*
 * Entity (aggregate root)
 */
public class Task {

		String id;
		String title;
		LocalDate deliveryDate;
		String teamMemberId;
		
		private Task (String id, String title, LocalDate deliveryDate, String teamMemberId ) {
			this.id = id;
			this.title = title;
			this.deliveryDate = deliveryDate;
			this.teamMemberId = teamMemberId;
		}

		public static Task assignToTeamMember (String teamMemberId, String taskTitle, LocalDate taskDeliveryDate ) {
			String taskId = UUID.randomUUID().toString();
			return new Task  ( taskId, taskTitle, taskDeliveryDate, teamMemberId);
		}

		@Override
		public String toString() {
			return String.format("Task [id=%s, title=%s, deliveryDate=%s, teamMemberId=%s]", id, title, deliveryDate, teamMemberId);
		}

}
