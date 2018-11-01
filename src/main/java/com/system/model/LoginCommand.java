package com.system.model;

import java.io.Serializable;

/**
 * @author AllenYang
 * @date 18-9-15 下午10:21
 */
public class LoginCommand implements Serializable {

    private int userId;

    private String userName;

    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
