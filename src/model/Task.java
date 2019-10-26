package model;

import toDoList.Project;

public class Task {
	
	private int taskId;
	private String taskTitle;
	private String startDate;
	private String dueDate;
	private String status;
	private String project;
	
	public Task() {}
	
	public Task(int taskId, String taskTitle,String dueDate, String status,String project) {
		this.setTaskId(taskId);
		this.setTaskTitle(taskTitle);
		this.setStartDate(startDate);
		this.setDueDate(dueDate);
		this.setStatus(status);
		this.setProject(project);
	}

	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		if(taskId <= 0)
			throw new IllegalArgumentException();
		this.taskId = taskId;
	}

	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}

	public String toString() {
		return this.getTaskId()+","+this.getTaskTitle()+","+this.getDueDate()+","+this.getStatus()+","+this.getProject();
	}
}
