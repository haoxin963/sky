package com.github.sky.auth.service;

import com.github.sky.auth.feign.UserService;
import com.github.sky.auth.util.UserDetailsImpl;
import com.github.sky.common.util.exception.RRException;
import com.github.sky.common.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Auther: haoxin
 * @Date: 2018-9-11 13:57
 * @Description:用户详情服务
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO userVo = userService.findUserByUsername(username);
        if(userVo != null && userVo.getUserId() != null) {
            return new UserDetailsImpl(userVo);
        } else {
            throw new RRException("用户不存在");
        }
    }
}
