package com.nkxgen.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.orm.model.Module;
import com.nkxgen.spring.orm.service.ModuleService;

@Controller
public class ModuleController {

	@Autowired
	private final ModuleService Service;

	public ModuleController(ModuleService moduleService) {
		this.Service = moduleService;
	}

	@RequestMapping(value = "projects/modules", method = RequestMethod.GET)

	public String getModulesByProjectId(@RequestParam("projectId") int projectId, Model model) {
		List<Module> modules = Service.getModulesByProjectId(projectId);
		model.addAttribute("modules", modules);

		return "module";
	}

	@RequestMapping(value = "/projects/createModule", method = RequestMethod.GET)
	public String CreateModule(@ModelAttribute("module") Module CreateModule) {
		System.out.println("hii");

		// Service.addProject(addProject);
		return "createModule";
	}

	@RequestMapping(value = "projects/moduledetails/{moduleId}", method = RequestMethod.GET)
	public String getModuleById(@PathVariable int moduleId, Model model) {
		Module module = Service.getModuleById(moduleId);
		model.addAttribute("module", module);
		return "moduledetails";
	}

	@RequestMapping(value = "/CreateFunctionalUnit", method = RequestMethod.GET)
	public String createFunctionalUnit() {
		System.out.println("CreateFunctionalUnit");
		return "CreateFunctionalUnit";
	}
}