package com.github.sky.recordService.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.github.sky.common.util.Query;
import com.github.sky.common.vo.RecordVO;
import com.github.sky.recordService.entity.RrRepairRecord;

import java.util.Map;

/**
 * @Auther: haoxin
 * @Date: 2018-10-11 15:15
 * @Description:维修记录服务类
 */
public interface IRrRepairRecordService extends IService<RrRepairRecord> {

    /**
     * 添加维修记录
     * @param record 维修记录VO
     * @param maintId 维修企业ID
     * @return
     */
    boolean add(RecordVO record, Long maintId);

    /**
     * 分页查询
     * @param query
     * @param maintId
     * @param params
     * @return
     */
    Page selectRecordVoPage(Query query, Long maintId, Map<String, Object> params);

    /**
     * 查询RecordVO
     * @param recordId
     * @param maintId
     * @return
     */
    RecordVO selectRecordVOByRecordId(String recordId, Long maintId);
}
