package com.vnext.servlet;

import com.vnext.entity.UserAccount;
import com.vnext.model.UserAccountDAO;
import com.vnext.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/registerView.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = MyUtils.getStoredConnection(req);
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        boolean gender = "Y".equals(req.getParameter("gender"));
        UserAccount userAccount = new UserAccount(userName,gender,password);
        if(UserAccountDAO.addUserAccount(connection,userAccount)){
            resp.getWriter().println("Register success");
            req.getRequestDispatcher("/WEB-INF/views/registerView.jsp").include(req,resp);

        };

    }
}
