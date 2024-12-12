package org.anik.main;

import org.anik.connection.ConnectionDB;
import org.anik.dao.EmployeeDao;
import org.anik.entity.Employee;

import java.util.Scanner;

public class InsertDB_Dynamically {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int employeeID = scanner.nextInt();
        System.out.print("Enter Employee Name: ");
        String employeeName = scanner.next();
        System.out.print("Enter Employee Address: ");
        String employeeAddress = scanner.next();
        System.out.print("Enter Employee Salary: ");
        double employeeSalary = scanner.nextDouble();

        Employee employee = new Employee(employeeID, employeeName, employeeAddress, employeeSalary);
        EmployeeDao employeeDao = new EmployeeDao(ConnectionDB.getConnection());

        boolean inserted = employeeDao.dataInsert(employee);
        if(inserted){
            System.out.println("Employee's Data Inserted Successfully!!");
        }else{
            System.out.println("Employee's Data Not Inserted Successfully!!");
        }
    }
}
