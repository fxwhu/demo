package com.bmss.test.filter;


import com.bmss.test.util.ConfigUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by fengxuan1 on 2017/3/29.
 */
public class SSOFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(SSOFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest res = (HttpServletRequest)request;
        Object attribute = res.getSession().getAttribute(ConfigUtil.SESSIONINFO);
        if(attribute != null){

        }

    }

    @Override
    public void destroy() {

    }
}
