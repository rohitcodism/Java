package com.example;

// JDBC -> Java Database Connectivity

import java.sql.*;
import java.util.Scanner;

public class jdbcDemo {
    public static void main(String[] args) {

        // Not needed for newer JDBCs
        /*try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }*/

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the user Id you want to find: ");
        int userId = sc.nextInt();

        String query = "SELECT name FROM users WHERE id="+userId;

        String url  = "jdbc:postgresql://localhost:5432/jdbc-demo";
        String username = "postgres";
        String password = "tiger";

        Connection connection = null;
        Statement st = null;
        ResultSet res = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            st = connection.createStatement();
            res = st.executeQuery(query);

            while (res.next()) {
                String name = res.getString("name");
                System.out.println("Name: " + name);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
                try {
                    if(res != null) res.close();
                    if(st != null) st.close();
                    if(connection != null) connection.close();
                    sc.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
        }
    }
}
