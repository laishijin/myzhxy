package com.laishijin.myzhxy.pojo;

import lombok.Data;

/**
 * @Author: Laishijin
 * @Email Lai_shijin@163.com
 * @Date: 2022/9/27 11:25
 *
 * @project: ssm_sms
 *   @description: 用户登录表单信息
 */
@Data
public class LoginForm {

    private String username;
    private String password;
    private String verifiCode;  //输入的验证码
    private Integer userType;    //登录的用户类型
}
