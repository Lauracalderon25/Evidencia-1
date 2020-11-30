package com.lauracalderon;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrearCita {

    public void ListaCitas() {
        List<Cita> Citas = new ArrayList<Cita>();

        Scanner numero = new Scanner(System.in);
        System.out.println("¿Cuantas citas vas a ingresar?");
        var no = numero.nextInt();


        for (int x = 0; x < no; x++) {

            Scanner entrada = new Scanner(System.in);
            System.out.println("Ingresa el nombre del paciente");
            var nombre = entrada.nextLine();

            Scanner leer = new Scanner(System.in);
            System.out.println("Ingresa la fecha");
            var fecha = leer.nextLine();

            Scanner entrada1 = new Scanner(System.in);
            System.out.println("Ingresa la hora");
            var hora = entrada1.nextLine();

            Scanner entrada2 = new Scanner(System.in);
            System.out.println("Ingresa el motivo");
            var motivo = entrada2.nextLine();

            Scanner entrada3 = new Scanner(System.in);
            System.out.println("Ingresa el nombre del doctor");
            var nomdoctor = entrada3.nextLine();


            //Citas.add(new Cita(nombre, fecha, hora, motivo, nomdoctor));


            ImportarCSV(nombre,fecha,hora,motivo,nomdoctor);
            ExportarCSV(Citas);

        }
    }
    private static final String RutaCita = System.getProperty("user.home");
    private static final String DocumentoCita = "DataBaseCita.csv";

    public static void ExportarCSV(List<Cita> Citas){
        //String salidaArchivo = "DataBaseCitas.csv"; // Nombre del archivo

        var separador = FileSystems.getDefault().getSeparator();
        var salidaArchivo = String.format("%s%s%s", RutaCita,separador,DocumentoCita);
        Path locaciondoc = Paths.get(salidaArchivo);

        // Si existe un archivo llamado asi lo borra
        if (!java.nio.file.Files.exists(locaciondoc)) {
            File file = new File(String.valueOf(locaciondoc));
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
        }
    }
    public static void ImportarCSV(String nombre, String fecha, String hora, String motivo, String nomdoctor) {
        var separador = FileSystems.getDefault().getSeparator();
        var filepath = String.format("%s%s%s", RutaCita,separador,DocumentoCita);
        Path locaciondoc = Paths.get(filepath);
        try{
            FileWriter writePaciente = new FileWriter(filepath, true);
            writePaciente.write("Nombre del paciente: "+nombre+"  Fecha: "+fecha+"  Hora: "+hora+"  Motivo: "+motivo+"  Nombre del doctor: "+nomdoctor);
            writePaciente.write("\r\n");
            writePaciente.close();
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }
}


