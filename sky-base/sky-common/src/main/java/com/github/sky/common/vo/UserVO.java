
package com.github.sky.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Auther: haoxin
 * @Date: 2018-10-10 14:01
 * @Description:用户VO
 */
@Data
public class UserVO implements Serializable {


    private static final long serialVersionUID = -7187965411694767879L;
    /**
     * 主键ID
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 0-正常，1-删除
     */
    private String delFlag;
    /**
     * 手机号
     */
    private String phone;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String userImage;

    /**
     * 用户邮箱
     */
    private  String email;

    /**
     * 角色列表
     */
    private List<RoleVO> roleList;

}
