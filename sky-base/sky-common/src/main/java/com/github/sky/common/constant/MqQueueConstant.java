
package com.github.sky.common.constant;

/**
 * @Auther: haoxin
 * @Date: 2018-9-11 15:23
 * @Description:消息队列常量
 */
public interface MqQueueConstant {
    /**
     * log rabbit队列名称
     */
    String LOG_QUEUE = "log";

    /**
     * 发送短信验证码队列
     */
    String MOBILE_CODE_QUEUE = "mobile_code_queue";

    /**
     * zipkin 队列
     */
    String ZIPKIN_NAME_QUEUE = "zipkin";

}
