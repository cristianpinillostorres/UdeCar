package com.udecar.Datos;

public class PartesMotor {

    private int idParte;
    private int categoria;
    private String nombreParte;





    public PartesMotor(int idParte, int categoria, String nombreParte) {
        this.idParte = idParte;
        this.categoria = categoria;
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

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
