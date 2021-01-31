package io.github.jmgarridopaz.taskmanagement.hexagon.domain;

/*
 * Driven Port
 */
public interface ForStoringTasks {

	public String nextId ();

	public void storeTask ( Task task );

	public Task findById ( String taskId );

}
