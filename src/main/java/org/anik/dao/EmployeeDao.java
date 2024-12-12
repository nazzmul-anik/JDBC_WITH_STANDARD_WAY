package org.anik.dao;

import org.anik.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private Connection connection;
    public EmployeeDao(Connection connection){
        this.connection = connection;
    }
    public boolean dataInsert(Employee employee){
        boolean isDataInserted = false;
        try{
            String insertQuery = "insert into employee values(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setDouble(4, employee.getSalary());

            int update = preparedStatement.executeUpdate();
            if(update == 1){
                isDataInserted = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return isDataInserted;
    }

    public boolean updateData(Employee employee){
        boolean isUpdateData = false;

        try{
            String updateQuery = "update employee set address=?, salary=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            preparedStatement.setString(1, employee.getAddress());
            preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.setInt(3, employee.getId());

            int update = preparedStatement.executeUpdate();
            if(update == 1){
                isUpdateData = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return isUpdateData;
    }

    public boolean deleteData(int employeeID){

        boolean isDeleteData = false;
        try{
            String deleteQuery = "delete from employee where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, employeeID);
            int update = preparedStatement.executeUpdate();
            if(update == 1){
                isDeleteData = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return isDeleteData;
    }

    public Employee getEmployee(int employeeID){
        Employee employee = null;

        try{
            String getQuery = "select *from employee where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(getQuery);
            preparedStatement.setInt(1, employeeID);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setAddress(resultSet.getString(3));
                employee.setSalary(resultSet.getDouble(4));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return employee;
    }

    public List<Employee> getAllEmployee(){
        List<Employee> employeeList = new ArrayList<Employee>();
        Employee employee = null;

        try{
            String getAllEmployeeQuery = "select *from employee";
            PreparedStatement preparedStatement = connection.prepareStatement(getAllEmployeeQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                employee = new Employee();
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setAddress(resultSet.getString(3));
                employee.setSalary(resultSet.getDouble(4));

                employeeList.add(employee);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return employeeList;
    }
}
