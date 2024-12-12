package org.anik.main;

import org.anik.connection.ConnectionDB;
import org.anik.dao.EmployeeDao;
import org.anik.entity.Employee;

public class UpdateDB {
    public static void main(String[] args) {
        Employee employee = new Employee(101, "Anik", "Dhanmondi", 25000.00);
        EmployeeDao employeeDao = new EmployeeDao(ConnectionDB.getConnection());
        boolean update = employeeDao.updateData(employee);
        if(update){
            System.out.println("Employee updated successfully!!");
        }else{
            System.out.println("Something Wrong On Server. Employee not updated successfully!!");
        }
    }
}
