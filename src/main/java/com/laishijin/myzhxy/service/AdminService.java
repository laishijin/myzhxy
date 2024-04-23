package com.laishijin.myzhxy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.laishijin.myzhxy.pojo.Admin;
import com.laishijin.myzhxy.pojo.LoginForm;

/**
 * @Author: Laishijin
 * @Email Lai_shijin@163.com
 * @Date: 2022/9/27 16:17
 */
public interface AdminService extends IService<Admin> {
    /**
     * 登录
     * @param loginForm
     * @return
     */
    Admin login(LoginForm loginForm);
    Admin getAdminById(Long userId);

    IPage<Admin> getAdmins(Page<Admin> pageParam, String adminName);


    IPage<Admin> getAdminsByOpr(Page<Admin> pageParam, String adminName);
}
