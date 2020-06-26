package com.whx.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whx.entity.TStudent;
import com.whx.entity.vo.StudentVo;
import com.whx.service.TStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author weixi
 * @since 2020-06-22
 */
@Api(description = "学生操作")
@Controller
@RequestMapping("/t-student")
public class TStudentController {

    HashMap<String, String> map;

    @Autowired
    private TStudentService tStudentService;

    @GetMapping("list")
    public List<TStudent> list() {
        return tStudentService.list();
    }

    @ApiOperation("分页查询学生")
    @RequestMapping("findAll")
    public String finAll(String searchCol, String searchValue, HttpSession session, @RequestParam String pageNow) {
        StudentVo studentVo = new StudentVo();
        Page<StudentVo> studentPage;

        if (!StringUtils.isEmpty(searchValue)) {
            if (searchCol.equals("name")) {
                studentVo.setName("%" + searchValue + "%");
            }
            if (searchCol.equals("clazzname")) {
                studentVo.setClazzname("%" + searchValue + "%");
            }
            if (searchCol.equals("phone")) {
                studentVo.setPhone("%" + searchValue + "%");
            }
            if (searchCol.equals("qq")) {
                studentVo.setQq("%" + searchValue + "%");
            }
        }

        if (StringUtils.isEmpty(pageNow)){
            pageNow = "0";
        }
        studentPage = tStudentService.findAll(studentVo,Integer.parseInt(pageNow));
        List<StudentVo> students = studentPage.getRecords();
        long total = studentPage.getTotal();
        long current = studentPage.getCurrent();
        long pages = studentPage.getPages();

        session.setAttribute("students",students);
        session.setAttribute("total",total);
        session.setAttribute("pageNow",current);
        session.setAttribute("pages",pages);


        return "back/student/index";
    }

    @ApiOperation("添加学生")
    @RequestMapping("save")
    @ResponseBody
    public void save(TStudent tStudent){
        tStudentService.save(tStudent);
    }

    @ResponseBody
    @RequestMapping("deletebyid")
    public void deleteById(@RequestParam Integer id){
        tStudentService.removeById(id);
    }
}

