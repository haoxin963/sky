package com.github.sky.recordService.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.sky.recordService.entity.RrRepairItem;

import java.util.List;


/**
 * @Auther: haoxin
 * @Date: 2018-10-11 15:15
 * @Description:维修项目服务类
 */
public interface IRrRepairItemService extends IService<RrRepairItem> {
    /**
     * 添加维修项目
     * @param repairProjectList 维修项目列表
     * @return
     */
    boolean addRepairProjectBatch(List<RrRepairItem> repairProjectList);
}
