package com.nkxgen.spring.orm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T4_Projects")
public class ProjectModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proj_id")
	private int proj_id;
	@Column(name = "proj_name")
	private String proj_name;
	@Column(name = "proj_desc")
	private String proj_desc;
	@Column(name = "proj_stdate")
	private Date proj_stdate;
	@Column(name = "proj_manager")
	private String proj_manager;
	@Column(name = "proj_status")
	private String proj_status;
	@Column(name = "proj_ludate")
	private Date proj_ludate;

	public ProjectModel() {
	}

	// Getters and Setters

	public ProjectModel(int proj_id, String proj_name, String proj_desc, Date proj_stdate, String proj_manager,
			String proj_status, Date proj_ludate) {
		super();
		this.proj_id = proj_id;
		this.proj_name = proj_name;
		this.proj_desc = proj_desc;
		this.proj_stdate = proj_stdate;
		this.proj_manager = proj_manager;
		this.proj_status = proj_status;
		this.proj_ludate = proj_ludate;
	}

	public Date getProj_ludate() {
		return proj_ludate;
	}

	public void setProj_ludate(Date proj_ludate) {
		this.proj_ludate = proj_ludate;
	}

	public int getProj_id() {
		return proj_id;
	}

	public void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}

	public String getProj_Name() {
		return proj_name;
	}

	public void setProj_Name(String proj_name) {
		this.proj_name = proj_name;
	}

	public String getProj_desc() {
		return proj_desc;
	}

	public void setProj_desc(String proj_desc) {
		this.proj_desc = proj_desc;
	}

	public Date getProj_stdate() {
		return proj_stdate;
	}

	public void setProj_stdate(Date proj_stdate) {
		this.proj_stdate = proj_stdate;
	}

	public String getProj_manager() {
		return proj_manager;
	}

	public void setProj_manager(String proj_manager) {
		this.proj_manager = proj_manager;
	}

	public String getProj_status() {
		return proj_status;
	}

	public void setProj_status(String proj_status) {
		this.proj_status = proj_status;
	}

	@Override
	public String toString() {
		return proj_id + " " + proj_name + " " + proj_desc + " " + proj_stdate + " " + proj_manager + " " + proj_status
				+ " " + proj_ludate;

	}

}
