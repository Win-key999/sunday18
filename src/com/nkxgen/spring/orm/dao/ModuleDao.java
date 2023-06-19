package com.nkxgen.spring.orm.dao;

import java.util.List;

import com.nkxgen.spring.orm.model.Module;

public interface ModuleDao {
    List<com.nkxgen.spring.orm.model.Module> getModulesByProjectId(int projectId);
    
    void CreateModule(Module module);
    
    Module getModuleById(int moduleId);
}
