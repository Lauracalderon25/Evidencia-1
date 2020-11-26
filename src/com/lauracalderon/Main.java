package com.lauracalderon;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //ArchivoDB DB = new ArchivoDB();
        //DB.cargar();
        AgendaCitas SD = new AgendaCitas();
        SD.FileDoctor();
        AgendaCitas DF = new AgendaCitas();
        DF.FilePaciente();
        AgendaCitas AC = new AgendaCitas();
        AC.menuOpcionesPrincipal();

    }
}
