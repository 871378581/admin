package com.segama.ege.admin.request;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2019-10-07 15:03
 */
public class LoginRequest {

    private String userName;
    private String password;
    private String token;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
