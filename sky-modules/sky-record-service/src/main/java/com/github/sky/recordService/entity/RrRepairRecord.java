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
 * @Description:维修记录
 */
@TableName("rr_repair_record")
public class RrRepairRecord extends Model<RrRepairRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId("record_id")
    private String recordId;
    /**
     * 维修企业id
     */
    @TableField("maint_id")
    private Long maintId;
    /**
     * 维修企业名称
     */
    @TableField("maint_name")
    private String maintName;
    /**
     * 维修企业编码
     */
    @TableField("maint_code")
    private String maintCode;
    /**
     * 维修车辆识别码
     */
    private String vin;
    /**
     * 维修车辆车牌号码
     */
    private String vehicleplatenumber;
    /**
     * 送修日期
     */
    private Date repairdate;
    /**
     * 送修里程
     */
    private Double repairrmileate;
    /**
     * 维修结算日期
     */
    @JsonFormat
    private Date settledate;
    /**
     * 故障描述
     */
    private String faultdescription;
    /**
     * 故障结算清单编号
     */
    private String costlistcode;
    /**
     * 维修企业来源（1-同步，2-上级下发）
     */
    private String repaircomefrom;
    /**
     * 维修类别（字典表）
     */
    private String repairtype;
    /**
     * 维修性质（字典表）
     */
    private String repeirnature;
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
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Long updateUser;
    /**
     * 是否删除
     */
    @TableField("del_flag")
    private String delFlag;


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

    public String getMaintName() {
        return maintName;
    }

    public void setMaintName(String maintName) {
        this.maintName = maintName;
    }

    public String getMaintCode() {
        return maintCode;
    }

    public void setMaintCode(String maintCode) {
        this.maintCode = maintCode;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getVehicleplatenumber() {
        return vehicleplatenumber;
    }

    public void setVehicleplatenumber(String vehicleplatenumber) {
        this.vehicleplatenumber = vehicleplatenumber;
    }

    public Date getRepairdate() {
        return repairdate;
    }

    public void setRepairdate(Date repairdate) {
        this.repairdate = repairdate;
    }

    public Double getRepairrmileate() {
        return repairrmileate;
    }

    public void setRepairrmileate(Double repairrmileate) {
        this.repairrmileate = repairrmileate;
    }

    public Date getSettledate() {
        return settledate;
    }

    public void setSettledate(Date settledate) {
        this.settledate = settledate;
    }

    public String getFaultdescription() {
        return faultdescription;
    }

    public void setFaultdescription(String faultdescription) {
        this.faultdescription = faultdescription;
    }

    public String getCostlistcode() {
        return costlistcode;
    }

    public void setCostlistcode(String costlistcode) {
        this.costlistcode = costlistcode;
    }

    public String getRepaircomefrom() {
        return repaircomefrom;
    }

    public void setRepaircomefrom(String repaircomefrom) {
        this.repaircomefrom = repaircomefrom;
    }

    public String getRepairtype() {
        return repairtype;
    }

    public void setRepairtype(String repairtype) {
        this.repairtype = repairtype;
    }

    public String getRepeirnature() {
        return repeirnature;
    }

    public void setRepeirnature(String repeirnature) {
        this.repeirnature = repeirnature;
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
        return this.recordId;
    }

    @Override
    public String toString() {
        return "RrRepairRecord{" +
        ", recordId=" + recordId +
        ", maintId=" + maintId +
        ", maintName=" + maintName +
        ", maintCode=" + maintCode +
        ", vin=" + vin +
        ", vehicleplatenumber=" + vehicleplatenumber +
        ", repairdate=" + repairdate +
        ", repairrmileate=" + repairrmileate +
        ", settledate=" + settledate +
        ", faultdescription=" + faultdescription +
        ", costlistcode=" + costlistcode +
        ", repaircomefrom=" + repaircomefrom +
        ", repairtype=" + repairtype +
        ", repeirnature=" + repeirnature +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", updateDate=" + updateDate +
        ", updateUser=" + updateUser +
        ", delFlag=" + delFlag +
        "}";
    }
}
