package com.github.sky.recordApi.feign;

import com.baomidou.mybatisplus.plugins.Page;
import com.github.sky.common.util.R;
import com.github.sky.common.vo.RecordVO;
import com.github.sky.recordApi.feign.fallback.RecordServiceFallbackImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: haoxin
 * @Date: 2018-10-10 17:16
 * @Description:维修记录服务
 */
@FeignClient(name = "sky-record-service", fallback = RecordServiceFallbackImpl.class)
public interface RecordService {

    @PostMapping("/recordService/add")
    R<Boolean> add(@RequestBody RecordVO record, @RequestParam("maintId") Long maintId);

    @GetMapping("/recordService/{maintId}/page")
    Page page(@RequestParam Map<String, Object> params, @PathVariable("maintId") Long maintId);

    @GetMapping("/recordService/{maintId}/{recordId}")
    R<RecordVO> get(@PathVariable("recordId") String recordId, @PathVariable("maintId") Long maintId);
}
