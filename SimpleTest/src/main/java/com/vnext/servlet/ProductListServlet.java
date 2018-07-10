package com.vnext.servlet;

import com.vnext.entity.Product;
import com.vnext.model.ProductDAO;
import com.vnext.model.UserAccountDAO;
import com.vnext.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = MyUtils.getStoredConnection(req);
        ArrayList<Product> arr = null;
        String errString = null;
        if(MyUtils.checkLogin(req,resp,connection)) {
            String contentSearch = req.getParameter("contentSearch");
            if(contentSearch == null || contentSearch.length() ==0){
                arr = ProductDAO.getProductList(connection);
                req.setAttribute("errorString", errString);
                req.setAttribute("listProduct", arr);
            } else {
                arr = ProductDAO.searchProductList(connection,contentSearch);
                req.setAttribute("errorString",errString);
                req.setAttribute("listProduct",arr);
            }
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/productListView.jsp");
            rd.forward(req, resp);
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/loginView.jsp");
            rd.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
