package com.shiro.demoshiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义realm元素
 */
public class UserRealm extends AuthorizingRealm {


    /**
     * 授权信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
        System.out.println("获取的用户信息"+username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("role1");
        info.addRole("role1");
        return info;
    }

    /**
     * 完成身份认证，并且返回认识信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();//
        System.out.println(username);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,"1111",getName());

        return info;
    }

    @Override
    public String getName() {
        return UserRealm.class.getName();
    }
}