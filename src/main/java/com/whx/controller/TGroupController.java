package com.whx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whx.entity.TGroup;
import com.whx.entity.vo.GroupVo;
import com.whx.service.TGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author weixi
 * @since 2020-06-22
 */
@Api(description = "组")
@Controller
@RequestMapping("/t-group")
public class TGroupController {

    @Autowired
    private TGroupService tGroupService;

    @ApiOperation("查询所有组和对应的班级及标签")
    @RequestMapping("list")
    String list(HttpSession session){
        return findAll(session);
    }

    @ApiOperation("新增小组")
    @RequestMapping("save")
    String save(GroupVo groupVo,HttpSession session){
        tGroupService.saves(groupVo);
        list(session);
        return findAll(session);
    }

    @ApiOperation("根据clazzid查询")
    @RequestMapping("findByClazzId")
    @ResponseBody
    List<TGroup> findByClazzId(@RequestParam("id") Integer id){
        QueryWrapper<TGroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("clazzid",id);
        return tGroupService.getBaseMapper().selectList(queryWrapper);
    }

    @RequestMapping("deletebyid")
    @ApiOperation("根据id删除组")
    String deleteById(@RequestParam("id") Integer id, HttpSession session){
        tGroupService.removeById(id);
        return findAll(session);
    }

    private String findAll(HttpSession session) {
        List<GroupVo> groups = tGroupService.findAll();
        session.setAttribute("groups",groups);
        System.out.println(groups.get(0).getTagname());
        return "back/group/index";
    }

}

