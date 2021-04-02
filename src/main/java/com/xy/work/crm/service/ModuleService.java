package com.xy.work.crm.service;

import com.xy.work.crm.model.TreeDto;
import com.xy.work.crm.vo.Module;

import java.util.List;
import java.util.Map;

public interface ModuleService {

    List<TreeDto> queryAllModules(Integer roleId);

    Map<String,Object> queryModuls();

    void saveModule(Module module);

}
