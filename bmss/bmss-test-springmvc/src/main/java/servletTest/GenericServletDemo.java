package servletTest;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by fengxuan1 on 2017/4/26.
 */
@WebServlet(name = "GenericServletDemo", urlPatterns = {"/test"},
    initParams = {
            @WebInitParam(name = "admin", value = "Harry"),
            @WebInitParam(name = "email", value = "Harry@gmail.com")
    })
public class GenericServletDemo extends GenericServlet{
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String admin = config.getInitParameter("admin");
        String email = config.getInitParameter("email");
        res.setContentType("text/html");
        PrintWriter writer = res.getWriter();
        writer.print("<html><head></head><body>" +
                "Admin:" + admin +
                "<br/>Email:" + email +
                "</body></html>");
    }
}
