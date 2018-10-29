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
 * @Description:维修项目
 */
@TableName("rr_repair_item")
public class RrRepairItem extends Model<RrRepairItem> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId("item_id")
    private String itemId;
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
     * 维修项目名称
     */
    private String repairproject;
    /**
     * 维修工时
     */
    private Double workinghours;
    /**
     * 备注
     */
    private String repairmark;
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


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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

    public String getRepairproject() {
        return repairproject;
    }

    public void setRepairproject(String repairproject) {
        this.repairproject = repairproject;
    }

    public Double getWorkinghours() {
        return workinghours;
    }

    public void setWorkinghours(Double workinghours) {
        this.workinghours = workinghours;
    }

    public String getRepairmark() {
        return repairmark;
    }

    public void setRepairmark(String repairmark) {
        this.repairmark = repairmark;
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
        return this.itemId;
    }

    @Override
    public String toString() {
        return "RrRepairItem{" +
        ", itemId=" + itemId +
        ", recordId=" + recordId +
        ", maintId=" + maintId +
        ", repairproject=" + repairproject +
        ", workinghours=" + workinghours +
        ", repairmark=" + repairmark +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", updateDate=" + updateDate +
        ", updateUser=" + updateUser +
        ", delFlag=" + delFlag +
        "}";
    }
}
