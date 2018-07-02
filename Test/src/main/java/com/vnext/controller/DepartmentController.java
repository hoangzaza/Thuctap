package com.vnext.controller;

import com.vnext.model.Department;
import com.vnext.entity.DepartmentDAO;

public class DepartmentController {
    DepartmentDAO departmentDAO=null;
    public DepartmentController(){
        departmentDAO=new DepartmentDAO();
    }

    public boolean addDepartment(Department department){
        return departmentDAO.insertDepartment(department);
    }
}
