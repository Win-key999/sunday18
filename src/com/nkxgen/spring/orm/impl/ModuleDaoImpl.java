package com.nkxgen.spring.orm.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nkxgen.spring.orm.dao.ModuleDao;
import com.nkxgen.spring.orm.model.Module;

@Component
@Repository
public class ModuleDaoImpl implements ModuleDao {

	private final JdbcTemplate jdbcTemplate;

	public ModuleDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Module> getModulesByProjectId(int projectId) {
		String sql = "SELECT * FROM T4_ProjectModules WHERE modl_proj_id = ?";
		return jdbcTemplate.query(sql, new Object[] { projectId }, (rs, rowNum) -> {
			Module module = new Module();
			module.setModl_id(rs.getInt("modl_id"));
			module.setModl_name(rs.getString("modl_name"));
			module.setModl_proj_id(rs.getInt("modl_proj_id"));
			return module;
		});
	}

	public void CreateModule(Module module) {
		String sql = "INSERT INTO T4_ProjectModules VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, module.getModl_id(), module.getModl_name(), module.getModl_desc(),
				module.getModl_proj_id());
	}

	public Module getModuleById(int moduleId) {
		String sql = "SELECT * FROM T4_ProjectModules WHERE modl_id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { moduleId }, (rs, rowNum) -> {
			Module module = new Module();
			module.setModl_id(rs.getInt("modl_id"));
			module.setModl_name(rs.getString("modl_name"));
			module.setModl_desc(rs.getString("modl_desc"));
			module.setModl_proj_id(rs.getInt("modl_proj_id"));
			return module;
		});
	}



}
