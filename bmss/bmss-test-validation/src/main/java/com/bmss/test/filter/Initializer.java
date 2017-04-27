package com.bmss.test.filter;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by fengxuan1 on 2017/3/30.
 */
public class Initializer extends AbstractHttpSessionApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.setInitParameter("contextConfigLocation", "classpath:spring/*.xml");

        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet());
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        registration.setInitParameter("contextConfigLocation", "classpath:spring/*.xml");

        servletContext.addListener(new ContextLoaderListener());
    }

    @Override
    protected void afterSessionRepositoryFilter(ServletContext servletContext) {
        appendFilters(servletContext, new UserAccountsFilter());
    }

}
