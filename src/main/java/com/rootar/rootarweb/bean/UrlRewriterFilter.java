package com.rootar.rootarweb.bean;

import com.rootar.rootarweb.bean.ApplicationBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UrlRewriterFilter  implements Filter {
   @Inject
   ApplicationBean applicationBean;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest  srequest = (HttpServletRequest) request;
        HttpServletResponse sresponse = (HttpServletResponse) response;

        String url = srequest.getRequestURI().trim();
        System.out.println(url);
        url = url.substring(url.indexOf("/faces/")+7);
        StringBuilder forward=new StringBuilder();
        forward.append("/faces/");
        if (url.matches(".continents\\/[0-9]{1,}$")) {
            int pos = url.lastIndexOf("/");
            forward.append("pays.jsf?continent=");
            forward.append(url.substring(pos + 1));

        } else if (!url.matches(".\\.jsf$")) {
            forward.append(url);
            forward.append(".jsf");
        }
        else
            forward.append(url);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward.toString());
        requestDispatcher.forward(srequest, sresponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }



}
