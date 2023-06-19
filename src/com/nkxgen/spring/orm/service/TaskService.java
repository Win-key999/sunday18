package com.nkxgen.spring.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.orm.dao.TaskDAO;
import com.nkxgen.spring.orm.model.SubTasks;
import com.nkxgen.spring.orm.model.Task;

@Component
public class TaskService {

	private TaskDAO tdao;

	@Autowired
	public TaskService(TaskDAO taskdao) {
		tdao = taskdao;
	}

	@Transactional
	public Task gettaskbyid(int taskId) {
		return tdao.getTaskById(taskId);

	}

	@Transactional
	public List<SubTasks> getSubTasksById(Integer taskId) {
		return tdao.getSubTasksById(taskId);

	}

	@Transactional
	public void create(Task task) {
	}

	@Transactional
	public void delete(Task task) {

	}

	@Transactional
	public void update(Task task) {
	}

}