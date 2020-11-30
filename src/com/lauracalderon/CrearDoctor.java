package com.lauracalderon;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
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


           //Doctores.add(new Doctor(nombre, telefono, correo, especialidad, cedula));


           //Doctores.add(new Doctor())
           ImportarCSV(nombre,telefono,correo,especialidad,cedula);
           ExportarCSV(Doctores);

       }
   }
    private static final String RutaDoctor = System.getProperty("user.home");
   private static final String DocumentoDoctor = "DataBaseDoctor.csv";

    public static void ExportarCSV(List<Doctor> Doctores) {
        //String salidaArchivo = "DataBaseDoctor.csv"; // Nombre del archivo
        var separador = FileSystems.getDefault().getSeparator();
        var salidaArchivo = String.format("%s%s%s", RutaDoctor, separador, DocumentoDoctor);
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

        public static void ImportarCSV(String nombre, String telefono, String correo, String especialidad, String cedula) {
            var separador = FileSystems.getDefault().getSeparator();
            var filepath = String.format("%s%s%s", RutaDoctor, separador, DocumentoDoctor);
            Path locaciondoc = Paths.get(filepath);
            try{
                FileWriter writePaciente = new FileWriter(filepath, true);
                writePaciente.write("Nombre del doctor: "+nombre+"  Telefono: "+telefono+"  Correo: "+correo+"  Especialidad: "+especialidad+"  Cedula de doctor: "+cedula);
                writePaciente.write("\r\n");
                writePaciente.close();
            } catch (Exception e) {
                System.out.println("Error"+e);
            }
        }
    }




