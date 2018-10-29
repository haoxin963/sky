package com.github.sky.recordService.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.sky.recordService.entity.RrRepairPart;

import java.util.List;


/**
 * @Auther: haoxin
 * @Date: 2018-10-11 15:15
 * @Description:维修配件服务类
 */
public interface IRrRepairPartService extends IService<RrRepairPart> {

    /**
     *t添加维修配件
     * @param partsList 维修配件列表
     * @return
     */
    boolean addVehiclePartsBatch(List<RrRepairPart> partsList);
}
