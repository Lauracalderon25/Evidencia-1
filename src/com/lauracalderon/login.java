package com.lauracalderon;

import java.io.File;
import java.sql.SQLOutput;
import java.util.Scanner;

public class login {

    private static Scanner x;


    public static void principal() {
        String username = "Valeria";
        String password = "123";
        String filepath = "members.txt";

        verificar(username, password, filepath);
    }

    public static void verificar(String username, String password, String filepath) {
        boolean found = false;
        String tempUser = "";
        String tempPassword = "";

        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {

                tempUser = x.next();
                tempPassword = x.next();

                if (tempUser.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {
                    found = true;
                }
            }
            x.close();
            System.out.println(found);

        } catch (Exception e) {

            System.out.println("error");
        }
    }



}