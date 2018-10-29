package com.github.sky.recordService.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.github.sky.common.util.Query;
import com.github.sky.common.util.R;
import com.github.sky.common.vo.RecordVO;
import com.github.sky.recordService.service.IRrRepairRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: haoxin
 * @Date: 2018-10-11 15:15
 * @Description:维修记录控制类
 */
@RestController
@RequestMapping("/recordService")
public class RepairRecordController {

    @Autowired
    private IRrRepairRecordService rrRepairRecordService;

    /**
     * 添加维修记录
     * @param record 维修记录Vo
     * @param maintId 维修企业ID
     * @return
     */
    @PostMapping("/add")
    public R<Boolean> add(@RequestBody RecordVO record, Long maintId){
        return new R<>(rrRepairRecordService.add(record,maintId));
    }

    /**
     * 维修记录分页查询
     * @param params
     * @param maintId
     * @return
     */
    @GetMapping("/{maintId}/page")
    public Page page(@RequestParam Map<String, Object> params, @PathVariable Long maintId) {
        return rrRepairRecordService.selectRecordVoPage(new Query(params),maintId,params);
    }

    /**
     * 详情
     * @param recordId
     * @param maintId
     * @return
     */
    @GetMapping("/{maintId}/{recordId}")
    public R<RecordVO> get(@PathVariable String recordId, @PathVariable Long maintId){
        return new R<>(rrRepairRecordService.selectRecordVOByRecordId(recordId,maintId));
    }
}
