
package com.github.sky.rbac.dto;

import com.github.sky.rbac.entity.SysUser;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    /**
     * 用户基本信息
     */
    private SysUser sysUser;

    /**
     * 角色集合
     */
    private String[] roles;
}
