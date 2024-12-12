package org.anik.main;

import org.anik.connection.ConnectionDB;
import org.anik.dao.EmployeeDao;
import org.anik.entity.Employee;

public class RetrieveDB {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao(ConnectionDB.getConnection());
        Employee employee = employeeDao.getEmployee(101);

        if(employee != null){
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("Employee Address: " + employee.getAddress());
            System.out.println("Employee Salary: " + employee.getSalary());
        }else{
            System.out.println("Employee Not Available.");
        }

    }
}
