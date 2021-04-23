package com.udecar.Datos;

public class PartesFrenos {

    private int idParte;
    private String nombreParte;
    private int categria;

    public PartesFrenos(){

    }

    public PartesFrenos(int idParte, String nombreParte, int categria) {
        this.idParte = idParte;
        this.nombreParte = nombreParte;
        this.categria = categria;
    }

    public int getIdParte() {
        return idParte;
    }

    public void setIdParte(int idParte) {
        this.idParte = idParte;
    }

    public String getNombreParte() {
        return nombreParte;
    }

    public void setNombreParte(String nombreParte) {
        this.nombreParte = nombreParte;
    }

    public int getCategria() {
        return categria;
    }

    public void setCategria(int categria) {
        this.categria = categria;
    }
}
