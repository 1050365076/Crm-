package com.xy.work.crm.service;

import com.xy.work.crm.model.TreeDto;

import java.util.List;

public interface ModuleService {

    List<TreeDto> queryAllModules(Integer roleId);

}
