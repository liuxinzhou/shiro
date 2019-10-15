package com.shiro.demoshiro.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.shiro.demoshiro.dto.SysRole;
import com.shiro.demoshiro.dto.SysUser;
import com.shiro.demoshiro.dto.SysUserRole;
import com.shiro.demoshiro.mapper.SysRoleMapper;
import com.shiro.demoshiro.mapper.SysUserMapper;
import com.shiro.demoshiro.service.ISysUserService;
import com.sun.tools.javac.util.Convert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户 业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysUserServiceImpl implements ISysUserService
{
    @Autowired
    SysUserMapper sysUserMapper;
    /**
     * 根据条件分页查询用户列表
     * @param userName 用户名称
     * @return 用户信息集合信息
     */
    @Override
    public SysUser selectUserByLoginName(String  userName) {
        SysUser sysUser = sysUserMapper.selectUserByLoginName(userName);
        return sysUser;
    }
}
