package com.github.sky.recordService.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.sky.recordService.entity.RrRepairItem;
import com.github.sky.recordService.mapper.RrRepairItemMapper;
import com.github.sky.recordService.service.IRrRepairItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: haoxin
 * @Date: 2018-10-11 15:15
 * @Description:维修项目服务实现类
 */
@Service
public class RrRepairItemServiceImpl extends ServiceImpl<RrRepairItemMapper, RrRepairItem> implements IRrRepairItemService {

    @Override
    @Transactional
    public boolean addRepairProjectBatch(List<RrRepairItem> repairProjectList) {
        return this.insertBatch(repairProjectList);
    }
}
