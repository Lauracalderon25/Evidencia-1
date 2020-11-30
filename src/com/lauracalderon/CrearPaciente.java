package com.lauracalderon;

import com.csvreader.CsvReader;
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

public class CrearPaciente {

    public void ListaPacientes() {
        List<Paciente> Pacientes = new ArrayList<Paciente>();

        Scanner numero = new Scanner(System.in);
        System.out.println("¿Cuantos pacientes vas a ingresar?");
        var no = numero.nextInt();


        for (int x = 0; x < no; x++) {

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


            //Pacientes.add(new Paciente(nombre, telefono, correo, edad, genero));

            //Doctores.add(new Doctor())
            ImportarCSV(nombre,telefono,correo,edad,genero);
            ExportarCSV(Pacientes);

        }
    }
    private static final String RutaPaciente = System.getProperty("user.home");
    private static final String DocumentoPaciente = "DataBasePaciente.csv";

    public static void ExportarCSV(List<Paciente> Pacientes){
        //String salidaArchivo = "DataBasePaciente.csv"; // Nombre del archivo
        var separador = FileSystems.getDefault().getSeparator();
        var salidaArchivo = String.format("%s%s%s", RutaPaciente,separador,DocumentoPaciente);
        Path locaciondoc = Paths.get(salidaArchivo);

        // Si existe un archivo llamado asi lo borra
        if(!java.nio.file.Files.exists(locaciondoc)) {
            File file = new File (String.valueOf(locaciondoc));
            try{
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("Error"+e);
            }
        }

    }
    public static void ImportarCSV(String nombre, String telefono, String correo, String edad, String genero) {
        var separador = FileSystems.getDefault().getSeparator();
        var filepath = String.format("%s%s%s", RutaPaciente,separador,DocumentoPaciente);
        Path locaciondoc = Paths.get(filepath);
        try{
            FileWriter writePaciente = new FileWriter(filepath, true);
            writePaciente.write("Nombre: "+nombre+"  Telefono: "+telefono+"  Correo: "+correo+"  Edad: "+edad+"  Genero: "+genero);
            writePaciente.write("\r\n");
            writePaciente.close();
        } catch (Exception e) {
            System.out.println("Error"+e);
        }

    }
}
