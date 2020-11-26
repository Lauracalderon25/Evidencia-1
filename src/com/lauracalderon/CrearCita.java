package com.lauracalderon;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrearCita {

    public void ListaCitas()  {
        List<Cita> Citas = new ArrayList<Cita>();
        Citas.add(new Cita("Laura Calderon", "30 de noviembre de 2020", "15 hrs ","Gripa","Laura Calderon" ));
       // Citas.add(new Cita("Valeria Diaz","7654323456", "valeria24@gmail.com","Pediatra","65432345"));
      //  Citas.add(new Cita("Melissa Luna", "1234565432", "melissa21@gmail.com", "Medico general", "54378"));

        ImportarCSV();
        ExportarCSV(Citas);

    }

    public static void ExportarCSV(List<Cita> Citas){
        String salidaArchivo = "DataBaseCitas.csv"; // Nombre del archivo
        boolean existe = new File(salidaArchivo).exists(); // Verifica si existe

        // Si existe un archivo llamado asi lo borra
        if(existe) {
            File archivoDataBaseCitas = new File(salidaArchivo);
            archivoDataBaseCitas.delete();
        }

        try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

            // Datos para identificar las columnas
            salidaCSV.write("Nombre");
            salidaCSV.write("Fecha");
            salidaCSV.write("Hora");
            salidaCSV.write("Motivo");
            salidaCSV.write("Doctor");

            salidaCSV.endRecord(); // Deja de escribir en el archivo

            // Recorremos la lista y lo insertamos en el archivo
            for(Cita user : Citas) {
                salidaCSV.write(user.getNOMBRE());
                salidaCSV.write(user.getFECHA());
                salidaCSV.write(user.getHORA());
                salidaCSV.write(user.getMOTIVO());
                salidaCSV.write(user.getNOMDOCTOR());

                salidaCSV.endRecord(); // Deja de escribir en el archivo
            }

            salidaCSV.close(); // Cierra el archivo

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static void ImportarCSV() {
        try{
            List<Cita> usuarios = new ArrayList<Cita>(); // Lista donde guardaremos los datos del archivo

            CsvReader leerUsuarios = new CsvReader("DataBaseCitas.csv");
            leerUsuarios.readHeaders();

            // Mientras haya lineas obtenemos los datos del archivo
            while(leerUsuarios.readRecord()) {
                String Nombre = leerUsuarios.get(0);
                String Fecha = leerUsuarios.get(1);
                String Hora = leerUsuarios.get(2);
                String Motivo  = leerUsuarios.get(3);
                String NomDoctor= leerUsuarios.get(4);

                usuarios.add(new Cita(Nombre, Fecha, Hora, Motivo, NomDoctor)); // Añade la informacion a la lista
            }

            leerUsuarios.close(); // Cierra el archivo

            // Recorremos la lista y la mostramos en la pantalla
            for(Cita user : usuarios) {
                System.out.println(user.getNOMBRE() + " , "
                        + user.getFECHA() + " , "
                        +user.getHORA() + " , "
                        +user.getMOTIVO() + " , "
                        +user.getNOMDOCTOR());

            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}


