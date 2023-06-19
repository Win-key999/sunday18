package com.nkxgen.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.orm.model.Employee;

@Controller
public class ResourceController {

	@RequestMapping(value = "/resources", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		System.out.println("resources List JSP Requested");

		return "ResourceHome";
	}

	@RequestMapping(value = "/FilterResource", method = RequestMethod.GET)
	public String addNewEmployee(Model model) {
		System.out.println("Filter jsp requested JSP Requested");
		return "FilterResource";
	}

	@RequestMapping(value = "/user_details", method = RequestMethod.GET)
	public String saveNewEmployee(@Validated Employee emp, Model model) {
		System.out.println(" user page details  Page Requested");

		return "user_details";
	}

	@RequestMapping(value = "/sprint_user_details", method = RequestMethod.GET)
	public String viewEmployeeDataSprint(Model model, @RequestParam Integer userId) {
		System.out.println(" user page details  Page Requested");
		Employee emp = new Employee();
		emp.setEmpNo(userId);
		return "user_details";
	}

	@RequestMapping(value = "/edit_resource", method = RequestMethod.GET)
	public String deleteEmployee(Model model) {
		System.out.println("update  JSP Requested");
		return "edit_resource";
	}

	@RequestMapping(value = "/AddResource", method = RequestMethod.GET)
	public String deleteEmploye(Model model) {
		System.out.println("update  JSP Requested");
		return "AddResource";
	}
}