package org.anik.main;

import org.anik.connection.ConnectionDB;
import org.anik.dao.EmployeeDao;
import org.anik.entity.Employee;

import java.util.List;

public class RetrieveAllDB {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao(ConnectionDB.getConnection());
        List<Employee> employeeList = employeeDao.getAllEmployee();

        if (employeeList != null) {
            System.out.println("ID\tName\tAddress\tSalary");
            System.out.println("-----------------------------");
            for(Employee employee : employeeList){
                System.out.println(employee.getId()+"\t"+employee.getName()+"\t"+employee.getAddress()+"\t"+employee.getSalary());
            }
        }else{
            System.out.println("No Employee Are Available.");
        }

    }
}
