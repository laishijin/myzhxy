package com.laishijin.myzhxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laishijin.myzhxy.mapper.TeacherMapper;
import com.laishijin.myzhxy.pojo.LoginForm;
import com.laishijin.myzhxy.pojo.Teacher;
import com.laishijin.myzhxy.service.TeacherService;
import com.laishijin.myzhxy.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @Author: Laishijin
 * @Email Lai_shijin@163.com
 * @Date: 2022/9/27 16:52
 */
@Service("teaService")
@Transactional
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    /**
     * Teacher登录方法
     * @param loginForm
     * @return
     */
    @Override
    public Teacher login(LoginForm loginForm) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",loginForm.getUsername());
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));
        Teacher teacher = baseMapper.selectOne(queryWrapper);
        return teacher;
    }

    @Override
    public Teacher getByTeacherById(Long userId) {
        QueryWrapper<Teacher> queryWrapper=new QueryWrapper<Teacher>();
        queryWrapper.eq("id",userId);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<Teacher> getTeachersByOpr(Page<Teacher> pageParam, Teacher teacher) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(teacher != null){
            //班级名称条件
            String clazzName = teacher.getClazzName();
            if (!StringUtils.isEmpty(clazzName)) {
                queryWrapper.eq("clazz_name",clazzName);
            }
            //教师名称条件
            String teacherName = teacher.getName();
            if(!StringUtils.isEmpty(teacherName)){
                queryWrapper.like("name",teacherName);
            }
            queryWrapper.orderByDesc("id");
            queryWrapper.orderByAsc("name");
        }
        IPage<Teacher> page = baseMapper.selectPage(pageParam, queryWrapper);

        return page;
    }
}
