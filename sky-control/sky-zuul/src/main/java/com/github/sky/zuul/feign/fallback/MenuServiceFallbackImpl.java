package com.github.sky.zuul.feign.fallback;

import com.github.sky.common.vo.MenuVO;
import com.github.sky.zuul.feign.MenuService;
import com.xiaoleilu.hutool.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Auther: haoxin
 * @Date: 2018-9-29 17:24
 * @Description:
 */
@Slf4j
@Service
public class MenuServiceFallbackImpl implements MenuService {

    @Override
    public Set<MenuVO> findMenuByRole(String role) {
        log.error("调用{}异常{}","findMenuByRole",role);
        return CollUtil.newHashSet();
    }
}
