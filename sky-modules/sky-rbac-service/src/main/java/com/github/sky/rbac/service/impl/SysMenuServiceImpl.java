
package com.github.sky.rbac.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.sky.common.vo.MenuVO;
import com.github.sky.rbac.entity.SysMenu;
import com.github.sky.rbac.mapper.SysMenuMapper;
import com.github.sky.rbac.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: haoxin
 * @Date: 2018-9-12
 * @Description:菜单权限表服务实现类
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    @Cacheable(value = "menu_details", key = "#role  + '_menu'")
    public List<MenuVO> findMenuByRoleName(String role) {
        return sysMenuMapper.findMenuByRoleName(role);
    }

}
