
package com.github.sky.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: haoxin
 * @Date: 2018-10-10 14:01
 * @Description:角色VO
 */
@Data
public class RoleVO implements Serializable {

    private static final long serialVersionUID = 7810986529201926881L;
    private Integer roleId;
    private String roleName;
    private String roleCode;
    private String roleDesc;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String delFlag;

}
