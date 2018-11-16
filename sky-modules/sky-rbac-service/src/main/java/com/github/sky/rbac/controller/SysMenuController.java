package com.github.sky.rbac.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.sky.common.constant.CommonConstant;
import com.github.sky.common.util.Query;
import com.github.sky.common.util.R;
import com.github.sky.common.vo.MenuVO;
import com.github.sky.common.web.BaseController;
import com.github.sky.rbac.entity.SysMenu;
import com.github.sky.rbac.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Auther: haoxin
 * @Date: 2018-9-12
 * @Description: 菜单权限控制类
 */
@RestController
@RequestMapping("/menu")
public class SysMenuController extends BaseController {
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 通过角色名称查询用户菜单
     * @param role
     * @return
     */
    @GetMapping("/findMenuByRole/{role}")
    public List<MenuVO> findMenuByRole(@PathVariable String role) {
        return sysMenuService.findMenuByRoleName(role);
    }

    /**
     * 通过ID查询
     *
     * @param id ID
     * @return SysMenu
     */
    @GetMapping("/{id}")
    public R<SysMenu> get(@PathVariable Integer id) {
        return new R<>(sysMenuService.selectById(id));
    }


    /**
     * 分页查询信息
     *
     * @param params 分页对象
     * @return 分页对象
     */
    @RequestMapping("/page")
    public R<Page> page(@RequestParam Map<String, Object> params) {
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        return new R<>(sysMenuService.selectPage(new Query<>(params), new EntityWrapper<>()));
    }

    /**
     * 添加
     * @param  sysMenu  实体
     * @return success/false
     */
    @PostMapping
    public R<Boolean> add(@RequestBody SysMenu sysMenu) {
        return new R<>(sysMenuService.insert(sysMenu));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Integer id) {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenuId(id);
        sysMenu.setUpdateTime(new Date());
        sysMenu.setDelFlag(CommonConstant.STATUS_DEL);
        return new R<>(sysMenuService.updateById(sysMenu));
    }

    /**
     * 编辑
     * @param  sysMenu  实体
     * @return success/false
     */
    @PutMapping
    public R<Boolean> edit(@RequestBody SysMenu sysMenu) {
        sysMenu.setUpdateTime(new Date());
        return new R<>(sysMenuService.updateById(sysMenu));
    }
}
