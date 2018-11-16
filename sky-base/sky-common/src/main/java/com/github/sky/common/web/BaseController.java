package com.github.sky.common.web;

import com.alibaba.fastjson.JSON;
import com.github.sky.common.constant.CommonConstant;
import com.github.sky.common.util.RedisUtil;
import com.github.sky.common.util.UserUtils;
import com.github.sky.common.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: haoxin
 * @Date: 2018-9-20 13:58
 * @Description:基础控制类
 */
public class BaseController {
    @Autowired
    private HttpServletRequest request;
    protected org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    /**
     * 根据请求heard中的token获取用户ID
     *
     * @return 用户ID
     */
    public Long getUserId() {
        return UserUtils.getUserId(request);
    }

    /**
     * 获取用户详情
     * @return
     */
    public UserVO getUserVO() {
        String userVOStr = RedisUtil.get(CommonConstant.USERVO_PRIF+UserUtils.getUserId(request));
        UserVO userVO = JSON.parseObject(userVOStr, UserVO.class);
        return userVO;
    }

    /**
     * 根据请求heard中的token获取用户角色
     *
     * @return 角色名
     */
    public List<String> getRole() {
        return UserUtils.getRole(request);
    }
}
