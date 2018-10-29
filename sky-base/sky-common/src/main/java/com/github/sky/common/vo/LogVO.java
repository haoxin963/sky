
package com.github.sky.common.vo;

import com.github.sky.common.entity.SysLog;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: haoxin
 * @Date: 2018-10-10 14:01
 * @Description:日志VO
 */
@Data
public class LogVO implements Serializable {

    private static final long serialVersionUID = -1788470193748148448L;
    private SysLog sysLog;
    private String username;
}
