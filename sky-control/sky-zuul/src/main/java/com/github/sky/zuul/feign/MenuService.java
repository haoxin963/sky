package com.github.sky.zuul.feign;

import com.github.sky.common.vo.MenuVO;
import com.github.sky.zuul.feign.fallback.MenuServiceFallbackImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

/**
 * @Auther: haoxin
 * @Date: 2018-9-29 17:23
 * @Description:根据角色获取菜单
 */
@FeignClient(name = "sky-rbac-service", fallback = MenuServiceFallbackImpl.class)
public interface MenuService {
    /**
     * 通过角色名查询菜单
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    @GetMapping(value = "/menu/findMenuByRole/{role}")
    Set<MenuVO> findMenuByRole(@PathVariable("role") String role);
}
