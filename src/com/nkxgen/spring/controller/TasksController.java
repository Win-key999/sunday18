package com.nkxgen.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.orm.model.SubTasks;
import com.nkxgen.spring.orm.model.Task;
import com.nkxgen.spring.orm.service.TaskService;

@Controller
public class TasksController {

	private TaskService ts;

	@Autowired
	public TasksController(TaskService tsa) {
		super();
		this.ts = tsa;
	}

	@RequestMapping(value = "/CreateTasks", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		System.out.println("Create Tasks Requested");
		return "CreateTasks";
	}

	@RequestMapping(value = "/Task", method = RequestMethod.GET)
	public String createTask() {
		System.out.println("Create Task");
		return "Task";
	}

	@RequestMapping(value = "/Taskdetails", method = RequestMethod.GET)
	public String taskDetails(Model model, @RequestParam Integer mytaskid) {
		System.out.println("Task Details requested");
		Task mytask = ts.gettaskbyid(mytaskid);
		List<SubTasks> mysubtasks = ts.getSubTasksById(mytaskid);
		// Retrieve the selected sprint details from the database and add them to the model
		model.addAttribute("mysubtask", mysubtasks);
		model.addAttribute("mytask", mytask);
		return "Taskdetails";
	}

}
