package com.github.sky.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: haoxin
 * @Date: 2018-10-10 14:21
 * @Description:维修项目VO
 */
@Data
@ApiModel(value="维修项目")
public class RepairProjectVO  implements Serializable {

    private static final long serialVersionUID = -4645980130515634211L;
    /**
     * 维修项目
     */
    @ApiModelProperty(value="维修项目",example="换机油")
    private String repairproject;

    /**
     * 维修工时
     */
    @ApiModelProperty(value="维修工时",example="2")
    private Double workinghours;
}
