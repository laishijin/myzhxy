package com.laishijin.myzhxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laishijin.myzhxy.mapper.StudentMapper;
import com.laishijin.myzhxy.pojo.LoginForm;
import com.laishijin.myzhxy.pojo.Student;
import com.laishijin.myzhxy.service.StudentService;
import com.laishijin.myzhxy.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Laishijin
 * @Email Lai_shijin@163.com
 * @Date: 2022/9/27 16:50
 */
@Service("stuService")
@Transactional
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    /**
     * 学生登录方法
     * @return
     */
    @Override
    public Student login(LoginForm loginForm) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",loginForm.getUsername());
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));
        Student student = baseMapper.selectOne(queryWrapper);
        return student;
    }

    @Override
    public Student getStudentById(Long userId) {
        QueryWrapper<Student> queryWrapper=new QueryWrapper<Student>();
        queryWrapper.eq("id",userId);
        return baseMapper.selectOne(queryWrapper);
    }

    /**
     * 按条件查询学生信息【带分页】
     */
    public IPage<Student> getStudentByOpr(Page<Student> pageParam,Student student){
        QueryWrapper<Student> queryWrapper = null;
        if(student != null) {
            queryWrapper = new QueryWrapper<>();
            if (student.getClazzName() != null) {
                queryWrapper.eq("clazz_name", student.getClazzName());
            }
            if (student.getName() != null) {
                queryWrapper.like("name", student.getName());
            }
            queryWrapper.orderByDesc("id");
            queryWrapper.orderByAsc("name");
        }
        //创建分页对象
        IPage<Student> pages = baseMapper.selectPage(pageParam, queryWrapper);

        return pages;
    }
}
