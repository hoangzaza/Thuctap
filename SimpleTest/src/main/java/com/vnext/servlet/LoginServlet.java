package com.vnext.servlet;

import com.vnext.entity.UserAccount;
import com.vnext.model.UserAccountDAO;
import com.vnext.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/loginView.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        boolean rememberMe = "Y".equals(req.getParameter("rememberMe"));
        UserAccount user = null;
        boolean hasError = false;
        String errString = null;
        if(!"".equals(userName) && !"".equals(password)){
            Connection connection = MyUtils.getStoredConnection(req);
            user = UserAccountDAO.findUserAccount(connection,userName,password);
            if(user ==null){
                hasError = true;
                errString = "invalid account";
            }
        } else {
            hasError = true;
            errString = "dien thong tin vao";
        }
        if(hasError){
            user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            req.setAttribute("errorString",errString);
            req.setAttribute("user",user);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/loginView.jsp");
            rd.forward(req,resp);
        } else {
            HttpSession session =req.getSession();
            MyUtils.storeLoginUser(session,user);
            if(rememberMe){
                MyUtils.storeUserCookie(resp,user);
            } else {
                MyUtils.deleteUserCookie(resp);
            }
            resp.sendRedirect(req.getContextPath()+"/userInfo");

        }
    }
}
