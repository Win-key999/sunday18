package com.nkxgen.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nkxgen.spring.orm.dao.ModuleDao;
import com.nkxgen.spring.orm.dao.ProjectDao;
import com.nkxgen.spring.orm.dao.SprintDAO;
import com.nkxgen.spring.orm.model.ProjectModel;
import com.nkxgen.spring.orm.model.Sprint;
import com.nkxgen.spring.orm.model.SprintTasks;
import com.nkxgen.spring.orm.model.Task;

@Controller
public class SprintController {

	SprintDAO sd;
	ProjectDao pd;
    ModuleDao  md;
	@Autowired
	public SprintController(SprintDAO sda,ProjectDao projectDao,ModuleDao md) {
		super();
		this.sd = sda;
		pd=projectDao;
		this.md=md;
		
	}

	@RequestMapping(value = "/sprints", method = RequestMethod.GET)
	public String getAllSprints(Model model) {
		System.out.println("Sprint List JSP Requested");

		// Retrieve all sprints from the database and add them to the model

		return "sprint_home";
	}

	@RequestMapping(value = "/sprint_details", method = RequestMethod.GET)
	public String getSprintDetails(Model model, @RequestParam Integer sprintId) {
		System.out.println("Sprint Details JSP Requested");
		Sprint sprint = sd.getSprintDetails(sprintId);
		// Retrieve the selected sprint details from the database and add them to the model
		model.addAttribute("sprint", sprint);

		List<SprintTasks> tasksByIdSprints = sd.allTaskBySprintId(sprintId);
		model.addAttribute("tasksByIdSprints", tasksByIdSprints);
		return "sprint_details";
	}

	@RequestMapping(value = "/projectDetails", method = RequestMethod.GET)
	public String getProjectDetails(Model model) {
		
		System.out.println("Sprint Details JSP Requested");

		// Retrieve the selected sprint details from the database and add them to the model

		return "projectDetails";
	}

	@RequestMapping(value = "/add_sprint", method = RequestMethod.GET)
	public String addSprint(Model model,Sprint sprint) {
		System.out.println("sprint"+sprint);
       
		List<ProjectModel>pl=pd.getAllProjects();
		System.out.println("projects"+pl);
       model.addAttribute("Projects",pl);
		return "add_sprint";
	}

	@RequestMapping(value = "/FunctionalUnit", method = RequestMethod.GET)
	public String addSprint() {
		System.out.println("functional unit jsp");

		// Add any necessary data to the model for rendering the add sprint page

		return "FunctionalUnit";
	}

	@RequestMapping(value = "/SubTaskdetails", method = RequestMethod.GET)
	public String SubtaskDetails() {
		System.out.println("Subtask Details requested");
		return "SubtaskDetails";
	}

	@RequestMapping(value = "/CreateSubTask", method = RequestMethod.GET)
	public String CreateSubtask() {
		System.out.println("Subtask creation requested");
		System.out.println("hello");
		return "CreateSubtask";
	}

	@RequestMapping(value = "/backlog", method = RequestMethod.GET)
	public String pastdue(Model model) {
		ArrayList<Sprint> SprintList = (ArrayList<Sprint>) sd.getBaskLogs();
		model.addAttribute("sprintList", SprintList);
		return "backlog";
	}

	@RequestMapping(value = "/BacklogTasks", method = RequestMethod.GET)
	public String getBacklogTasks(Model model, @RequestParam("sprnModlId") int sprnModlId,
			@RequestParam("sprnId") int sprnId) {

		Sprint sprint = sd.getSprintDetails(sprnId);
		List<Task> taskList = sd.getTasks(sprnModlId);
		model.addAttribute("sprint", sprint);
		model.addAttribute("taskList", taskList);
		return "BacklogTasks";
	}
	
	@GetMapping("/getModuleById")   
    public @ResponseBody List<com.nkxgen.spring.orm.model.Module> getModuleById(@RequestParam("projectId") int projectId) {
        System.out.println("Inside");
		List<com.nkxgen.spring.orm.model.Module> moduleList = md.getModulesByProjectId(projectId);
        System.out.println("modules"+moduleList.get(0));
        return moduleList;
    }
	@RequestMapping(value = "projects/sprints", method = RequestMethod.GET)
	public String getSprintsByProjectId(@RequestParam("projectId") int projectId, Model model) {
		List<Sprint> sprints = sd.getSprintsByProjectId(projectId);
		System.out.println(sprints);
		model.addAttribute("sprints", sprints);
		return "SprintDetailByProjId";
	}


}
