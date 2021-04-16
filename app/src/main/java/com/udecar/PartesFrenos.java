package com.udecar;

public class PartesFrenos {

    private int idParte;
    private String nombreParte;

    public PartesFrenos(int idParte, String nombreParte) {
        this.idParte = idParte;
        this.nombreParte = nombreParte;
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

}
