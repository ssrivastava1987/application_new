package com.dyt.doyourthing.controller;

import java.util.Random;
import java.util.UUID;

/**
 * Author: shubhamsrivastava
 **/
class Employee {

    private final String empId;
    private String empName;
    private double empSalary;

    public Employee(String empName,double empSalary) {
        this.empId = UUID.randomUUID().toString();
        this.empName = empName;
        this.empSalary = empSalary;
    }

    public Employee(){
        this.empId = UUID.randomUUID().toString();
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

//    void display()
//    {
//
//        System.out.println("Employee Id : "+empId+"\nEmployee Full Name: "+ empName + "\nEmployee Annual Package: " + empSalary);
//        System.out.println("********************************");
//    }
//
//    void displayBySetter()
//    {
//        System.out.println("********************************");
//        System.out.println("Employee Id : "+getEmpId()+"\nEmployee Full Name: "+ getEmpName() + "\nEmployee Annual Package: " + getEmpSalary());
//        System.out.println("********************************");
//    }

//    public static void main(String[] args) {
//        System.out.println("********************************");
//        System.out.println("Details of Employees");
//        System.out.println("********************************");
//        //Constructor way to set the values
//        Employee e1 = new Employee("Sushil Kumar",45000.58);
//        Employee e2 = new Employee("Tara Sharma",45000.58);
//
//        //Setter way to set the values
//        Employee e3 = new Employee();
//        e3.setEmpName("Prakhar Budholia");
//        e3.setEmpSalary(60000.00);
//        Employee e4 = new Employee();
//        e4.setEmpName("Supreet Bathal");
//        e4.setEmpSalary(75000.00);
//
//        System.out.println("********************************");
//        System.out.println("By variable");
//        System.out.println("********************************");
//        e1.display();
//        e2.display();
//        e3.display();
//        e4.display();
//        System.out.println("********************************");
//        System.out.println("By getter");
//        System.out.println("********************************");
//        e1.displayBySetter();
//        e2.displayBySetter();
//        e3.displayBySetter();
//        e4.displayBySetter();
//    }

}