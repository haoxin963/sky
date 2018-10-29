
package com.github.sky.zuul.service;

import com.netflix.zuul.context.RequestContext;

/**
 * @Auther: haoxin
 * @Date: 2018-9-29 16:04
 * @Description:日志服务
 */
public interface LogSendService {
    /**
     * 往消息通道发消息
     *
     * @param requestContext requestContext
     */
    void send(RequestContext requestContext);
}
