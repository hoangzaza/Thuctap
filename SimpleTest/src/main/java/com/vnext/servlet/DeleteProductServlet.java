package com.vnext.servlet;

import com.vnext.model.ProductDAO;
import com.vnext.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        Connection connection = MyUtils.getStoredConnection(req);
        if(ProductDAO.deleteProduct(code,connection)){
            resp.sendRedirect(req.getContextPath()+"/productList");
        } else{
            req.setAttribute("errorString","khong xoa duoc");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/deleteProductView.jsp");
            requestDispatcher.forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
