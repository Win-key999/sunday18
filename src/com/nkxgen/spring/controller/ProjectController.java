package com.nkxgen.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nkxgen.spring.orm.model.ProjectModel;
import com.nkxgen.spring.orm.service.ProjectService;

@Controller
public class ProjectController {

	private ProjectService Servicse;

	@Autowired
	public ProjectController(ProjectService service) {
		this.Servicse = service;
	}

	@RequestMapping(value = "/projects")
	public String getAllProjects(Model model) {
		List<ProjectModel> projects = Servicse.getAllProjects();
		model.addAttribute("projects", projects);
		System.out.println(projects);
		return "project";
	}

	@RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
	public String showProjectDetails(@PathVariable("id") int proj_id, Model model) {
		System.out.print("hii");
		ProjectModel project = Servicse.getProjectById(proj_id);
		System.out.println("prrr:" + project.getProj_id());
		model.addAttribute("project", project);
		model.addAttribute("projectFound", project != null);
		return "projectDetails";
	}

	@RequestMapping(value = "/projects/addproject", method = RequestMethod.GET)
	public String addProject(@Validated ProjectModel addProject) {
		System.out.println("hii");
		// Service.addProject(addProject);
		return "AddProject";
	}

	@RequestMapping(value = "projects/setproject", method = RequestMethod.GET)
	public String saveProject(@Validated ProjectModel projectModel, Model model) {
		// Create a ProjectModel object using the form data
		System.out.println("Project Object" + projectModel);
		System.out.println("Project inserted");

		// @RequestParam("proj_name") String projectName,
		// @RequestParam("proj_desc") String projectDescription, @RequestParam("proj_stdate") Date startDate,
		// @RequestParam("proj_manager") String projectManager, @RequestParam("proj_status") String projectStatus,
		// @RequestParam("proj_ludate") Date lastUpdatedDate
		// ProjectModel project = new ProjectModel();
		// project.setProj_Name(projectName);
		// project.setProj_desc(projectDescription);
		// project.setProj_stdate(startDate);
		// project.setProj_manager(projectManager);
		// project.setProj_status(projectStatus);
		// project.setProj_ludate(lastUpdatedDate);

		// Save the project using the ProjectService
		// Service.addProject(project);

		return "success"; // Redirect to a success page
	}

}
