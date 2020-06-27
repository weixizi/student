package com.whx.controller;


import com.whx.entity.TCity;
import com.whx.service.TCityService;
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
@Api(description="城市")
@Controller
@RequestMapping("/t-city")
public class TCityController {

    @Autowired
    private TCityService tCityService;

    @ApiOperation("查询所有城市")
    @GetMapping("list")
    String list(HttpSession session){
        return findAll(session);
    }

    @ApiOperation("查询所有城市Json格式")
    @GetMapping("findAllJSON")
    @ResponseBody
    List<TCity> findAllJSON(){
        return tCityService.list();
    }

    @ApiOperation("新增城市")
    @PostMapping("save")
    String Save(TCity tCity,HttpSession session){
        if (tCity.getNumbers() == null){
            tCity.setNumbers(0);
        }
        tCityService.save(tCity);
        list(session);

        return findAll(session);
    }

    @GetMapping("deletebyid")
    @ApiOperation("根据id删除城市")
    String deleteById(@RequestParam("id") Integer id, HttpSession session){
        tCityService.removeById(id);
        list(session);
        return findAll(session);
    }

    @ApiOperation("查询所有城市,动态刷新")
    private String findAll(HttpSession session) {
        List<TCity> cities = tCityService.list();
        session.setAttribute("cities", cities);
        return "back/city/index";
    }
}

