package com.github.sky.tx.service;

/**
 * @Auther: haoxin
 * @Date: 2018-10-17 16:38
 * @Description:
 */

import com.codingapi.tx.config.service.TxManagerTxUrlService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Auther: haoxin
 * @Date: 2018-10-17 18:15
 * @Description:获取配置
 */
@Service
public class TxManagerTxUrlServiceImpl implements TxManagerTxUrlService {


    @Value("${tm.manager.url}")
    private String url;

    @Override
    public String getTxUrl() {
        System.out.println("load tm.manager.url ");
        return url;
    }
}
