package com.github.sky.common.constant.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: haoxin
 * @Date: 2018-10-15 14:49
 * @Description:短信通道模板
 */
public enum EnumSmsChannelTemplate {
    /**
     * 登录验证
     */
    LOGIN_NAME_LOGIN("loginCodeChannel", "sky");


    /**
     * 模板名称
     */
    @Getter
    @Setter
    private String template;
    /**
     * 模板签名
     */
    @Getter
    @Setter
    private String signName;

    EnumSmsChannelTemplate(String template, String signName) {
        this.template = template;
        this.signName = signName;
    }
}
