package com.nkxgen.spring.orm.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nkxgen.spring.orm.dao.SprintDAO;
import com.nkxgen.spring.orm.model.Sprint;
import com.nkxgen.spring.orm.model.SprintTasks;
import com.nkxgen.spring.orm.model.Task;

@Repository
public class SprintDaoImpl implements SprintDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public SprintDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println(this.jdbcTemplate);

	}

	@Override
	public List<Sprint> getBaskLogs() {
		String query = "SELECT s.sprn_id, s.sprn_modl_id, s.sprn_master, s.sprn_stdate, s.sprn_enddate, s.proj_id FROM t4_sprints s WHERE EXISTS (SELECT 1 FROM t4_tasks t WHERE t.modl_id = s.sprn_modl_id AND t.task_cmp_datetime IS NULL)";

		return jdbcTemplate.query(query, (rs, rowNum) -> {
			Sprint sprint = new Sprint();
			sprint.setSprintId(rs.getInt("sprn_id"));
			sprint.setModuleId(rs.getInt("sprn_modl_id"));
			sprint.setMasterId(rs.getInt("sprn_master"));
			sprint.setStartDate(rs.getTimestamp("sprn_stdate"));
			sprint.setEndDate(rs.getTimestamp("sprn_enddate"));
			sprint.setProjectId(rs.getInt("proj_id"));
			return sprint;
		});
	}

	@Override
	public Sprint getSprintDetails(int sprintId) {
		String query = "SELECT * FROM t4_sprints WHERE sprn_id = ?";

		return jdbcTemplate.queryForObject(query, new Object[] { sprintId }, (rs, rowNum) -> {
			Sprint sprint = new Sprint();
			sprint.setSprintId(rs.getInt("sprn_id"));
			sprint.setModuleId(rs.getInt("sprn_modl_id"));
			sprint.setMasterId(rs.getInt("sprn_master"));
			sprint.setStartDate(rs.getTimestamp("sprn_stdate"));
			sprint.setEndDate(rs.getTimestamp("sprn_enddate"));
			sprint.setProjectId(rs.getInt("proj_id"));
			return sprint;
		});
	}

	@Override
	public List<Task> getTasks(int modlId) {
		String query = "SELECT * FROM t4_tasks WHERE modl_id = ?";

		return jdbcTemplate.query(query, new Object[] { modlId }, (rs, rowNum) -> {
			Task task = new Task();
			task.setTask_id(rs.getInt(1));
			task.setTask_name(rs.getString(2));
			task.setTask_cdatetime(rs.getTimestamp(3));
			task.setTask_type(rs.getString(4));
			task.setTask_ref_task_id(rs.getInt(5));
			task.setTask_category(rs.getString(6));
			task.setTask_desc(rs.getString(7));
			task.setTask_creator(rs.getInt(8));
			task.setTask_noh_reqd(rs.getDouble(9));
			task.setTask_exp_datetime(rs.getTimestamp(10));
			task.setTask_cmp_datetime(rs.getTimestamp(11));
			task.setTask_supervisor(rs.getInt(12));
			task.setTask_remarks(rs.getString(13));
			task.setTask_status(rs.getString(14));
			task.setProj_id(rs.getInt(15));
			task.setModl_id(rs.getInt(16));

			return task;
		});
	}

	@Override
	public List<Sprint> getAllSprints() {
		String query = "SELECT * from t4_sprints";
		return jdbcTemplate.query(query, (rs, rowNum) -> {
			Sprint sprint = new Sprint();
			sprint.setSprintId(rs.getInt("sprn_id"));
			sprint.setModuleId(rs.getInt("sprn_modl_id"));
			sprint.setMasterId(rs.getInt("sprn_master"));
			sprint.setStartDate(rs.getTimestamp("sprn_stdate"));
			sprint.setEndDate(rs.getTimestamp("sprn_enddate"));
			sprint.setProjectId(rs.getInt("proj_id"));
			return sprint;
		});
	}

	@Override
	public List<SprintTasks> allTaskBySprintId(Integer sprintId) {
		String query = "SELECT * FROM T4_SprintTasks WHERE sprn_id = ?";

		return jdbcTemplate.query(query, new Object[] { sprintId }, (rs, rowNum) -> {
			int sprnId = rs.getInt("sprn_id");
			int taskId = rs.getInt("task_id");
			int userId = rs.getInt("user_id");

			SprintTasks sprintTask = new SprintTasks(sprnId, taskId, userId);
			return sprintTask;
		});
	}
	public List<Sprint> getSprintsByProjectId(int projectId) {
		String sql = "SELECT * FROM t4_sprints WHERE proj_id = ?";
		System.out.println("HIIIIIIIIIIIII");
		List<Sprint> sprints = new ArrayList<>();

		jdbcTemplate.query(sql, new Object[] { projectId }, (ResultSet rs) -> {
			Sprint sprint = new Sprint();
			sprint.setSprintId(rs.getInt("sprn_id"));
			sprint.setModuleId(rs.getInt("sprn_modl_id"));
			sprint.setMasterId(rs.getInt("sprn_master"));
			sprint.setStartDate(rs.getTimestamp("sprn_stdate"));
			sprint.setEndDate(rs.getTimestamp("sprn_enddate"));
			sprint.setProjectId(rs.getInt("proj_id"));
//			sprint.setSprintName(rs.getString("sprint_name"));
//			sprint.setSprintStatus(rs.getString("sprint_status"));
			sprints.add(sprint);
		});

		return sprints;
	}

}
