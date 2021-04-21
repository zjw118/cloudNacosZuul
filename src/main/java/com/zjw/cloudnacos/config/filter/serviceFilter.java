package com.zjw.cloudnacos.config.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * ���������Ǳ��룩
 *�����ж����������Ƿ��token�����û�У�����ʾ"there is no request token"
 * @author Zhaojingwei
 * @date 2021/3/19
 */

@Component
public class serviceFilter extends ZuulFilter {

    private static Logger log= LoggerFactory.getLogger(serviceFilter.class);

    @Override
    public String filterType() {
        return "pre"; // ����filter�����ͣ���pre��route��post��error����
    }

    @Override
    public int filterOrder() {
        return 0; // ����filter��˳������ԽС��ʾ˳��Խ�ߣ�Խ��ִ��
    }

    @Override
    public boolean shouldFilter() {
        return true; // ��ʾ�Ƿ���Ҫִ�и�filter��true��ʾִ�У�false��ʾ��ִ��
    }

    @Override
    public Object run() {
        // filter��Ҫִ�еľ������
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        System.out.println(token);
        if(token==null){
            log.warn("there is no request token");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("there is no request token");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        log.info("ok");
        return null;
    }
}
