package com.nkxgen.spring.orm.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "final_sprints")
public class Sprint {
	@Override
	public String toString() {
		return "Sprint [sprintId=" + sprintId + ", moduleId=" + moduleId + ", masterId=" + masterId + ", startDate="
				+ startDate + ", endDate=" + endDate + ", projectId=" + projectId + ", sprintName=" + sprintName
				+ ", sprintStatus=" + sprintStatus + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "sprn_id")
	private int sprintId;

	@Column(name = "sprn_modl_id")
	private int moduleId;

	@Column(name = "sprn_master")
	private int masterId;

	@Column(name = "sprn_stdate")
	private Timestamp startDate;

	@Column(name = "sprn_enddate")
	private Timestamp endDate;

	@Column(name = "proj_id")
	private int projectId;

	@Column(name = "sprint_name")
	private String sprintName;

	@Column(name = "sprint_status")
	private String sprintStatus;

	// Constructors, getters, and setters

	public String getSprintStatus() {
		return sprintStatus;
	}

	public void setSprintStatus(String sprintStatus) {
		this.sprintStatus = sprintStatus;
	}

	public int getSprintId() {
		return sprintId;
	}

	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public int getMasterId() {
		return masterId;
	}

	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public boolean isActive() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		LocalDateTime expirationDateTime = endDate.toLocalDateTime();

		if (currentDateTime.isBefore(expirationDateTime)) {
			return true;
		} else {
			return false;
		}
	}

}
