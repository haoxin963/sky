package com.github.sky.recordApi.controller;

import com.github.sky.common.util.R;
import com.github.sky.common.util.SmsUtil;
import com.github.sky.common.vo.UserVO;
import com.github.sky.common.web.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: haoxin
 * @Date: 2018-10-15 14:37
 * @Description:短信发送
 */
@RestController
@RequestMapping("/sms")
@Slf4j
public class SmsController extends BaseController {

    @PostMapping("/send")
    public R<String> send(String mobile) {
        Long userId = getUserId();
        UserVO user = getUserVOByUserId(String.valueOf(userId));
        logger.info("userId=>"+userId);
        logger.info("user=>"+user.toString());
        return new R<>(SmsUtil.sendVerificationCode(mobile));
    }
}
