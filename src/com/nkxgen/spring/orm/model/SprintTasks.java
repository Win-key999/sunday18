package com.nkxgen.spring.orm.model;

public class SprintTasks {
	private int sprnId;
	private int taskId;
	private int userId;

	public SprintTasks(int sprnId, int taskId, int userId) {
		this.sprnId = sprnId;
		this.taskId = taskId;
		this.userId = userId;
	}

	public SprintTasks() {
		super();
	}

	public int getSprnId() {
		return sprnId;
	}

	public void setSprnId(int sprnId) {
		this.sprnId = sprnId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
