package com.vnext.model;

import com.vnext.entity.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccountDAO {
    public static UserAccount findUserAccount(Connection con, String username){
        UserAccount userAccount = null;
        String sql = "select * from Account WHERE  UserName = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String userName = resultSet.getString(1);
                boolean gender = resultSet.getBoolean(2);
                String password = resultSet.getString(3);
                userAccount = new UserAccount(userName,gender,password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return userAccount;
    }

    public static UserAccount findUserAccount(Connection con, String username,String password){
        UserAccount userAccount = null;
        String sql = "select * from Account WHERE  UserName = ? AND Password = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String user = resultSet.getString(1);
                boolean gender = resultSet.getBoolean(2);
                String pass = resultSet.getString(3);
                userAccount = new UserAccount(user,gender,pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userAccount;
    }

    public static boolean addUserAccount(Connection connection, UserAccount userAccount){
        String sql = "insert into Account values (?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userAccount.getUserName());
            preparedStatement.setBoolean(2,userAccount.isGender());
            preparedStatement.setString(3,userAccount.getPassword());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
