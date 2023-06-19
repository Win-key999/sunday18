package com.nkxgen.spring.orm.dao;

import java.util.List;

import com.nkxgen.spring.orm.model.SubTasks;
import com.nkxgen.spring.orm.model.Task;

public interface TaskDAO {

	void createTask();

	void deleteTask();

	void updateTask();

	Task getTaskById(Integer taskId);

	List<SubTasks> getSubTasksById(Integer taskId);
}