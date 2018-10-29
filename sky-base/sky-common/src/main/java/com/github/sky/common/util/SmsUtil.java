package com.github.sky.common.util;

import com.alibaba.fastjson.JSONObject;
import com.github.sky.common.constant.CommonConstant;
import com.github.sky.common.constant.MqQueueConstant;
import com.github.sky.common.constant.enums.EnumSmsChannelTemplate;
import com.github.sky.common.util.template.MobileMsgTemplate;
import com.xiaoleilu.hutool.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @Auther: haoxin
 * @Date: 2018-10-15 15:56
 * @Description:短信工具类
 */
@Slf4j
public class SmsUtil {
    private static RabbitTemplate rabbitTemplate =SpringContextHolder.getBean(RabbitTemplate.class);

    /**
     * 发送四位数字验证码，如果返回null，表示发送失败
     * @param mobile
     * @return code 验证码
     */
    public static String sendVerificationCode(String mobile) {
        String code = RandomUtil.randomNumbers(4);
        try {
            JSONObject contextJson = new JSONObject();
            contextJson.put("code", code);
            log.info("短信发送请求消息中心 -> 手机号:{} -> 验证码：{}", mobile, code);
            rabbitTemplate.convertAndSend(MqQueueConstant.MOBILE_CODE_QUEUE,
                    new MobileMsgTemplate(
                            mobile,
                            contextJson.toJSONString(),
                            CommonConstant.ALIYUN_SMS,
                            EnumSmsChannelTemplate.LOGIN_NAME_LOGIN.getSignName(),
                            EnumSmsChannelTemplate.LOGIN_NAME_LOGIN.getTemplate()
                    ));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return code;
    }

}
