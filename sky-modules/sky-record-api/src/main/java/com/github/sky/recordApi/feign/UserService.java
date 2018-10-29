package com.github.sky.recordApi.feign;

import com.github.sky.common.util.R;
import com.github.sky.common.vo.UserVO;
import com.github.sky.recordApi.feign.fallback.UserServiceFallbackImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Auther: haoxin
 * @Date: 2018-10-10 17:16
 * @Description:用户注册
 */
@FeignClient(name = "sky-rbac-service", fallback = UserServiceFallbackImpl.class)
public interface UserService {

    @PostMapping("/user/register")
    R<Boolean> register(@RequestBody UserVO userVO);
}
