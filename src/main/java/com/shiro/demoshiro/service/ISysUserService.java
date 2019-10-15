package com.shiro.demoshiro.service;

import com.shiro.demoshiro.dto.SysUser;

import java.util.List;

/**
 * 用户 业务层
 * 
 * @author ruoyi
 */
public interface ISysUserService
{
    /**
     * 根据条件分页查询用户列表
     * 
     * @param userName 用户信息
     * @return 用户信息集合信息
     */
    public SysUser selectUserByLoginName(String  userName);

}
