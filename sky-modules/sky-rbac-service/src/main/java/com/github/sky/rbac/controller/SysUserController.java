package com.github.sky.rbac.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.sky.common.constant.CommonConstant;
import com.github.sky.common.util.Query;
import com.github.sky.common.util.R;
import com.github.sky.common.vo.UserVO;
import com.github.sky.common.web.BaseController;
import com.github.sky.rbac.dto.UserInfo;
import com.github.sky.rbac.entity.SysUser;
import com.github.sky.rbac.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * @Auther: haoxin
 * @Date: 2018-9-12 20:10
 * @Description: 用户控制类
 */
@RestController
@RequestMapping("/user")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 通过用户名查询用户及其角色信息
     *
     * @param username 用户名
     * @return UseVo 对象
     */
    @GetMapping("/findUserByUsername/{username}")
    public UserVO findUserByUsername(@PathVariable String username) {
        return sysUserService.findUserByUsername(username);
    }

    /**
     *  用户注册
     * @param userVO 用户VO
     * @return
     */
    @PostMapping("/register")
    public R<Boolean> register(@RequestBody UserVO userVO){
        boolean f = sysUserService.register(userVO);
        return  new R<>(f);
    }

    /**
     *  获取用户信息
     * @return
     */
    @GetMapping("/info")
    public R<UserInfo> user() {
        UserVO userVo = getUserVO();
        UserInfo userInfo = sysUserService.findUserInfo(userVo);
        return new R<>(userInfo);
    }

    /**
     * 通过ID查询
     *
     * @param id ID
     * @return SysUser
     */
    @GetMapping("/{id}")
    public R<SysUser> get(@PathVariable Integer id) {
        return new R<>(sysUserService.selectById(id));
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
        return new R<>(sysUserService.selectPage(new Query<>(params), new EntityWrapper<>()));
    }

    /**
     * 添加
     * @param  sysUser  实体
     * @return success/false
     */
    @PostMapping
    public R<Boolean> add(@RequestBody SysUser sysUser) {
        return new R<>(sysUserService.insert(sysUser));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Integer id) {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(id);
        sysUser.setUpdateDate(new Date());
        sysUser.setDelFlag(CommonConstant.STATUS_DEL);
        return new R<>(sysUserService.updateById(sysUser));
    }

    /**
     * 编辑
     * @param  sysUser  实体
     * @return success/false
     */
    @PutMapping
    public R<Boolean> edit(@RequestBody SysUser sysUser) {
        sysUser.setUpdateDate(new Date());
        return new R<>(sysUserService.updateById(sysUser));
    }
}
