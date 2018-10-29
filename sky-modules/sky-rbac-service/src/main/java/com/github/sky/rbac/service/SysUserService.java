package com.github.sky.rbac.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.sky.common.vo.MenuVO;
import com.github.sky.common.vo.UserVO;
import com.github.sky.rbac.entity.SysUser;

import java.util.List;

/**
 * @Auther: haoxin
 * @Date: 2018-9-12 20:14
 * @Description:用户表服务接口
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 根据用户名查询用户角色信息
     *
     * @param username 用户名
     * @return userVo
     */
    UserVO findUserByUsername(String username);

    /**
     * 注册用户
     * @param userVO
     * @return
     */
    boolean register(UserVO userVO);

}
