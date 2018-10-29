package com.github.sky.recordApi.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.github.sky.common.util.R;
import com.github.sky.common.util.exception.RRException;
import com.github.sky.common.vo.RecordVO;
import com.github.sky.common.vo.UserVO;
import com.github.sky.common.web.BaseController;
import com.github.sky.recordApi.feign.RecordService;
import com.github.sky.recordApi.feign.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @Auther: haoxin
 * @Date: 2018-9-13 16:47
 * @Description:数据采集API
 */
@RestController
@RequestMapping("/record")
public class RecordController extends BaseController {

    @Autowired
    private RecordService recordService;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册", notes = "用户注册")
    @PostMapping("/registerUser")
    public R<Boolean> add(@RequestBody @Valid @ApiParam(name="userVO",value="用户信息") UserVO userVO) {
        logger.info(userVO.toString());
        R<Boolean> r = userService.register(userVO);
        return r;
    }

    @ApiOperation(value = "上传维修记录", notes = "上传维修记录")
    @PostMapping("/addRecord")
    public R<Boolean> addRecord(@RequestBody @Valid @ApiParam(name="recordVO",value="维修记录") RecordVO recordVO) {
        Long userId = getUserId();
        logger.info("userId=>"+userId);
        if(userId != null) {
            return recordService.add(recordVO,userId);
        } else {
            throw new RRException("userId is null");
        }
    }

    /**
     * 维修记录分页查询
     * @param params
     * @param maintId
     * @return
     */
    @GetMapping("/{maintId}/page")
    public Page page(@RequestParam Map<String, Object> params, @PathVariable Long maintId) {
        return recordService.page(params,maintId);
    }

    /**
     * 详情
     * @param recordId
     * @param maintId
     * @return
     */
    @GetMapping("/{maintId}/{recordId}")
    public R<RecordVO> get(@PathVariable String recordId, @PathVariable Long maintId){
        return recordService.get(recordId,maintId);
    }

}
