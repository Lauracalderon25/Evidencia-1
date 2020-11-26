package com.lauracalderon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        login login = new login();
        login.login();
        CrearPaciente crearpaciente = new CrearPaciente();
        crearpaciente.ListaPacientes();
        CrearDoctor crearDoctor = new CrearDoctor();
        crearDoctor.ListaDoctores();

        /*AgendaCitas DF = new AgendaCitas();
        DF.FilePaciente();
        AgendaCitas AC = new AgendaCitas();
        AC.menuOpcionesPrincipal();*/

    }
}
