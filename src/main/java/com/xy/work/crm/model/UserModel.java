package com.xy.work.crm.model;

/**
 * 临时存放用户信息，
 * 展示前台需要的信息即可。
 */
public class UserModel {

    private String userIdstr;
    private String userName;
    private String trueName;

    public String getUserIdstr() {
        return userIdstr;
    }

    public void setUserIdstr(String userIdstr) {
        this.userIdstr = userIdstr;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }
}
