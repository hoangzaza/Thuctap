package com.vnext.model;

import com.vnext.entity.Product;
import com.vnext.entity.UserAccount;
import com.vnext.utils.MyUtils;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {
    public static ArrayList<Product> getProductList(Connection connection){
        ArrayList<Product> arrayList = new ArrayList<Product>();
        String sql = "select * from Product";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String code = resultSet.getString(1);
                String name = resultSet.getString(2);
                float price = resultSet.getFloat(3);
                Product product = new Product(code,name,price);
                arrayList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return arrayList;
    }

    public static ArrayList<Product> searchProductList(Connection connection, String contentSearch){
        ArrayList<Product> arr = new ArrayList<Product>();
        String sql = "select * from Product where ProductID like ? or ProductName like ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"%"+contentSearch+"%");
            preparedStatement.setString(2,"%"+contentSearch+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String code = resultSet.getString(1);
                String name = resultSet.getString(2);
                float price = resultSet.getFloat(3);
                Product p = new Product(code,name,price);
                arr.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arr;
    }



    public static boolean insertProduct(Product product, Connection connection){
        String sql = "insert into Product values (?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getCode());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setFloat(3,product.getPrice());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Product findProduct(String code,Connection connection){
        Product product = null;
        String sql = "select * from Product where ProductID = ?";
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,code);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString(2);
                float price = resultSet.getFloat(3);
                product = new Product(code,name,price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    public static boolean updateProduct (Product product,Connection connection){
        String sql = "update Product set ProductName = ?, Price = ? where ProductID = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setFloat(2,product.getPrice());
            preparedStatement.setString(3,product.getCode());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean deleteProduct(String code, Connection connection){
        String sql = "delete from Product where ProductID = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,code);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
