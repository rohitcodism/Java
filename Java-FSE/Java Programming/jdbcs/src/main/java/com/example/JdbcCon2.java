package com.example;

import java.sql.*;
import java.util.Scanner;

public class JdbcCon2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("""
                Enter your choice:
                1. Insert new row
                2. Update an existing row
                3. Delete a row
                4. Show \
                table""");

        int choice = sc.nextInt();
        sc.nextLine(); // -> to consume the new line

        String query = null;
        int userId = 0;


        //String query =
                //"INSERT INTO users (name,email,age) VALUES ('" + name  + "', '" + email  + "', " + age + ")";

        //String sqlQuery = "INSERT INTO users (name, email, age, city) VALUES ( ?, ?, ?, ? )";

        String url  = "jdbc:postgresql://localhost:5432/jdbc-demo";
        String username = "postgres";
        String password = "tiger";

        Connection connection = null;
        //Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            //st = connection.createStatement();

            switch (choice){
                case 1:
                    query = "INSERT INTO users (name, email, city, age) VALUES (?, ?, ?, ?)";
                    System.out.print("Enter the username: ");
                    String name = sc.nextLine();

                    System.out.print("Enter the email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter the city: ");
                    String city = sc.nextLine();

                    System.out.print("Enter the age: ");
                    int age = sc.nextInt();

                    ps = connection.prepareStatement(query);

                    ps.setString(1, name);
                    ps.setString(2, email);
                    ps.setString(3, city);
                    ps.setInt(4, age);

                    int rows = ps.executeUpdate();
                    System.out.println("Successfully Inserted: " + rows + " rows");
                    break;
                case 2:
                    System.out.println("""
                        What do you wanna update ?
                        1. Name
                        2. Age
                        3. City
                        4. Email
                        """);
                    int updateOption = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the User ID you wanna UPDATE ?");
                    userId = sc.nextInt();
                    sc.nextLine();
                    switch (updateOption){
                        case 1:
                            query = "UPDATE users SET name = ? WHERE id = ?";
                            System.out.print("Enter the username: ");
                            String nameUpdate = sc.nextLine();
                            ps = connection.prepareStatement(query);
                            ps.setString(1, nameUpdate);
                            ps.setInt(2, userId);
                            int rows0 = ps.executeUpdate();
                            System.out.println("Successfully Updated: " + rows0 + " rows");
                            break;
                        case 2:
                            query = "UPDATE users SET age = ? WHERE id = ?";
                            System.out.print("Enter the age: ");
                            int ageUpdate = sc.nextInt();
                            ps = connection.prepareStatement(query);
                            ps.setInt(1, ageUpdate);
                            ps.setInt(2, userId);
                            int rows1 = ps.executeUpdate();
                            System.out.println("Successfully Updated: " + rows1 + " rows");
                            break;
                        case 3:
                            query = "UPDATE users SET city = ? WHERE id = ?";
                            System.out.print("Enter the city: ");
                            String cityUpdate = sc.nextLine();
                            ps = connection.prepareStatement(query);
                            ps.setString(1, cityUpdate);
                            ps.setInt(2, userId);
                            int rows2 = ps.executeUpdate();
                            System.out.println("Successfully Updated: " + rows2 + " rows");
                            break;
                        case 4:
                            query = "UPDATE users SET email = ? WHERE id = ?";
                            System.out.print("Enter the email: ");
                            String mailUpdate = sc.nextLine();
                            ps = connection.prepareStatement(query);
                            ps.setString(1, mailUpdate);
                            ps.setInt(2, userId);
                            int rows3 = ps.executeUpdate();
                            System.out.println("Successfully Updated: " + rows3 + " rows");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Enter the User ID you wanna DELETE ?");
                    userId = sc.nextInt();
                    sc.nextLine();
                    query = "DELETE FROM users WHERE id = ?";
                    ps = connection.prepareStatement(query);
                    ps.setInt(1, userId);
                    int rows4 = ps.executeUpdate();
                    System.out.println("Successfully Deleted: " + rows4 + " rows");
                    break;
                case 4:
                    query = "SELECT * FROM users";
                    ps = connection.prepareStatement(query);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        // Assuming your table has columns: name, email, city, age
                        String name1 = rs.getString("name");
                        String email1 = rs.getString("email");
                        String city1 = rs.getString("city");
                        int age1 = rs.getInt("age");

                        System.out.println("Name: " + name1);
                        System.out.println("Email: " + email1);
                        System.out.println("City: " + city1);
                        System.out.println("Age: " + age1);
                        System.out.println("-----------------------");
                    }
                    break;
                default:
                    System.out.println("Invalid option!!!");
                    break;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                if(connection != null){
                    connection.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(rs != null){
                    rs.close();
                }
                sc.close();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
