package com.xy.work.crm.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * 用户登录处理处理器，可以从中读取Cookie,从中获得用户Id
 */
public class LoginUserUtil {

    /**
     * 从cookie中获取userId
     * @param request
     * @return
     */
    public static int releaseUserIdFromCookie(HttpServletRequest request) {
        String userIdString = CookieUtil.getCookieValue(request, "userIdStr");
        if (StringUtils.isBlank(userIdString)) {
            return 0;
        }
        Integer userId = UserIDBase64.decoderUserID(userIdString);
        return userId;
    }
}
