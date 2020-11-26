package com.lauracalderon;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrearPaciente {

    public void ListaPacientes()  {
        List<Paciente> Pacientes = new ArrayList<Paciente>();
        Pacientes.add(new Paciente("Laura Calderon", "123456788", "laura25@gmail.com","20","femenino" ));
        Pacientes.add(new Paciente("Valeria Diaz","7654323456", "valeria24@gmail.com","50","femenino"));
        Pacientes.add(new Paciente("Melissa Luna", "1234565432", "melissa21@gmail.com", "30", "femenino"));
        //Doctores.add(new Doctor())
        ImportarCSV();
        ExportarCSV(Pacientes);

    }

    public static void ExportarCSV(List<Paciente> Pacientes){
        String salidaArchivo = "DataBasePaciente.csv"; // Nombre del archivo
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

            leerUsuarios.close(); // Cierra el archivo

            // Recorremos la lista y la mostramos en la pantalla
            for(Paciente user : usuarios) {
                System.out.println(user.getNOMBRE() + " , "
                        + user.getTELEFONO() + " , "
                        +user.getCORREO() + " , "
                        +user.getEDAD() + " , "
                        +user.getGENERO());

            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
