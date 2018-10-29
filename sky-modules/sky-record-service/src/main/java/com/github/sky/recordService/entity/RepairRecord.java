package com.github.sky.recordService.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: haoxin
 * @Date: 2018-10-19 10:22
 * @Description:维修记录包装类
 */
@Data
public class RepairRecord implements Serializable {

    /**
     * 维修记录基本信息
     */
    private RrRepairRecord rrRepairRecord;

    /**
     * 维修项目信息
     */
    private List<RrRepairItem> rrRepairItems;

    /**
     * 维修配件信息
     */
    private List<RrRepairPart> rrRepairParts;

}
