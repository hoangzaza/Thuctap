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

public class CreateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = MyUtils.getStoredConnection(req);
        String error = null;
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String pri = req.getParameter("price");
        float price = 0;
        price = Float.parseFloat(pri);
        Product product = new Product(code,name,price);
        String re = "\\w+";
        if(code == null || !code.matches(re)){
            error = "invalid product code";
        }

        if(error ==null){
            ProductDAO.insertProduct(product,connection);
        }
        req.setAttribute("errorString",error);
        req.setAttribute("product",product);
        if(error != null){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
            requestDispatcher.forward(req,resp);
        } else {
            resp.sendRedirect(req.getContextPath()+"/productList");
        }


    }
}
