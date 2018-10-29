package com.github.sky.recordApi.feign.fallback;

import com.baomidou.mybatisplus.plugins.Page;
import com.github.sky.common.util.R;
import com.github.sky.common.util.exception.RRException;
import com.github.sky.common.vo.RecordVO;
import com.github.sky.recordApi.feign.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Auther: haoxin
 * @Date: 2018-10-10 17:17
 * @Description:异常处理
 */
@Service
public class RecordServiceFallbackImpl implements RecordService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public R<Boolean> add(@RequestBody RecordVO record, @RequestParam("maintId") Long maintId) {
        logger.error("调用添加维修记录异常:{}", "addRecord", record);
        throw new RRException("调用维修记录上传服务异常");
    }

    @Override
    public Page page(@RequestParam Map<String, Object> params, @PathVariable Long maintId) {
        logger.error("调用维修记录分页查询异常:{}", "page");
        throw new RRException("调用维修记录分页查询异常");
    }

    @Override
    public R<RecordVO> get(@PathVariable String recordId, @PathVariable Long maintId) {
        logger.error("调用维修记录详细查询异常:{}", "get");
        throw new RRException("调用维修记录详细查询异常");
    }
}
