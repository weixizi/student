package com.whx.controller;



import com.whx.entity.TClazz;
import com.whx.entity.vo.ClazzVo;
import com.whx.service.TClazzService;
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
@Api(description = "班级")
@Controller
@RequestMapping("/t-clazz")
public class TClazzController {

    @Autowired
    private TClazzService tClazzService;

    @ApiOperation("查询所有班级和对应的标签")
    @GetMapping("list")
    String list(HttpSession session){
        return findAll(session);
    }



    @ResponseBody
    @GetMapping("findAllClazzJSON")
    List<TClazz> findAllClazzJSON(HttpSession session){
        return tClazzService.list();
    }

    @ApiOperation("保存班级")
    @PostMapping("save")
    String save(ClazzVo clazzVo,HttpSession session){
        tClazzService.saves(clazzVo);
        list(session);
        return findAll(session);
    }

    @GetMapping("deletebyid")
    @ApiOperation("根据id删除班级")
    String deleteById(@RequestParam("id") Integer id, HttpSession session){
        tClazzService.removeById(id);
        list(session);
        return findAll(session);
    }

    private String findAll(HttpSession session) {
        List<ClazzVo> clazzes = tClazzService.findAll();
        session.setAttribute("clazzes",clazzes);
        return "back/clazz/index";
    }


}

