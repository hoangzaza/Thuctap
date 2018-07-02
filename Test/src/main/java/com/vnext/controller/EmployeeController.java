package com.vnext.controller;

import com.vnext.model.Employee;
import com.vnext.entity.EmployeeDAO;

import java.util.ArrayList;

public class EmployeeController {

    EmployeeDAO employeeDAO;
    public EmployeeController(){
        employeeDAO=new EmployeeDAO();
    }

    public Employee getEmployeeInfo(String id){
        return employeeDAO.getEmployeeInfor(id);
    }
    public ArrayList<Employee> getListEmployee(){
        return employeeDAO.getListEmployee();
    }

    public boolean insertEmployee(Employee employee){
        return employeeDAO.insertEmployee(employee);
    }

    public boolean updateEmployee(Employee employee){
        return employeeDAO.updateEmployee(employee);
    }

    public boolean deleteEmployee(String id){
        return employeeDAO.deleteEmployee(id);
    }
}
