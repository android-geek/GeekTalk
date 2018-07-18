package cn.androidgeek.geektalk.filter;

import cn.androidgeek.geektalk.factory.DruidFactory;
import me.xuxiaoxiao.xtools.common.ioc.XIocTools;
import me.xuxiaoxiao.xtools.server.xcontroller.xaction.XAction;
import me.xuxiaoxiao.xtools.server.xcontroller.xaction.XActionFactory;
import me.xuxiaoxiao.xtools.server.xmodel.XModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "*.jsp")
public class JspFilter implements Filter {

    static {
        XIocTools.register(XAction.class, new XActionFactory());
        XIocTools.register(XModel.class, new DruidFactory());
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {
        if (((HttpServletRequest) request).getRequestURI().equals("/")) {
            ((HttpServletResponse) response).sendRedirect("/user/login.page");
        } else {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    public void destroy() {
    }
}
