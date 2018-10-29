package com.github.sky.auth.util;

import com.alibaba.fastjson.JSONObject;
import com.github.sky.common.constant.CommonConstant;
import com.github.sky.common.constant.SecurityConstants;
import com.github.sky.common.util.RedisUtil;
import com.github.sky.common.vo.RoleVO;
import com.github.sky.common.vo.UserVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Auther: haoxin
 * @Date: 2018-9-11 13:57
 * @Description:用户信息扩展
 */
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Integer userId;
    private String username;
    private String password;
    private String status;
    private List<RoleVO> roleList;

    public UserDetailsImpl(UserVO userVo) {
        if(userVo != null && userVo.getUserId() != null) {
            String userId = String.valueOf(userVo.getUserId());
            String userVoStr = JSONObject.toJSONString(userVo);
            RedisUtil.set(CommonConstant.USERVO_PRIF+userId,userVoStr);
        }
        this.userId = userVo.getUserId();
        this.username = userVo.getUsername();
        this.password = userVo.getPassword();
        this.status = userVo.getDelFlag();
        roleList = userVo.getRoleList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (RoleVO role : roleList) {
            authorityList.add(new SimpleGrantedAuthority(role.getRoleCode()));
        }
        //authorityList.add(new SimpleGrantedAuthority(SecurityConstants.BASE_ROLE));
        return authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !StringUtils.equals(CommonConstant.STATUS_LOCK, status);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return StringUtils.equals(CommonConstant.STATUS_NORMAL, status);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleVO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleVO> roleList) {
        this.roleList = roleList;
    }

    public String getStatus() {
        return status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
