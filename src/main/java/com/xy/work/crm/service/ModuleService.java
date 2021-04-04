package com.xy.work.crm.service;

import com.xy.work.base.BaseMapper;
import com.xy.work.base.BaseService;
import com.xy.work.crm.model.TreeDto;
import com.xy.work.crm.vo.Module;

import java.util.List;
import java.util.Map;

public interface ModuleService extends BaseMapper<Module,Integer> {

    List<TreeDto> queryAllModules(Integer roleId);

    Map<String,Object> queryModuls();

    void saveModule(Module module);

    void updateModule(Module module);

    void deleteModule(Integer mid);

}
