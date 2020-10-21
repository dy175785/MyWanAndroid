package com.dy.mywanandroid.utils;

import com.blankj.utilcode.util.SPUtils;

import java.util.HashMap;
import java.util.Map;

/**
 *  Administrator
 *  @author dy
 *  created at 2020/9/22 0022 10:43
 */
public class AppHelper {
    public static final String MAIN_WEB_DATA = "main_web_data";
    public static final String MAIN_WEB_TYPE = "main_web_type";
    public static final String MAIN_WEB_RANK = "ranking";
    public static final String MAIN_WEB_MAIN = "main";
    public static final String MAIN_WEB_ACCOUNT = "account";
    public static final String MAIN_WEB_MAGGER = "magger";
    /**
     * 账号密码持久化
     */
    public static final String LOGIN_USER_NAME_COOKIE="loginUserName=";
    public static final String LOGIN_USER_PASSWORD_COOKIE="loginUserPassword=";
    public static final String LOGIN_USER_USERNAME = "username";
    public static final String LOGIN_USER_PASSWORD = "password";
    public static final String MY_INTENT_DATA = "my_intent_data";

    public static Map<String,String> getCookie(){
        Map<String,String> map = new HashMap<>();
        map.put(LOGIN_USER_NAME_COOKIE, SPUtils.getInstance().getString(LOGIN_USER_USERNAME));
        map.put(LOGIN_USER_PASSWORD_COOKIE,SPUtils.getInstance().getString(LOGIN_USER_PASSWORD));
        return map;
    }

    public static String getNameCookie(){
        return LOGIN_USER_NAME_COOKIE+ SPUtils.getInstance().getString(LOGIN_USER_USERNAME);
    }
    public static String getPwdCookie(){
        return LOGIN_USER_PASSWORD_COOKIE+ SPUtils.getInstance().getString(LOGIN_USER_PASSWORD);
    }
}
