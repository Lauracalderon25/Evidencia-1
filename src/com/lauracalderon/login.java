package com.lauracalderon;

import java.io.File;
import java.sql.SQLOutput;
import java.util.Scanner;

public class login {


    public void login() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa el usuario");
        var usuario = entrada.next();

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresa la contraseña" );
        var contraseña = leer.nextInt();

        if(contraseña == 1234 && usuario.equals("Admin")){
            AgendaCitas cita = new AgendaCitas();
            cita.menuOpcionesPrincipal();
        }else{
            System.out.println("Usuario o contraseña invalido" );
        }
    }
}