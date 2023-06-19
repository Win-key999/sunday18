package com.nkxgen.spring.orm.impl;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nkxgen.spring.orm.dao.TaskDAO;
import com.nkxgen.spring.orm.model.SubTasks;
import com.nkxgen.spring.orm.model.Task;

public class TaskDaoImpl implements TaskDAO {

	private JdbcTemplate jdbcTemplate;

	public TaskDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void createTask() {
		String sql = "INSERT INTO s4_tasks VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { 1, "Task-9", Date.valueOf("2023-06-13"), "C", 3, "Category 4", "Description 10", 9, 8,
				Date.valueOf("2023-06-13"), Date.valueOf("2023-07-12"), 2, "Remarks12", "Open", 5, 3 };
		jdbcTemplate.update(sql, params);
	}

	@Override
	public void deleteTask() {
		String sql = "DELETE FROM s4_tasks WHERE task_id=?";
		Object[] params = { 1 };
		jdbcTemplate.update(sql, params);
	}

	@Override
	public void updateTask() {
		String sql = "UPDATE s4_tasks SET task_status=? WHERE task_id=?";
		Object[] params = { "Open", 1 };
		jdbcTemplate.update(sql, params);
	}

	@Override
	public List<SubTasks> getSubTasksById(Integer taskId) {
		String query = "SELECT * FROM t4_subtasks WHERE task_id = ?";
		return jdbcTemplate.query(query, new Object[] { taskId }, (rs, rowNum) -> {
			SubTasks subtask = new SubTasks();
			subtask.setSbts_id(rs.getInt("sbts_id"));
			subtask.setTask_id(rs.getInt("task_id"));
			subtask.setSbts_parent_sbts_id(rs.getInt("sbts_parent_sbts_id"));
			return subtask;
		});
	}

	@Override
	public Task getTaskById(Integer taskId) {
		String query = "SELECT * FROM t4_tasks WHERE task_id = ?";

		return jdbcTemplate.queryForObject(query, new Object[] { taskId }, (rs, rowNum) -> {
			Task task = new Task();
			task.setTask_id(rs.getInt("task_id"));
			task.setTask_name(rs.getString("task_name"));
			task.setTask_cdatetime(rs.getTimestamp("task_cdatetime"));
			task.setTask_type(rs.getString("task_type"));
			task.setTask_ref_task_id(rs.getInt("task_ref_task_id"));
			task.setTask_category(rs.getString("task_category"));
			task.setTask_desc(rs.getString("task_desc"));
			task.setTask_creator(rs.getInt("task_creator"));
			task.setTask_noh_reqd(rs.getDouble("task_noh_reqd"));
			task.setTask_exp_datetime(rs.getTimestamp("task_exp_datetime"));
			task.setTask_cmp_datetime(rs.getTimestamp("task_cmp_datetime"));
			task.setTask_supervisor(rs.getInt("task_supervisor"));
			task.setTask_remarks(rs.getString("task_remarks"));
			task.setTask_status(rs.getString("task_status"));
			task.setProj_id(rs.getInt("proj_id"));
			task.setModl_id(rs.getInt("modl_id"));
			return task;
		});
	}

}