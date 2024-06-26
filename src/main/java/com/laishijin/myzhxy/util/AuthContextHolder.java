package com.laishijin.myzhxy.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Laishijin
 * @Email Lai_shijin@163.com
 * @Date: 2022/9/24 22:49
 *
 * 解析request请求中的 token口令的工具AuthContextHolder
 */
public class AuthContextHolder {
    //从请求头token获取userid
    public static Long getUserIdToken(HttpServletRequest request) {
        //从请求头token的Id
        String token = request.getHeader("token");
        //调用工具类
        Long userId = JwtHelper.getUserId(token);
        return userId;
    }

    //从请求头token获取name
    public static String getUserName(HttpServletRequest request) {
        //从header获取token
        String token = request.getHeader("token");
        //jwt从token获取username的名字
        String userName = JwtHelper.getUserName(token);
        return userName;
    }
}
