
package com.github.sky.rbac.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.sky.common.vo.MenuVO;
import com.github.sky.rbac.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: haoxin
 * @Date: 2018-9-12
 * @Description:菜单权限表Mapper接口
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 通过角色名查询菜单
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    List<MenuVO> findMenuByRoleName(@Param("role") String role);
}