package com.laishijin.myzhxy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.laishijin.myzhxy.pojo.Grade;

import java.util.List;

/**
 * @Author: Laishijin
 * @Email Lai_shijin@163.com
 * @Date: 2022/9/27 16:38
 */
public interface GradeService extends IService<Grade> {
    IPage getGradeByOpr(Page<Grade> page, String gradeName);

    List<Grade> getGrades();
}
