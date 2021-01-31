package io.github.jmgarridopaz.taskmanagement.adapters.forstoringtasks.fake;

import java.util.HashMap;
import java.util.Map;

import io.github.jmgarridopaz.taskmanagement.hexagon.domain.ForStoringTasks;
import io.github.jmgarridopaz.taskmanagement.hexagon.domain.Task;


public class ForStoringTasksFakeAdapter implements ForStoringTasks {

	private Map<String,Task> inmemoryDatabase;
	private String nextId;
	
	public ForStoringTasksFakeAdapter(String nextId) {
		this.inmemoryDatabase = new HashMap<String,Task>();
		this.nextId = nextId;
	}

	@Override
	public String nextId() {
		return this.nextId;
	}

	@Override
	public void storeTask(Task task) {
		this.inmemoryDatabase.put ( task.id(), task );
	}

	@Override
	public Task findById(String taskId) {
		return this.inmemoryDatabase.get(taskId);
	}

}
