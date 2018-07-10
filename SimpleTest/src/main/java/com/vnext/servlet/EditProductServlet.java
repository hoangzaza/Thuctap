package com.vnext.servlet;

import com.vnext.entity.Product;
import com.vnext.model.ProductDAO;
import com.vnext.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class EditProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = MyUtils.getStoredConnection(req);
        String code = req.getParameter("code");
        Product product = null;
        String error = null;
        product = ProductDAO.findProduct(code,connection);
        if(error != null || product ==null){
            resp.sendRedirect(req.getContextPath()+"/productList");
            return;
        }
        req.setAttribute("errorString", error);
        req.setAttribute("product",product);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = MyUtils.getStoredConnection(req);
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String pr = req.getParameter("price");
        float price = 0;
        price = Float.parseFloat(pr);
        Product product = new Product(code,name,price);
        String error = null;
        boolean ck = ProductDAO.updateProduct(product,connection);
        if(!ck){
            error = "khong sua duoc";
        }
        req.setAttribute("errorString",error);
        req.setAttribute("product",product);
        if(error != null){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
            requestDispatcher.forward(req,resp);
        } else {
            resp.sendRedirect(req.getContextPath()+"/productList");
        }

    }
}
