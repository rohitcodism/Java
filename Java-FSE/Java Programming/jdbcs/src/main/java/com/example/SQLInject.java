package com.example;

import java.util.Scanner;

public class SQLInject {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        System.out.println("Enter the username: ");
        String name = sc.nextLine();

        System.out.println("Enter the password: ");
        String password = sc.nextLine();

        String query = "SELECT * FROM users WHERE username = '" + name + "' AND password = '" + password + "';";

        System.out.println(query);
    }
}
