package com.vnext.servlet;

import com.vnext.entity.Product;
import com.vnext.model.ProductDAO;
import com.vnext.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class AjaxApiServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = MyUtils.getStoredConnection(req);
        String error = null;
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String pri = req.getParameter("price");
        float price = 0;
        price = Float.parseFloat(pri);
        Product product = new Product(code,name,price);
        if( ProductDAO.insertProduct(product,connection)){
        resp.getWriter().write("Them thanh cong");
        }else {
            resp.getWriter().write("them that bai");

        }
    }
}
