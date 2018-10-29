package com.github.sky.recordService.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.sky.common.util.Query;
import com.github.sky.common.vo.RecordVO;
import com.github.sky.recordService.entity.RrRepairRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Auther: haoxin
 * @Date: 2018-10-11 15:15
 * @Description:维修记录 Mapper 接口
 */
public interface RrRepairRecordMapper extends BaseMapper<RrRepairRecord> {
    /**
     * 分页查询
     * @param query
     * @param params
     * @return
     */
    List selectRecordVoPage(Query query, @Param("maintId") Long maintId, @Param("params") Map<String, Object> params);

    /**
     * 查询RecordVO
     * @param recordId
     * @return
     */
    RecordVO selectRecordVOByRecordId(@Param("recordId") String recordId, @Param("maintId") Long maintId);
}
