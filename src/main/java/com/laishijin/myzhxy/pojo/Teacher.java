package com.laishijin.myzhxy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: Laishijin
 * @Email Lai_shijin@163.com
 * @Date: 2022/9/27 11:30
 *
 * @project: sms
 * @description: 教师信息
 */
@Data
@TableName("tb_teacher")
public class Teacher {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String tno;
    private String name;
    private char gender;
    private String password;
    private String email;
    private String telephone;
    private String address;
    private String clazzName;
    private String portraitPath;//存储头像的项目路径

}
