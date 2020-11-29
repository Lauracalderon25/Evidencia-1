package com.lauracalderon;

public class Paciente {
    private String NOMBRE;
    private String TELEFONO;
    private String CORREO;
    private String EDAD;
    private String GENERO;

    public Paciente(String nombre, String telefono, String correo, String edad, String genero){

        this.NOMBRE = nombre;
        this.TELEFONO = telefono;
        this.CORREO = correo;
        this.EDAD = edad;
        this.GENERO = genero;

    }

    public String getNOMBRE(){
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getTELEFONO(){
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getCORREO(){
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public String getEDAD() {
        return EDAD;
    }

    public void setEDAD(String EDAD) { this.EDAD = EDAD; }

    public String getGENERO() {
        return GENERO;
    }

    public void setGENERO(String GENERO) {
        this.GENERO = GENERO;
    }

}
