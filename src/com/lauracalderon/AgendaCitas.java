package com.lauracalderon;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
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
    //String filename = String.format("src%scom%slauracalderon%sArchivoDB.csv",separator,separator,separator,separator,separator,separator);
    static File ArchivoDB = new File("Database.csv");

    public static void main(String[] args) {
        comprobarBD();
        menuOpcionesPrincipal();
    }

    private static void menuOpcionesPrincipal() {
        Scanner opmenu = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("                               AGENDA DE CITAS");
            System.out.println("---------------------------------------------------------------------\n");

            System.out.println("Ingresar una de las opciones siguientes:\n");
            System.out.println("1.Agregar una nueva cita");
            System.out.println("2.Buscar una cita");
            System.out.println("3.Actualizar cita");
            System.out.println("4.Eliminar cita");
            System.out.println("5.Mostrar todas las citas agendadas");
            System.out.println("6.Salir del programa");
            opcion = opmenu.nextInt();
            System.out.println("---------------------------------------------------------------------\n");
            switch (opcion) {
                case 1:
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                 AGREGAR NUEVO REGISTRO                                ");
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
                case 6:
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

    private static void agregarRegistro() {
        Scanner agregar = new Scanner(System.in);
        String sperador = "  |  ";
        int tamañao = 0; //para ver el tamaño del registro


    }

    private static void comprobarBD () {
        try{
            if(ArchivoDB.exists()){
                System.out.println("Puede trabajar en el archivo. \n");
            }else { ArchivoDB.createNewFile();
                System.out.println("Se ha creado el archivo, ya puedes trabajar. \n");
            }
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
            System.out.println("No se puede trabajar en el archivo. \n ");
        }
        }

    }
