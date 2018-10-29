package com.github.sky.rbac.controller;

import com.github.sky.common.util.R;
import com.github.sky.common.vo.UserVO;
import com.github.sky.rbac.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: haoxin
 * @Date: 2018-9-12 20:10
 * @Description: 用户控制类
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserService userService;

    /**
     * 通过用户名查询用户及其角色信息
     *
     * @param username 用户名
     * @return UseVo 对象
     */
    @GetMapping("/findUserByUsername/{username}")
    public UserVO findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    /**
     *  用户注册
     * @param userVO 用户VO
     * @return
     */
    @PostMapping("/register")
    public R<Boolean> register(@RequestBody UserVO userVO){
        boolean f = userService.register(userVO);
        return  new R<>(f);
    }

}
