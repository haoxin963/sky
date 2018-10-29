package com.github.sky.zuul.component.filter;

import com.alibaba.fastjson.JSON;
import com.github.sky.common.constant.SecurityConstants;
import com.github.sky.common.util.R;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.xiaoleilu.hutool.util.StrUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @Auther: haoxin
 * @Date: 2018-9-13 10:28
 * @Description:统一认证返回格式
 */
@Component
public class TokenFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 3;
    }

    @Override
    public boolean shouldFilter() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

        if (!StrUtil.containsAnyIgnoreCase(request.getRequestURI(),
                SecurityConstants.OAUTH_TOKEN_URL)) {
            return false;
        }

        return true;
    }

    @Override
    public Object run() {
        try {
            RequestContext context = RequestContext.getCurrentContext();
            InputStream stream = context.getResponseDataStream();
            String body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));

            if (StringUtils.isNotBlank(body)) {
                @SuppressWarnings("unchecked")
                Map<String, String> result = JSON.parseObject(body,Map.class);
                if (StringUtils.isNotBlank(result.get("access_token"))) {
                    R<Map> r = new R(result);
                    body = JSON.toJSONString(r);
                    System.out.print(body);
                }
            }
            context.setResponseBody(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
