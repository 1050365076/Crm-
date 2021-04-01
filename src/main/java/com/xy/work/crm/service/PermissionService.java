package com.xy.work.crm.service;

import java.util.List;

public interface PermissionService {

    List<String> queryUserHasRoleIdsHasModuleIds(Integer userId);
}
