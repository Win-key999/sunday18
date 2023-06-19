package com.nkxgen.spring.orm.dao;

import java.util.List;

import com.nkxgen.spring.orm.model.ProjectModel;

public interface ProjectDao {

    List<ProjectModel> getAllProjects();

    ProjectModel getProjectById(int projId);

    void addProject(ProjectModel project);

    void saveProject(ProjectModel project);
}
