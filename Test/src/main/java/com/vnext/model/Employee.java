package com.vnext.model;

public class Employee {
    private String employeeID;
    private String employeeName;
    private int age;
    private String departmentID;

    public Employee() {
    }

    public Employee(String employeeID, String employeeName, int age, String departmentID) {

        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.age = age;
        this.departmentID = departmentID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "Name: " + this.employeeName + " Age :" + this.age ;
    }
}
