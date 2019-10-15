package com.shiro.demoshiro.realm;
import com.shiro.demoshiro.dto.SysUser;
import com.shiro.demoshiro.service.ISysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private ISysUserService iSysUserService;
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

        SysUser sysUser = iSysUserService.selectUserByLoginName(username);
        System.out.println(sysUser);
        // 第一参数为认证的信息，对应授权信息
        // 第二参数为校验的用户密码
        // 第三参数为校验的盐值
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysUser,sysUser.getPassword(),ByteSource.Util.bytes(sysUser.getSalt()), getName());

        return info;
    }

    @Override
    public String getName() {
        return MyShiroRealm.class.getName();
    }
}