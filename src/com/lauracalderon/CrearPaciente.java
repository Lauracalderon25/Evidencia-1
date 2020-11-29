package com.lauracalderon;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrearPaciente {

    public void ListaPacientes()  {
        List<Paciente> Pacientes = new ArrayList<Paciente>();

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa el nombre del paciente");
        var nombre = entrada.nextLine();

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresa el telefono");
        var telefono = leer.nextLine();

        Scanner entrada1 = new Scanner(System.in);
        System.out.println("Ingresa el correo");
        var correo = entrada1.nextLine();

        Scanner entrada2 = new Scanner(System.in);
        System.out.println("Ingresa la edad del paciente");
        var edad = entrada2.nextLine();

        Scanner entrada3 = new Scanner(System.in);
        System.out.println("Ingresa el genero del paciente");
        var genero = entrada3.nextLine();


        Pacientes.add(new Paciente(nombre, telefono, correo,edad, genero ));

        //Doctores.add(new Doctor())
        ImportarCSV();
        ExportarCSV(Pacientes);

    }

    private static final String RutaPaciente = System.getProperty("user.home");
    private static final String DocumentoPaciente = "DataBasePaciente.csv";

    public static void ExportarCSV(List<Paciente> Pacientes){
        //String salidaArchivo = "DataBasePaciente.csv"; // Nombre del archivo
        var separador = FileSystems.getDefault().getSeparator();
        var salidaArchivo = String.format("%s%s%s", RutaPaciente,separador,DocumentoPaciente);
        boolean existe = new File(salidaArchivo).exists(); // Verifica si existe

        // Si existe un archivo llamado asi lo borra
        if(existe) {
            File archivoDataBasePaciente = new File(salidaArchivo);
            archivoDataBasePaciente.delete();
        }

        try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

            // Datos para identificar las columnas
            salidaCSV.write("Nombre");
            salidaCSV.write("Telefono");
            salidaCSV.write("Correo");
            salidaCSV.write("Edad");
            salidaCSV.write("Genero");

            salidaCSV.endRecord(); // Deja de escribir en el archivo

            // Recorremos la lista y lo insertamos en el archivo
            for(Paciente user : Pacientes) {
                salidaCSV.write(user.getNOMBRE());
                salidaCSV.write(user.getTELEFONO());
                salidaCSV.write(user.getCORREO());
                salidaCSV.write(user.getEDAD());
                salidaCSV.write(user.getGENERO());

                salidaCSV.endRecord(); // Deja de escribir en el archivo
            }

            salidaCSV.close(); // Cierra el archivo

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static void ImportarCSV() {
        try{
            List<Paciente> usuarios = new ArrayList<Paciente>(); // Lista donde guardaremos los datos del archivo

            CsvReader leerUsuarios = new CsvReader("DataBasePaciente.csv");
            leerUsuarios.readHeaders();

            // Mientras haya lineas obtenemos los datos del archivo
            while(leerUsuarios.readRecord()) {
                String Nombre = leerUsuarios.get(0);
                String Telefono = leerUsuarios.get(1);
                String Correo = leerUsuarios.get(2);
                String Edad  = leerUsuarios.get(3);
                String Genero = leerUsuarios.get(4);

                usuarios.add(new Paciente(Nombre, Telefono, Correo, Edad, Genero)); // Añade la informacion a la lista
            }

            //leerUsuarios.close(); // Cierra el archivo

            // Recorremos la lista y la mostramos en la pantalla
            /*for(Paciente user : usuarios) {
                System.out.println(user.getNOMBRE() + " , "
                        + user.getTELEFONO() + " , "
                        +user.getCORREO() + " , "
                        +user.getEDAD() + " , "
                        +user.getGENERO());

            }*/

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
