package com.github.sky.recordApi.feign.fallback;

import com.github.sky.common.util.R;
import com.github.sky.common.util.exception.RRException;
import com.github.sky.common.vo.UserVO;
import com.github.sky.recordApi.feign.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Auther: haoxin
 * @Date: 2018-10-10 17:17
 * @Description:异常处理
 */
@Service
public class UserServiceFallbackImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public R<Boolean> register(@RequestBody UserVO userVO) {
        logger.error("调用注册异常:{}", "register", userVO);
        throw new RRException("调用注册服务异常");
    }
}
