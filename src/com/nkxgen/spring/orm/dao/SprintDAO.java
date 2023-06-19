package com.nkxgen.spring.orm.dao;

import java.util.List;

import com.nkxgen.spring.orm.model.Sprint;
import com.nkxgen.spring.orm.model.SprintTasks;
import com.nkxgen.spring.orm.model.Task;

public interface SprintDAO {

	List<Sprint> getBaskLogs();

	Sprint getSprintDetails(int Sprintid);

	List<Sprint> getAllSprints();

	List<SprintTasks> allTaskBySprintId(Integer SprintId);

	List<Task> getTasks(int modlId);
	List<Sprint> getSprintsByProjectId(int projectId);

}
