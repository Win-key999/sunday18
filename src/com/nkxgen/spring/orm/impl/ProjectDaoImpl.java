package com.nkxgen.spring.orm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.nkxgen.spring.orm.dao.ProjectDao;
import com.nkxgen.spring.orm.model.ProjectModel;

@Component
public class ProjectDaoImpl implements ProjectDao{

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public ProjectDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<ProjectModel> getAllProjects() {
		String sql = "SELECT * FROM T4_Projects";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			ProjectModel project = new ProjectModel();
			project.setProj_id(rs.getInt("proj_id"));
			project.setProj_Name(rs.getString("proj_name"));

			return project;
		});
	}

	public ProjectModel getProjectById(int projId) {
		String sql = "SELECT * FROM T4_Projects WHERE proj_id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { projId }, (rs, rowNum) -> {
			ProjectModel project = new ProjectModel();
			project.setProj_id(rs.getInt("proj_id"));
			project.setProj_Name(rs.getString("proj_name"));
			project.setProj_desc(rs.getString("proj_desc"));
			project.setProj_stdate(rs.getDate("proj_stdate"));
			project.setProj_manager(rs.getString("proj_manager"));
			project.setProj_status(rs.getString("proj_status"));
			project.setProj_ludate(rs.getDate("proj_ludate"));

			return project;
		});
	}

	public void addProject(ProjectModel project) {
		String sql = "INSERT INTO T4_Projects (proj_name, proj_desc, proj_stdate, proj_manager, proj_status, proj_ludate) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, project.getProj_Name(), project.getProj_desc(), project.getProj_stdate(),
				project.getProj_manager(), project.getProj_status(), project.getProj_ludate());
	}

	public void saveProject(ProjectModel project) {
		String sql = "UPDATE T4_Projects SET proj_name = ? WHERE proj_id = ?";
		jdbcTemplate.update(sql, project.getProj_Name(), project.getProj_id());
	}
}
