package com.vnext.entity;

import com.vnext.utils.DBConnection;
import com.vnext.model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartmentDAO {
    Connection con;
    public DepartmentDAO(){

    }

    public boolean insertDepartment(Department department){
        String sql="insert into Department values (?,?)";
        PreparedStatement preparedStatement=null;
        con= DBConnection.getConnection();
        try {
            preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,department.getDepartmentID());
            preparedStatement.setString(2,department.getDepartmentName());
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
}
