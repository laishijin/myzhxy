package com.laishijin.myzhxy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.laishijin.myzhxy.pojo.LoginForm;
import com.laishijin.myzhxy.pojo.Student;

/**
 * @Author: Laishijin
 * @Email Lai_shijin@163.com
 * @Date: 2022/9/27 16:39
 */
public interface StudentService extends IService<Student> {

    /**
     * 学生登录方法
     * @return
     */
    public Student login(LoginForm loginForm);

    Student getStudentById(Long userId);

    IPage<Student> getStudentByOpr(Page<Student> page, Student student);
}
