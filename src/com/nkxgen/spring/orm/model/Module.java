package com.nkxgen.spring.orm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T4_ProjectModules")
public class Module {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int modl_id;
	private String modl_name;
	private String modl_desc;

	private int modl_proj_id;

	// Default constructor
	public Module() {
	}

	public int getModl_id() {
		return modl_id;
	}

	public void setModl_id(int modl_id) {
		this.modl_id = modl_id;
	}

	public String getModl_name() {
		return modl_name;
	}

	public void setModl_name(String modl_name) {
		this.modl_name = modl_name;
	}

	public String getModl_desc() {
		return modl_desc;
	}

	public void setModl_desc(String modl_desc) {
		this.modl_desc = modl_desc;
	}

	public int getModl_proj_id() {
		return modl_proj_id;
	}

	public void setModl_proj_id(int modl_proj_id) {
		this.modl_proj_id = modl_proj_id;
	}

	public Module(int modl_id, String modl_name, String modl_desc, int modl_proj_id) {
		super();
		this.modl_id = modl_id;
		this.modl_name = modl_name;
		this.modl_desc = modl_desc;
		this.modl_proj_id = modl_proj_id;
	}

	@Override
	public String toString() {
		return modl_id + " " + modl_name + " " + modl_desc + " " + modl_proj_id;

	}

}