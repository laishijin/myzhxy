package com.laishijin.myzhxy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.laishijin.myzhxy.pojo.Grade;
import com.laishijin.myzhxy.service.GradeService;
import com.laishijin.myzhxy.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Laishijin
 * @Email Lai_shijin@163.com
 * @Date: 2022/9/27 16:55
 *
 * 年级控制器
 */
@Api(tags = "年级控制器")
@RestController
@RequestMapping("/sms/gradeController")
public class GradeController {
    // 整个控制器的的思想是，接受过来的参数，房间Page里面，调用service层，使用querywapper进行封装数据，最后使用basemapper查询
    //结果然后返回。
    @Autowired
    private GradeService gradeService;

    @ApiOperation("年级查询功能")
    @GetMapping("/getGrades/{pageNo}/{pageSize}")
    public Result getGradeByOpr(
            @ApiParam("分页查询页码数") @PathVariable(value = "pageNo") Integer pageNo,
            @ApiParam("分页查询页大小") @PathVariable(value = "pageSize") Integer pageSize,
            @ApiParam("分页模糊查询匹配班级名")String gradeName)
    {
        //设置分页信息
        Page<Grade> page = new Page<>(pageNo, pageSize);
        //调用服务层方法，传入分页信息，和查询条件
        IPage<Grade> pageRs = gradeService.getGradeByOpr(page, gradeName);

        return  Result.ok(pageRs);
    }

    @ApiOperation("年级删除功能")
    @DeleteMapping("/deleteGrade")
    public Result deleteGradeById(
            @ApiParam("JSON的年级id集合,映射为后台List<Integer>")@RequestBody List<Integer> ids
    )
    {
        gradeService.removeByIds(ids);
        return Result.ok();
    }

      @ApiOperation("年级更新功能")
      @PostMapping("/saveOrUpdateGrade")
      public Result saveOrUpdateGrade(
        @ApiParam("JSON的grade对象转换后台数据模型") @RequestBody Grade grade
      ){
        //直接调用存入
        gradeService.saveOrUpdate(grade);
        return  Result.ok();

      }

    @ApiOperation("获取所有Grade信息")
    @GetMapping("/getGrades")
    public Result getGrades(){
        List<Grade> grades = gradeService.getGrades();
        return Result.ok(grades);
    }
}
