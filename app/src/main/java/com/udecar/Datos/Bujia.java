package com.udecar.Datos;

public class Bujia {
    private float potencia;
    private String nombreBujia;

    public Bujia(float potencia, String nombreBujia) {
        this.potencia = potencia;
        this.nombreBujia = nombreBujia;
    }

    public Bujia() {
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public String getNombreBujia() {
        return nombreBujia;
    }

    public void setNombreBujia(String nombreBujia) {
        this.nombreBujia = nombreBujia;
    }
}
