package com.vnext.entity;

import com.vnext.utils.DBConnection;
import com.vnext.model.Employee;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {
    Connection con =null;

    public EmployeeDAO(){

    }

    public ArrayList<Employee> getListEmployee(){
        ArrayList<Employee> arr = new ArrayList<Employee>();
        String sql="select * from Employee";
        Statement statement=null;
        con= DBConnection.getConnection();
        try {
            statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getString(4));
                arr.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(statement!=null){
                try {
                    statement.close();
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return arr;
    }

    public Employee getEmployeeInfor(String id){
        Employee employee = null;
        String    sql = "select * from Employee where EmployeeID = ?";

        PreparedStatement preparedStatement = null;
        con= DBConnection.getConnection();
        try {
            preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return employee;
    }

    public boolean insertEmployee(Employee employee){
        String sql="insert into Employee values (?,?,?,?)";
        PreparedStatement preparedStatement=null;
        con= DBConnection.getConnection();
        try {
            preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,employee.getEmployeeID());
            preparedStatement.setString(2,employee.getEmployeeName());
            preparedStatement.setInt(3,employee.getAge());
            preparedStatement.setString(4,employee.getDepartmentID());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean updateEmployee(Employee employee){
        String sql="update Employee set EmployeeName = ?,Age = ?, DepartmentID = ? where EmployeeID = ? ";
        PreparedStatement preparedStatement=null;
        con= DBConnection.getConnection();
        try {
            preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,employee.getEmployeeName());
            preparedStatement.setInt(2,employee.getAge());
            preparedStatement.setString(3,employee.getDepartmentID());
            preparedStatement.setString(4,employee.getEmployeeID());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return false;
    }

    public boolean deleteEmployee(String id){
        String sql = "delete from Employee where EmployeeID = ? ";
        PreparedStatement preparedStatement=null;
        con= DBConnection.getConnection();
        try {
            preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            try {
                preparedStatement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
