package com.nkxgen.spring.orm.service;

import java.util.List;

import com.nkxgen.spring.orm.model.SubTasks;
import com.nkxgen.spring.orm.model.Task;

public interface TaskServiceInt {
    Task gettaskbyid(int taskId);
    List<SubTasks> getSubTasksById(Integer taskId);
    void create(Task task);
    void delete(Task task);
    void update(Task task);
}
