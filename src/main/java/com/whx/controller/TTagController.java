package com.whx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whx.entity.TTag;
import com.whx.service.TTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author weixi
 * @since 2020-06-22
 */
@Api(description = "标签")
@Controller
@RequestMapping("/t-tag")
public class TTagController {

    @Autowired
    private TTagService tTagService;

    @ApiOperation("查询所有标签")
    @GetMapping("list")
    String list(HttpSession session){
        return findAll(session);
    }

    @ApiOperation("查询所有学生级别标签")
    @ResponseBody
    @GetMapping("studentlist")
    List<TTag> studentlist(){
        QueryWrapper<TTag> wrapper = new QueryWrapper<>();
        wrapper.eq("type","学生");
        return tTagService.getBaseMapper().selectList(wrapper);
    }

    private String findAll(HttpSession session) {
        List<TTag> tags = tTagService.list();
        session.setAttribute("tags",tags);
        return "back/tag/index";
    }

    @ApiOperation("新增标签")
    @PostMapping("save")
    String Save(TTag tTag, HttpSession session){
        tTagService.save(tTag);
        return findAll(session);
    }

    @GetMapping("deletebyid")
    @ApiOperation("根据id删除标签")
    String deleteById(@RequestParam("id") Integer id, HttpSession session){
        tTagService.removeById(id);
        return findAll(session);
    }
}

