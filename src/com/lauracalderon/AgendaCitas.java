package com.lauracalderon;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;


public class AgendaCitas {

    public static void agenda(String[] args) {
        /*comprobarBD();
        menuOpcionesPrincipal();*/

    }

    public void menuOpcionesPrincipal() {
        Scanner opmenu = new Scanner(System.in);

        int opcion;
        boolean salir = false;

        do {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("                               AGENDA DE CITAS");
            System.out.println("---------------------------------------------------------------------\n");

            System.out.println("Ingresar una de las opciones siguientes:\n");
            System.out.println("1.Agregar doctor: ");
            System.out.println("2.Agregar pacientes: ");
            System.out.println("3.Agregar una nueva cita");
            System.out.println("4.Eliminar cita");
            System.out.println("5.Salir del programa");
            opcion = opmenu.nextInt();
            System.out.println("---------------------------------------------------------------------\n");
            switch (opcion) {
                case 1:
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                    AGREGAR NUEVO DOCTOR                                ");
                    System.out.println("---------------------------------------------------------------------\n");
                    CrearDoctor crear = new CrearDoctor();
                    crear.ListaDoctores();
                    System.out.println("---------------------------------------------------------------------\n");
                    break;
                case 2:
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                      AGREGAR PACIENTE                                ");
                    System.out.println("---------------------------------------------------------------------\n");
                    CrearPaciente crearPaciente = new CrearPaciente();
                    crearPaciente.ListaPacientes();
                    System.out.println("\n---------------------------------------------------------------------");
                    System.out.println("----------------------------------------------------------------------\n\n");
                    break;
                case 3:
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                       AGREGAR CITA                                         ");
                    System.out.println("---------------------------------------------------------------------\n");
                    CrearCita crearCita = new CrearCita();
                    crearCita.ListaCitas();
                    System.out.println("\n---------------------------------------------------------------------");
                    System.out.println("----------------------------------------------------------------------\n\n");
                    break;
                case 4:
                    System.out.println("Eliminar datos");
                    break;
                case 5:
                    salir = true;
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while (opcion != 6);
        }

    }

