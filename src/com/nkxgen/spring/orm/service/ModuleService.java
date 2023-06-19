package com.nkxgen.spring.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkxgen.spring.orm.dao.ModuleDao;
import com.nkxgen.spring.orm.impl.ModuleDaoImpl;
import com.nkxgen.spring.orm.model.Module;

@Service
public class ModuleService {
	@Autowired
	private final ModuleDao moduleDAO;

	public ModuleService(ModuleDaoImpl moduleDAO) {
		this.moduleDAO = moduleDAO;
	}

	public List<Module> getModulesByProjectId(int projectId) {
		return moduleDAO.getModulesByProjectId(projectId);
	}

	public void CreateModule(Module addmodule) {
		moduleDAO.CreateModule(addmodule);
	}

	public Module getModuleById(int moduleId) {
		return moduleDAO.getModuleById(moduleId);
	}

}
