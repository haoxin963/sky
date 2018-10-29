package com.github.sky.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: haoxin
 * @Date: 2018-10-10 14:12
 * @Description:维修配件VO
 */
@Data
@ApiModel(value="维修配件")
public class VehiclePartsVO implements Serializable {


    private static final long serialVersionUID = 2926039496785399631L;
    /**
     * 配件名称
     */
    @ApiModelProperty(value="配件名称",example="机油")
    private String partsname;

    /**
     * 配件数量
     */
    @ApiModelProperty(value="配件数量",example="2L")
    private Double partsquantity;

    /**
     * 配件编码
     */
    @ApiModelProperty(value="配件编码",example="CC001")
    private String partscode;
}
