package org.anik.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private static Connection connection;
    public static Connection getConnection(){

        try{
            if(connection == null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_advanced", "root", "root");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
