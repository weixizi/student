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
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author weixi
 * @since 2020-06-22
 */
@Api(description = "学生操作")
@Controller
@RequestMapping("/t-student")
public class TStudentController {


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

        if (StringUtils.isEmpty(pageNow)) {
            pageNow = "0";
        }

        if (searchValue == null && searchCol == null){
             studentVo = (StudentVo) session.getAttribute("studentVo");
        }
        session.setAttribute("studentVo", studentVo);

        studentPage = tStudentService.findAll(studentVo, Integer.parseInt(pageNow));
        List<StudentVo> students = studentPage.getRecords();
        long total = studentPage.getTotal();
        long current = studentPage.getCurrent();
        long pages = studentPage.getPages();

        session.setAttribute("students", students);
        session.setAttribute("total", total);
        session.setAttribute("pageNow", current);
        session.setAttribute("pages", pages);


        return "forward:/back/student/index.jsp";
    }

    @ApiOperation("添加学生")
    @PostMapping("save")
    public String save(TStudent tStudent) {
        tStudentService.save(tStudent);
        return "forward:/back/student/index.jsp";
    }

    @GetMapping("deletebyid")
    public String deleteById(@RequestParam Integer id) {
        tStudentService.removeById(id);
        return "forward:/back/student/index.jsp";
    }
}

