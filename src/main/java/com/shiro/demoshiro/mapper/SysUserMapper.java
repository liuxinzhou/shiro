package com.shiro.demoshiro.mapper;

import com.shiro.demoshiro.dto.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表 数据层
 * 
 * @author ruoyi
 */
@Repository
public interface SysUserMapper
{
    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByLoginName(String userName);
}
