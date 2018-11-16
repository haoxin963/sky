package com.github.sky.rbac.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.sky.common.constant.CommonConstant;
import com.github.sky.common.util.exception.RRException;
import com.github.sky.common.vo.MenuVO;
import com.github.sky.common.vo.RoleVO;
import com.github.sky.common.vo.UserVO;
import com.github.sky.rbac.dto.UserInfo;
import com.github.sky.rbac.entity.SysRole;
import com.github.sky.rbac.entity.SysUser;
import com.github.sky.rbac.entity.SysUserRole;
import com.github.sky.rbac.mapper.SysRoleMapper;
import com.github.sky.rbac.mapper.SysUserMapper;
import com.github.sky.rbac.mapper.SysUserRoleMapper;
import com.github.sky.rbac.service.SysMenuService;
import com.github.sky.rbac.service.SysUserService;
import com.xiaoleilu.hutool.collection.CollectionUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Auther: haoxin
 * @Date: 2018-9-12 20:23
 * @Description:用户表服务实现类
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public UserVO findUserByUsername(String username) {
        UserVO  userVO=baseMapper.selectUserVoByUsername(username);
        return  userVO;
    }

    @Override
    public boolean register(UserVO userVO) {
        EntityWrapper<SysUser> entityWrapper= new EntityWrapper<>();
        SysUser mc= new SysUser();
        mc.setDelFlag(CommonConstant.STATUS_NORMAL);
        mc.setUserName(userVO.getUsername());
        entityWrapper.setEntity(mc);
        //通过社会信用代码判断用户是否存在
        List<SysUser> userlist=baseMapper.selectList(entityWrapper);
        if(userlist != null && userlist.size() > 0) {
            throw new RRException("用户已经存在");
        }

        //新增用户账号
        PasswordEncoder encode = new BCryptPasswordEncoder();
        SysUser sysUser= new SysUser();
        sysUser.setUserName(userVO.getUsername());
        sysUser.setPassword(encode.encode(userVO.getPassword()));
        sysUser.setCreateDate(new Date());
        sysUser.setUpdateDate(new Date());
        baseMapper.insert(sysUser);
        //查询角色信息
        SysRole sysrole= new SysRole();
        sysrole.setRoleCode(CommonConstant.ROLE_REST);
        sysrole.setDelFlag(CommonConstant.STATUS_NORMAL);
        sysrole = sysRoleMapper.selectOne(sysrole);
        if(sysrole.getRoleId() != null) {
            //新增权限角色表
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(sysUser.getUserId());
            userRole.setRoleId(sysrole.getRoleId());
            userRole.insert();
        }
        return true;
    }

    @Override
    public UserInfo findUserInfo(UserVO userVo) {
        SysUser condition = new SysUser();
        condition.setUserName(userVo.getUsername());
        SysUser sysUser = this.selectOne(new EntityWrapper<>(condition));

        UserInfo userInfo = new UserInfo();
        userInfo.setSysUser(sysUser);
        //设置角色列表
        List<RoleVO> roleList = userVo.getRoleList();
        List<String> roleNames = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(roleList)) {
            for (RoleVO sysRole : roleList) {
                roleNames.add(sysRole.getRoleName());
            }
        }
        String[] roles = roleNames.toArray(new String[roleNames.size()]);
        userInfo.setRoles(roles);
        return userInfo;    }


}
