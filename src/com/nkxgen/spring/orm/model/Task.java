package com.nkxgen.spring.orm.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "s4_tasks")
public class Task {
	@Id
	private int task_id;
	private String task_name;
	private Timestamp task_cdatetime;
	private String task_type;
	private int task_ref_task_id;
	private String task_category;
	private String task_desc;
	private int task_creator;
	private double task_noh_reqd;
	private Timestamp task_exp_datetime;
	private Timestamp task_cmp_datetime;
	private int task_supervisor;
	private String task_remarks;
	private String task_status;
	private int proj_id;
	private int modl_id;

	// Constructors

	public Task() {
	}

	public Task(int task_id, String task_name, Timestamp task_cdatetime, String task_type, int task_ref_task_id,
			String task_category, String task_desc, int task_creator, double task_noh_reqd, Timestamp task_exp_datetime,
			Timestamp task_cmp_datetime, int task_supervisor, String task_remarks, String task_status, int proj_id,
			int modl_id) {
		this.task_id = task_id;
		this.task_name = task_name;
		this.task_cdatetime = task_cdatetime;
		this.task_type = task_type;
		this.task_ref_task_id = task_ref_task_id;
		this.task_category = task_category;
		this.task_desc = task_desc;
		this.task_creator = task_creator;
		this.task_noh_reqd = task_noh_reqd;
		this.task_exp_datetime = task_exp_datetime;
		this.task_cmp_datetime = task_cmp_datetime;
		this.task_supervisor = task_supervisor;
		this.task_remarks = task_remarks;
		this.task_status = task_status;
		this.proj_id = proj_id;
		this.modl_id = modl_id;
	}

	// Getters and Setters

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public Timestamp getTask_cdatetime() {
		return task_cdatetime;
	}

	public void setTask_cdatetime(Timestamp task_cdatetime) {
		this.task_cdatetime = task_cdatetime;
	}

	public String getTask_type() {
		return task_type;
	}

	public void setTask_type(String task_type) {
		this.task_type = task_type;
	}

	public int getTask_ref_task_id() {
		return task_ref_task_id;
	}

	public void setTask_ref_task_id(int task_ref_task_id) {
		this.task_ref_task_id = task_ref_task_id;
	}

	public String getTask_category() {
		return task_category;
	}

	public void setTask_category(String task_category) {
		this.task_category = task_category;
	}

	public String getTask_desc() {
		return task_desc;
	}

	public void setTask_desc(String task_desc) {
		this.task_desc = task_desc;
	}

	public int getTask_creator() {
		return task_creator;
	}

	public void setTask_creator(int task_creator) {
		this.task_creator = task_creator;
	}

	public double getTask_noh_reqd() {
		return task_noh_reqd;
	}

	public void setTask_noh_reqd(double task_noh_reqd) {
		this.task_noh_reqd = task_noh_reqd;
	}

	public Timestamp getTask_exp_datetime() {
		return task_exp_datetime;
	}

	public void setTask_exp_datetime(Timestamp task_exp_datetime) {
		this.task_exp_datetime = task_exp_datetime;
	}

	public Timestamp getTask_cmp_datetime() {
		return task_cmp_datetime;
	}

	public void setTask_cmp_datetime(Timestamp task_cmp_datetime) {
		this.task_cmp_datetime = task_cmp_datetime;
	}

	public int getTask_supervisor() {
		return task_supervisor;
	}

	public void setTask_supervisor(int task_supervisor) {
		this.task_supervisor = task_supervisor;
	}

	public String getTask_remarks() {
		return task_remarks;
	}

	public void setTask_remarks(String task_remarks) {
		this.task_remarks = task_remarks;
	}

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	public int getProj_id() {
		return proj_id;
	}

	public void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}

	public int getModl_id() {
		return modl_id;
	}

	public void setModl_id(int modl_id) {
		this.modl_id = modl_id;
	}
}
