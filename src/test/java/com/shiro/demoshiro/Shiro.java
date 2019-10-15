package com.shiro.demoshiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;


public class Shiro {
    @Test
    public void initSecurityManager() {
        //1、初始化 SecurityManager 工厂，此处使用 IniRealm 配置文件初始化SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        UserRealm iniRealm = new UserRealm();
        defaultSecurityManager.setRealm(iniRealm);
        //2、得到 SecurityManager 实例 并绑定给SecurityUtils
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //3、得到 Subject 及创建用户名/密码身份验证 Token(即用户身份/凭证)
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "1111");
        try { //4、登录，即身份验证
            subject.login(token);
            System.out.println(subject.isAuthenticated());
            subject.checkPermission("role1");
            boolean b = subject.hasRole("role1");
            System.out.println("拥有的全权限" + b);
        } catch (IncorrectCredentialsException e) {
            System.out.println("凭证错误");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录        //6、退出
        subject.logout();
    }
}
