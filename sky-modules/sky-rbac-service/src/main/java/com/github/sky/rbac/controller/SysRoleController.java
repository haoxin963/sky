package com.github.sky.rbac.controller;
import java.util.Map;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.sky.common.constant.CommonConstant;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.sky.common.util.Query;
import com.github.sky.common.util.R;
import com.github.sky.rbac.entity.SysRole;
import com.github.sky.rbac.service.SysRoleService;
import com.github.sky.common.web.BaseController;

/**
 * @Auther: sky
 * @Date: 2018-11-14
 * @Description: 角色控制器
 */
@RestController
@RequestMapping("/role")
public class SysRoleController extends BaseController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return SysRole
    */
    @GetMapping("/{id}")
    public R<SysRole> get(@PathVariable Integer id) {
        return new R<>(sysRoleService.selectById(id));
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
        return new R<>(sysRoleService.selectPage(new Query<>(params), new EntityWrapper<>()));
    }

    /**
     * 添加
     * @param  sysRole  实体
     * @return success/false
     */
    @PostMapping
    public R<Boolean> add(@RequestBody SysRole sysRole) {
        return new R<>(sysRoleService.insert(sysRole));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Integer id) {
        SysRole sysRole = new SysRole();
        sysRole.setRoleId(id);
        sysRole.setUpdateTime(new Date());
        sysRole.setDelFlag(CommonConstant.STATUS_DEL);
        return new R<>(sysRoleService.updateById(sysRole));
    }

    /**
     * 编辑
     * @param  sysRole  实体
     * @return success/false
     */
    @PutMapping
    public R<Boolean> edit(@RequestBody SysRole sysRole) {
        sysRole.setUpdateTime(new Date());
        return new R<>(sysRoleService.updateById(sysRole));
    }
}
