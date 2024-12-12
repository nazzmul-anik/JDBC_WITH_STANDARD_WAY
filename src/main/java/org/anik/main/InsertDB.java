package org.anik.main;

import org.anik.connection.ConnectionDB;
import org.anik.dao.EmployeeDao;
import org.anik.entity.Employee;

import java.sql.Connection;

public class InsertDB {
    public static void main(String[] args) {

        Employee employee = new Employee(103, "Vumi", "Rampura", 18000.00);

        EmployeeDao employeeDao = new EmployeeDao(ConnectionDB.getConnection());
        boolean inserted = employeeDao.dataInsert(employee);
        if (inserted){
            System.out.println("Employee's Data Inserted Successfully!!");
        }else{
            System.out.println("Employee's Data Not Inserted Successfully!!");
        }
    }
}
