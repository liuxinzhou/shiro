package com.shiro.demoshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @PostMapping("/doLogin")
    public void doLogin(String username, String password) {
        System.out.println("username==" + username + "   password" + password);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        System.out.println(token.getPassword());
        try { //4、登录，即身份验证
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            System.out.println("凭证错误");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/login")
    public String login() {
        return "please login!";
    }

    @GetMapping("/index")
    public String index() {
        System.out.println("获取成功");
        return "index";
    }

    @GetMapping("/unauthorizedurl")
    public String unauthorizedurl() {
        System.out.println("unauthorizedurl");

        return "unauthorizedurl";
    }

    @RequiresPermissions("role1")
    @GetMapping("/getMenus")
    public String getMenus() {
        return "success";
    }

    @RequiresPermissions("role2")
    @GetMapping("/getGetRoles")
    public String getGetRoles() {
        return "success";
    }
}
