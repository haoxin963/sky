package com.github.sky.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Auther: haoxin
 * @Date: 2018-10-10 14:01
 * @Description:维修基本信息VO
 */
@Data
@ApiModel(value="维修记录")
public class RecordVO implements Serializable {

    private static final long serialVersionUID = -5064358616498324959L;
    /**
     * 车牌号码
     */
    @NotBlank(message="车牌号码不能为空")
    @ApiModelProperty(value="车牌号码",example="苏B12345")
    private String vehicleplatenumber;

    /**
     * 维修企业名称
     */
    @NotBlank(message="维修企业名称不能为空")
    @ApiModelProperty(value="维修企业名称",example="汽修厂")
    private String companyname;

    /**
     * 维修记录id
     */
    private String recordid;

    /**
     * 企业编码
     */
    private String companycode;

    /**
     * 企业id
     */
    private long companyid;

    /**
     * 新增时间
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date createdate;

    /**
     * 车辆识别代码
     */
    @NotBlank(message="车辆识别代码不能为空")
    @ApiModelProperty(value="车辆识别代码",example="LS123344333")
    private String vin;

    /**
     * 送修日期
     */
    @JsonFormat(pattern="yyyyMMdd")
    @ApiModelProperty(value="送修日期",example="20181010")
    private Date repairdate;

    /**
     * 送修里程
     */
    @ApiModelProperty(value="送修里程",example="7000")
    private double repairmileage;

    /**
     * 结算日期
     */
    @JsonFormat(pattern="yyyyMMdd")
    @ApiModelProperty(value="结算日期",example="20181010")
    private Date settledate;

    /**
     * 故障描述
     */
    @ApiModelProperty(value="故障描述",example="保养")
    private String faultdescription;

    /**
     * 结算清单编号
     */
    @ApiModelProperty(value="结算清单编号",example="BY001")
    private String costlistcode;

    /**
     * 维修项目列表
     */
    private List<RepairProjectVO> repairprojectlist;

    /**
     * 维修配件列表
     */
    private List<VehiclePartsVO> vehiclepartslist;
}
