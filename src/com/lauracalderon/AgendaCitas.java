package com.lauracalderon;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class AgendaCitas {
    public static String NOMBRE;
    public static String TELEFONO;
    public static String CORREO;

    public static String DIRECCION;
    public static String FECHA;
    public static String HORA;
    public static String DESCRIPCION;




    //String separator = FileSystems.getDefault().getSeparator();
    //String filename = String.format("src%scom%slauracalderon%sArchivoDataBase.csv",separator,separator,separator,separator,separator,separator);

    public void FileDoctor(){
        String separator = FileSystems.getDefault().getSeparator();
        String fileName = String.format("src%scom%slauracalderon%sDataBaseDoctor.csv",separator,separator,separator,separator,separator);
        Path path = Paths.get(fileName);

        ArrayList<String> lines = new ArrayList<>();

        if(!Files.exists(path)){
            File file = new File(String.valueOf(path));
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error"+ e);
            }
        }

    }
    public void FilePaciente(){
        String separator = FileSystems.getDefault().getSeparator();
        String fileName = String.format("src%scom%slauracalderon%sDataBasePaciente.csv",separator,separator,separator,separator,separator);
        Path path = Paths.get(fileName);

        ArrayList<String> lines = new ArrayList<>();

        if(!Files.exists(path)){
            File file = new File(String.valueOf(path));
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error"+ e);
            }
        }

    }


    public static void main(String[] args) {
        /*comprobarBD();
        menuOpcionesPrincipal();*/

    }

    public static void menuOpcionesPrincipal() {
        Scanner opmenu = new Scanner(System.in);
        //File ArchivoDB = new File("ArchivoDatabase.csv");

        int opcion;

        do {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("                               AGENDA DE CITAS");
            System.out.println("---------------------------------------------------------------------\n");

            System.out.println("Ingresar una de las opciones siguientes:\n");
            System.out.println("1.Agregar doctor y especialidad: ");
            System.out.println("2.Agregar pacientes: ");
            System.out.println("3.Agregar una nueva cita");
            System.out.println("4.Buscar una cita");
            System.out.println("5.Actualizar cita");
            System.out.println("6.Eliminar cita");
            System.out.println("7.Mostrar todas las citas agendadas");
            System.out.println("8.Salir del programa");
            opcion = opmenu.nextInt();
            System.out.println("---------------------------------------------------------------------\n");
            switch (opcion) {
                case 1:
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                 AGREGAR NUEVO DOCTOR                                ");
                    System.out.println("---------------------------------------------------------------------\n");
                    agregarRegistro();
                    System.out.println("---------------------------------------------------------------------\n");
                    break;
                case 2:
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                  Buscando....");
                    System.out.println("---------------------------------------------------------------------\n");
                    menuBuscarRegistro();
                    System.out.println("\n---------------------------------------------------------------------");
                    System.out.println("                 Fin de la Busqueda");
                    System.out.println("----------------------------------------------------------------------\n\n");
                    break;
                case 3:
                    System.out.println("Actualizar datos");
                    break;
                case 4:
                    System.out.println("Eliminar datos");
                    break;
                case 5:
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                  Total de registros dentro del programa");
                    System.out.println("---------------------------------------------------------------------\n");
                    mostrarRegistros();
                    System.out.println("\n---------------------------------------------------------------------");
                    System.out.println("                 Fin de Archivos");
                    System.out.println("----------------------------------------------------------------------\n");
                    break;
                case 8:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while (opcion != 6);
        }

    private static void mostrarRegistros() {
    }

    private static void menuBuscarRegistro() {
    }

    private static void agregarRegistro()  {
        AgendaCitas nose = new AgendaCitas();
        nose.FileDoctor();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa nombre del doctor ");
        var nombre = entrada.next();
        System.out.println("Ingresar ID: ");
        var numero = entrada.next();


    }

    private static void comprobarBD () {
        /*try{

            if(DataBasePaciente.exists()){
                System.out.println("Puede trabajar en el archivo. \n");
            }else { ArchivoDB.createNewFile();
                System.out.println("Se ha creado el archivo, ya puedes trabajar. \n");
            }
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
            System.out.println("No se puede trabajar en el archivo. \n ");
        }*/
        }

    }

