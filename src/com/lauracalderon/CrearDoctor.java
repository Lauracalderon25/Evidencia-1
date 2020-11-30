package com.lauracalderon;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.csvreader.CsvReader;


public class CrearDoctor {

   public void ListaDoctores() {
       List<Doctor> Doctores = new ArrayList<Doctor>();

       Scanner numero = new Scanner(System.in);
       System.out.println("¿Cuantos doctores vas a ingresar?");
       var no = numero.nextInt();


       for (int x = 0; x < no; x++) {


           Scanner entrada = new Scanner(System.in);
           System.out.println("Ingresa el nombre del doctor");
           var nombre = entrada.next();

           Scanner leer = new Scanner(System.in);
           System.out.println("Ingresa el telefono");
           var telefono = leer.next();

           Scanner entrada1 = new Scanner(System.in);
           System.out.println("Ingresa el correo");
           var correo = entrada1.next();

           Scanner entrada2 = new Scanner(System.in);
           System.out.println("Ingresa la especialidad");
           var especialidad = entrada2.next();

           Scanner entrada3 = new Scanner(System.in);
           System.out.println("Ingresa la cedula");
           var cedula = entrada3.next();


           Doctores.add(new Doctor(nombre, telefono, correo, especialidad, cedula));


           //Doctores.add(new Doctor())
           ImportarCSV();
           ExportarCSV(Doctores);

       }
   }
    private static final String RutaDoctor = System.getProperty("user.home");
   private static final String DocumentoDoctor = "DataBaseDoctor.csv";

    public static void ExportarCSV(List<Doctor> Doctores){
        //String salidaArchivo = "DataBaseDoctor.csv"; // Nombre del archivo
        var separador = FileSystems.getDefault().getSeparator();
        var salidaArchivo = String.format("%s%s%s", RutaDoctor,separador,DocumentoDoctor);
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
                salidaCSV.write(user.getNOMBRE());
                salidaCSV.write(user.getTELEFONO());
                salidaCSV.write(user.getCORREO());
                salidaCSV.write(user.getESPECIALIDAD());
                salidaCSV.write(user.getCEDULA());

                salidaCSV.endRecord(); // Deja de escribir en el archivo
            }

            salidaCSV.close(); // Cierra el archivo

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static void ImportarCSV() {
        try{
            List<Doctor> usuarios = new ArrayList<Doctor>(); // Lista donde guardaremos los datos del archivo

            CsvReader leerUsuarios = new CsvReader("DataBaseDoctor.csv");
            leerUsuarios.readHeaders();



            // Mientras haya lineas obtenemos los datos del archivo
            while(leerUsuarios.readRecord()) {
                String Nombre = leerUsuarios.get(0);
                String Telefono = leerUsuarios.get(1);
                String Correo = leerUsuarios.get(2);
                String Especialidad  = leerUsuarios.get(3);
                String Cedula = leerUsuarios.get(4);


                usuarios.add(new Doctor(Nombre, Telefono, Correo, Especialidad, Cedula)); // Añade la informacion a la lista


            }

            //leerUsuarios.close(); // Cierra el archivo



            // Recorremos la lista y la mostramos en la pantalla
            /*for(Doctor user : usuarios) {
                System.out.println(user.getNOMBRE() + " , "
                        + user.getTELEFONO() + " , "
                        +user.getCORREO() + " , "
                        +user.getESPECIALIDAD() + " , "
                        +user.getCEDULA());

            }*/

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}



