package com.vnext.filter;

import com.vnext.entity.UserAccount;
import com.vnext.model.UserAccountDAO;
import com.vnext.utils.MyUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

public class CookieFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        UserAccount userAccount = MyUtils.getLoginedUser(session);
//        check trong session truoc
        if(userAccount != null){
            session.setAttribute("session_check","check");
            chain.doFilter(request,response);
            return;
        }
        Connection connection = MyUtils.getStoredConnection(req);
//        neu session chua co thi kiem tra cookie
        String check = (String) session.getAttribute("session_check");
        if(check == null && connection != null){
//            lay user tu cookie
            String user = MyUtils.getUserLoginFromCookie(req);
            UserAccount acc = UserAccountDAO.findUserAccount(connection,user);
            MyUtils.storeLoginUser(session,acc);
//            gan lai co
            session.setAttribute("session_check","check");
        }
        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
