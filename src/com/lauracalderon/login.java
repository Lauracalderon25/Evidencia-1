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

    public static void arcivoCsv(){
        public static void ExportarCSV(List<Doctor> Doctores){
            String salidaArchivo = "DataBaseDoctor.csv"; // Nombre del archivo
            boolean existe = new File(salidaArchivo).exists(); // Verifica si existe

            // Si existe un archivo llamado asi lo borra
            if(existe) {
                File archivoDataBaseDoctor = new File(salidaArchivo);
                archivoDataBaseDoctor.delete();
            }

            try {
                // Crea el archivo
                CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

                // Datos para identificar las columnas
                salidaCSV.write("Nombre");
                salidaCSV.write("Telefono");
                salidaCSV.write("Correo");
                salidaCSV.write("Especialidad");
                salidaCSV.write("Cedula");

                salidaCSV.endRecord(); // Deja de escribir en el archivo

                // Recorremos la lista y lo insertamos en el archivo
                for(Doctor user : Doctores) {
                    salidaCSV.write(user.getNOMBRE(

                }


}