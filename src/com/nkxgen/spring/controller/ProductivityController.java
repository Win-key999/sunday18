package com.nkxgen.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nkxgen.spring.orm.dao.SprintDAO;
import com.nkxgen.spring.orm.model.ProjectModel;
import com.nkxgen.spring.orm.model.Sprint;
import com.nkxgen.spring.orm.service.ProjectService;

@Controller
public class ProductivityController {

	private SprintDAO sd;

	private ProjectService Servicse;

	@Autowired
	public ProductivityController(SprintDAO sda, ProjectService service) {
		super();
		this.sd = sda;
		this.Servicse = service;
	}

	@RequestMapping(value = "/prod", method = RequestMethod.GET)
	public String index(Model model) {
		System.out.println("product method");
		return "productivity";
	}

	@RequestMapping(value = "/dash", method = RequestMethod.GET)
	public String dash(Model model) {
		return "dash";
	}

	@RequestMapping(value = "/ana", method = RequestMethod.GET)
	public String analytics(Model model) {
		return "ana";
	}

	@RequestMapping(value = "/resource", method = RequestMethod.GET)
	public String resource(Model model) {
		return "AddResource";
	}

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String project(Model model) {
		List<ProjectModel> projects = Servicse.getAllProjects();
		model.addAttribute("projects", projects);
		System.out.println("project called");
		return "project";
	}

	@RequestMapping(value = "/sprint", method = RequestMethod.GET)
	public String sprint(Model model) {
		System.out.println("project called");
		List<Sprint> allSprints = sd.getAllSprints();
		model.addAttribute("allSprints", allSprints);
		System.out.println(allSprints);
		return "sprint_home";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String getdashboard(Model model) {
		System.out.println("project called");
		return "dashboard";
	}

	@RequestMapping(value = "/analytics", method = RequestMethod.GET)
	public String getanalytics(Model model) {
		System.out.println("project called");
		return "analytics";
	}

}