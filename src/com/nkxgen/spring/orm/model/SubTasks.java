package com.nkxgen.spring.orm.model;

public class SubTasks {
	private Integer task_id;
	private Integer sbts_id;
	private Integer sbts_parent_sbts_id;

	public SubTasks(Integer task_id, Integer sbts_id, Integer sbts_parent_sbts_id) {
		super();
		this.task_id = task_id;
		this.sbts_id = sbts_id;
		this.sbts_parent_sbts_id = sbts_parent_sbts_id;
	}

	public Integer getTask_id() {
		return task_id;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	public Integer getSbts_id() {
		return sbts_id;
	}

	public void setSbts_id(Integer sbts_id) {
		this.sbts_id = sbts_id;
	}

	public Integer getSbts_parent_sbts_id() {
		return sbts_parent_sbts_id;
	}

	public void setSbts_parent_sbts_id(Integer sbts_parent_sbts_id) {
		this.sbts_parent_sbts_id = sbts_parent_sbts_id;
	}

	public SubTasks() {
		super();
	}

}
