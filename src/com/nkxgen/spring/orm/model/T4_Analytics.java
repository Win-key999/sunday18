package com.nkxgen.spring.orm.model;

import java.sql.Date;
import java.util.HashMap;

public class T4_Analytics {
	private String task_name;
	private Integer task_working_hours;
	private String project_name;
	private Double project_working_hours;

	public void setProject_working_hours(Double project_working_hours) {
		this.project_working_hours = project_working_hours;
	}

	private String sub_task_name;
	private Integer sub_task_working_hours;
	private String module_name;
	private Integer module_working_hours;
	private HashMap<Date, String> past_30_days_analytics;

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public Integer getTask_working_hours() {
		return task_working_hours;
	}

	public void setTask_working_hours(Integer task_working_hours) {
		this.task_working_hours = task_working_hours;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getSub_task_name() {
		return sub_task_name;
	}

	public void setSub_task_name(String sub_task_name) {
		this.sub_task_name = sub_task_name;
	}

	public Integer getSub_task_working_hours() {
		return sub_task_working_hours;
	}

	public void setSub_task_working_hours(Integer sub_task_working_hours) {
		this.sub_task_working_hours = sub_task_working_hours;
	}

	public String getModule_name() {
		return module_name;
	}

	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	public Integer getModule_working_hours() {
		return module_working_hours;
	}

	public void setModule_working_hours(Integer module_working_hours) {
		this.module_working_hours = module_working_hours;
	}

	public HashMap<Date, String> getPast_30_days_analytics() {
		return past_30_days_analytics;
	}

	public void setPast_30_days_analytics(HashMap<Date, String> past_30_days_analytics) {
		this.past_30_days_analytics = past_30_days_analytics;
	}

	public T4_Analytics(String task_name, Integer task_working_hours, String project_name, Double project_working_hours,
			String sub_task_name, Integer sub_task_working_hours, String module_name, Integer module_working_hours,
			HashMap<Date, String> past_30_days_analytics) {
		super();
		this.task_name = task_name;
		this.task_working_hours = task_working_hours;
		this.project_name = project_name;
		this.project_working_hours = project_working_hours;
		this.sub_task_name = sub_task_name;
		this.sub_task_working_hours = sub_task_working_hours;
		this.module_name = module_name;
		this.module_working_hours = module_working_hours;
		this.past_30_days_analytics = past_30_days_analytics;
	}

	public T4_Analytics() {
	}

}
