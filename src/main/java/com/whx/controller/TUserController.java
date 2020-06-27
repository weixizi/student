package com.whx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whx.utils.Stuart;
import com.whx.entity.TUser;
import com.whx.service.TUserService;
import com.whx.utils.ValidateImageCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 *
 * @author weixi
 * @since 2020-06-22
 */
@Api(description = "用户操作")
@Controller
@RequestMapping("/t-user")
public class TUserController {
    @Autowired
    private TUserService tUserService;

    @Autowired
    private ValidateImageCodeUtils validateImageCodeUtils;

    /**
     * 获取验证码
     * @param session
     * @param response
     */
    @ApiOperation("获取验证码")
    @RequestMapping("getImage")
    @ResponseBody
    public void getImage(HttpSession session, HttpServletResponse response) {
        String code = ValidateImageCodeUtils.getSecurityCode();
        System.out.println("code = " + code); //设置到session
        session.setAttribute("code", code);
        // 生成验证码图片
        BufferedImage image = ValidateImageCodeUtils.createImage(code);
        try {
            ImageIO.write(image, "png", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("注册用户")
    @PostMapping("register")
    @ResponseBody
    public Stuart saveUser(TUser tUser, String code, HttpSession session) {
        String code1 = (String) session.getAttribute("code");
        Stuart stuart = new Stuart();

        TUser tUser1 = findTUserByName(tUser.getName());
        if (tUser1 == null) {
            if (code.equals(code1)) {
                System.out.println(tUser);
                if (StringUtils.isEmpty(tUser.getStatus())) {
                    tUser.setStatus("激活");
                }
                tUserService.save(tUser);
                return stuart.setMessage("注册成功").setStatus(true);
            } else {
                return stuart.setMessage("错误验证码").setStatus(false);
            }
        } else {
            return stuart.setMessage("用户名已存在").setStatus(false);
        }
    }

    @ApiOperation("登录")
    @RequestMapping("login")
    @ResponseBody
    public Stuart login(TUser tUser,String code,HttpSession session) {
        String code1 = (String) session.getAttribute("code");
        Stuart stuart = new Stuart();
        TUser tUser1 = findTUserByName(tUser.getName());
        if (!code.equals(code1) ){
            return stuart.setStatus(false).setMessage("验证码错误");
        }else {
            if (tUser1 != null && StringUtils.equals(tUser1.getPassword(), tUser.getPassword())) {
                    session.setAttribute("user", tUser1);
                    return stuart.setMessage("登录成功").setStatus(true);
            }else{
             return stuart.setMessage("账号或密码错误").setStatus(false);
            }
        }
    }

    @ApiOperation("退出")
    @GetMapping("exit")
    public String exit(HttpSession session){
        session.invalidate();;
        return "redirect:/back/login.jsp";
    }

    private TUser findTUserByName(String name){
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        TUser tUser1 = tUserService.getOne(queryWrapper);
        return tUser1;
    }
}





