package com.github.sky.rbac.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: haoxin
 * @Date: 2018-9-12 20:14
 * @Description:用户表
 */
@TableName("sys_user")
@Data
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    /**
     * 登陆名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 最后登陆时间
     */
    @TableField("last_login_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;
    /**
     * 最后登陆ip
     */
    @TableField("last_login_ip")
    private String lastLoginIp;
    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 用户头像
     */
    @TableField("user_image")
    private String userImage;

    /**
     * 邮箱
     */
    private String email;
    /**
     * 创建时间
     */
    @TableField("create_date")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    /**
     * 创建用户
     */
    @TableField("create_user")
    private Long createUser;
    /**
     * 更新时间
     */
    @TableField("update_date")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    /**
     * 更新用户
     */
    @TableField("update_user")
    private Long updateUser;
    /**
     * 是否有效(0-未删除，1-已删除)
     */
    @TableField("del_flag")
    private String delFlag;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}
