package com.github.sky.rbac.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.sky.common.vo.MenuVO;
import com.github.sky.common.vo.UserVO;
import com.github.sky.rbac.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: haoxin
 * @Date: 2018-9-12
 * @Description:用户表Mapper接口
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return userVo
     */
    UserVO selectUserVoByUsername(@Param("username") String username);

}
