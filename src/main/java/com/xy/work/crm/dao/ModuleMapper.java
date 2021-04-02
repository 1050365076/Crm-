package com.xy.work.crm.dao;

import com.xy.work.base.BaseMapper;
import com.xy.work.crm.model.TreeDto;
import com.xy.work.crm.vo.Module;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleMapper extends BaseMapper<Module,Integer> {

    List<TreeDto> queryAllModuls();

    public List<Module> queryModuls();

    Module queryModuleByGradeAndModuleName(@Param("grade") Integer grade,@Param("moduleName") String moduleName);

    Module queryModuleByGradeAndUrl(@Param("grade")Integer grade,@Param("url") String url);

    Module queryModuleByOptValue(String optValue);
}
