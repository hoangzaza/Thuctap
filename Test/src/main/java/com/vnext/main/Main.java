package com.vnext.main;


import com.vnext.controller.EmployeeController;
import com.vnext.model.Employee;

public class Main {
    public static void main(String[] args){
        EmployeeController employeeController=new EmployeeController();
        Employee employee=new Employee("nv1","ten nhan vien 1",30,"phong1");
        System.out.println(employeeController.getEmployeeInfo("nv1").toString());
        employeeController.updateEmployee(employee);
        System.out.println(employeeController.getEmployeeInfo("nv1").toString());




    }
}
