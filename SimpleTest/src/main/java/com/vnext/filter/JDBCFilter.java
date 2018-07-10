package com.vnext.filter;

import com.vnext.utils.DBConnection;
import com.vnext.utils.MyUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

public class JDBCFilter implements Filter {
    FilterConfig filterConfig;
    public void init(FilterConfig arg0) throws ServletException {
        filterConfig=arg0;

    }

    // Kiểm tra mục tiêu của request hiện tại là 1 Servlet?
    private boolean needJDBC(HttpServletRequest request) {
        //
        // Servlet Url-pattern: /spath/*
        //
        // => /spath
        String servletPath = request.getServletPath();
        // => /abc/mnp
        String pathInfo = request.getPathInfo();

        String urlPattern = servletPath;

        if (pathInfo != null) {
            // => /spath/*
            urlPattern = servletPath + "/*";
        }

        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext()
                .getServletRegistrations();

        // Tập hợp tất cả các Servlet trong WebApp của bạn.
        Collection<? extends ServletRegistration> values = servletRegistrations.values();
        for (ServletRegistration sr : values) {
            Collection<String> mappings = sr.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        if(this.needJDBC(request)) {
            Connection conn = null;
            String dburl = filterConfig.getInitParameter("dburl");
            String dbUser = filterConfig.getInitParameter("dbUser");
            String dbPassword = filterConfig.getInitParameter("dbPassword");
            conn = DBConnection.getConnection(dburl, dbUser, dbPassword);

            try {
                conn.setAutoCommit(false);
                MyUtils.storeConnection(request, conn);
//				qua filter lan 1
                arg2.doFilter(arg0, arg1);
//				qua filter lan 2
                conn.commit();

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {

                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }



        } else {
            arg2.doFilter(arg0, arg1);
        }

    }

    public void destroy() {

    }
}
