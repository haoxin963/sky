
package com.github.sky.rbac.service;


import com.baomidou.mybatisplus.service.IService;
import com.github.sky.common.vo.MenuVO;
import com.github.sky.rbac.entity.SysMenu;

import java.util.List;


/**
 * @Auther: haoxin
 * @Date: 2018-9-12
 * @Description:菜单权限表服务接口
 */
public interface SysMenuService extends IService<SysMenu> {
    /**
     * 通过角色名称查询URL 权限
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    List<MenuVO> findMenuByRoleName(String role);

}
