package com.bmss.webInitializer;

import org.springframework.data.rest.webmvc.RepositoryRestDispatcherServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by fengxuan1 on 2017/4/27.
 */
public class RestWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        /*AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        XmlWebApplicationContext xmlContext = new XmlWebApplicationContext();
        xmlContext.setNamespace("spring-jdbc");
        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(xmlContext);
        //manage the life cycle of the root application context
        servletContext.addListener(contextLoaderListener);*/

        servletContext.setInitParameter("contextConfigLocation", "classpath:spring-jdbc.xml");

        DispatcherServlet dispatcherServlet = new RepositoryRestDispatcherServlet();

        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        registration.setInitParameter("contextConfigLocation", "classpath:spring-jdbc.xml");
    }
}
