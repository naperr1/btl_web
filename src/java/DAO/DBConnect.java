/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fattt
 */
public class DBConnect {
    protected static Connection connection;
    protected static String databaseName;
    public DBConnect() {
        try {
            String user = "root";
            String pass = "1Hitgapcu@";
            databaseName = "btl_testdb";
            String url = "jdbc:mysql://localhost:3306/" + databaseName;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    
    public static void main(String[] args) {
        DBConnect dbConnect = new DBConnect();
        Connection connection = dbConnect.getConnection();

        if (connection != null) {
            System.out.println("Ket noi Thanh Cong");
        } else {
            System.out.println("Ket noi that bai");
        }
    }
}
