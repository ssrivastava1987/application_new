package com.dyt.doyourthing.controller;

/**
 * Author: shubhamsrivastava
 **/
public class Admin {

    static void displayBySetter(Employee e)
    {
        System.out.println("********************************");
        System.out.println("Employee Id : "+e.getEmpId()+"\nEmployee Full Name: "+ e.getEmpName() + "\nEmployee Annual Package: " + e.getEmpSalary());
        System.out.println("********************************");
    }

    public static void main(String[] args) {
        System.out.println("********************************");
        System.out.println("Details of Employees");
        System.out.println("********************************");
        //Constructor way to set the values
        Employee e1 = new Employee("Sushil Kumar",45000.58);
        Employee e2 = new Employee("Tara Sharma",45000.58);

        //Setter way to set the values
        Employee e3 = new Employee();
        e3.setEmpName("Prakhar Budholia");
        e3.setEmpSalary(60000.00);
        Employee e4 = new Employee();
        e4.setEmpName("Supreet Bathal");
        e4.setEmpSalary(75000.00);

        System.out.println("********************************");
        System.out.println("By getter");
        System.out.println("********************************");
//        Admin a = new Admin();
//        a.displayBySetter();
//        a.displayBySetter();
//        a.displayBySetter();
//        a.displayBySetter();

        displayBySetter(e1);
        displayBySetter(e2);
        displayBySetter(e3);
        displayBySetter(e4);
    }
}
