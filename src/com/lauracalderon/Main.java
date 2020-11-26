package com.lauracalderon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        CrearDoctor crear = new CrearDoctor();
        crear.ListaDoctores();
        CrearPaciente crearpaciente = new CrearPaciente();
        crearpaciente.ListaPacientes();

        /*AgendaCitas DF = new AgendaCitas();
        DF.FilePaciente();
        AgendaCitas AC = new AgendaCitas();
        AC.menuOpcionesPrincipal();*/

    }
}
