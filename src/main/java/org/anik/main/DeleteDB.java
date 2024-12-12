package org.anik.main;

import org.anik.connection.ConnectionDB;
import org.anik.dao.EmployeeDao;

public class DeleteDB {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao(ConnectionDB.getConnection());
        boolean deleted = employeeDao.deleteData(101);
        if(deleted){
            System.out.println("Employee Data Has Been Deleted Successfully.!!");
        }else{
            System.out.println("Employee Data Does Not Exist.!!");
        }
    }
}
