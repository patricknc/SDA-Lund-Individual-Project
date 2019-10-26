package toDoList;

import java.util.ArrayList;

import model.Task;

public class Project {
	
	private int projectId;
	private String projectTitle;
	private Task task;
	
	public Project() {}
	
	public Project(int projectId, String projectTitle) {
		this.setProjectId(projectId);
		this.setProjectTitle(projectTitle);
	}

	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		if(projectId <= 100)
			throw new IllegalArgumentException();
		this.projectId = projectId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}	
}
