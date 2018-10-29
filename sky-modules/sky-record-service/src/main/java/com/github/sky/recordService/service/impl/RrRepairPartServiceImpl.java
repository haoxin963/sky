package com.github.sky.recordService.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.sky.recordService.entity.RrRepairPart;
import com.github.sky.recordService.mapper.RrRepairPartMapper;
import com.github.sky.recordService.service.IRrRepairPartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: haoxin
 * @Date: 2018-10-11 15:15
 * @Description:维修配件服务实现类
 */
@Service
public class RrRepairPartServiceImpl extends ServiceImpl<RrRepairPartMapper, RrRepairPart> implements IRrRepairPartService {

    @Override
    @Transactional
    public boolean addVehiclePartsBatch(List<RrRepairPart> partsList) {
        return this.insertBatch(partsList);
    }

}
