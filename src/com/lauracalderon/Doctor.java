package com.lauracalderon;


public class Doctor {

    private String NOMBRE;
    private String TELEFONO;
    private String CORREO;
    private String ESPECIALIDAD;
    private String CEDULA;

    public Doctor(String nombre, String telefono, String correo, String especialidad, String cedula){

        this.NOMBRE = nombre;
        this.TELEFONO = telefono;
        this.CORREO = correo;
        this.ESPECIALIDAD = especialidad;
        this.CEDULA = cedula;

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

    public String getESPECIALIDAD() {
        return ESPECIALIDAD;
    }

    public void setESPECIALIDAD(String ESPECIALIDAD) {
        this.ESPECIALIDAD = ESPECIALIDAD;
    }

    public String getCEDULA() {
        return CEDULA;
    }

    public void setCEDULA(String CEDULA) {
        this.CEDULA = CEDULA;
    }


}
