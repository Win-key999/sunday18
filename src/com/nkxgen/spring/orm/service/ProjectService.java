package com.nkxgen.spring.orm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nkxgen.spring.orm.dao.ProjectDao;
import com.nkxgen.spring.orm.impl.ProjectDaoImpl;
import com.nkxgen.spring.orm.model.ProjectModel;

@Component
@Transactional
public class ProjectService {

	
	private ProjectDao project;
	@Autowired
	public void setProjectDAO(ProjectDao projectDao) {
	project = projectDao;
	}

	@Transactional
	public List<ProjectModel> getAllProjects() {
		return project.getAllProjects();
	}

	public ProjectModel getProjectById(int proj_id) {
		return project.getProjectById(proj_id);
	}

	public void addProject(com.nkxgen.spring.orm.model.ProjectModel addproject) {
		project.addProject(addproject);
	}

}
