package com.github.sky.recordService.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: haoxin
 * @Date: 2018-10-19 10:22
 * @Description:维修配件
 */
@TableName("rr_repair_part")
public class RrRepairPart extends Model<RrRepairPart> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId("part_id")
    private String partId;
    /**
     * 维修记录id
     */
    @TableField("record_id")
    private String recordId;

    /**
     * 维修企业id
     */
    @TableField("maint_id")
    private Long maintId;

    /**
     * 配件名称
     */
    private String partsname;
    /**
     * 配件数量
     */
    private Double partsquantity;
    /**
     * 配件编码
     */
    private String partscode;
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
     * 是否删除
     */
    @TableField("del_flag")
    private String delFlag;


    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public Long getMaintId() {
        return maintId;
    }

    public void setMaintId(Long maintId) {
        this.maintId = maintId;
    }

    public String getPartsname() {
        return partsname;
    }

    public void setPartsname(String partsname) {
        this.partsname = partsname;
    }

    public Double getPartsquantity() {
        return partsquantity;
    }

    public void setPartsquantity(Double partsquantity) {
        this.partsquantity = partsquantity;
    }

    public String getPartscode() {
        return partscode;
    }

    public void setPartscode(String partscode) {
        this.partscode = partscode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.partId;
    }

    @Override
    public String toString() {
        return "RrRepairPart{" +
        ", partId=" + partId +
        ", recordId=" + recordId +
        ", maintId=" + maintId +
        ", partsname=" + partsname +
        ", partsquantity=" + partsquantity +
        ", partscode=" + partscode +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", updateDate=" + updateDate +
        ", updateUser=" + updateUser +
        ", delFlag=" + delFlag +
        "}";
    }
}
