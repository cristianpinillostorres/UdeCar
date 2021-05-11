package com.udecar.Datos;

public class Bujia {
    private float potencia;
    private String tipoBujia;

    public Bujia() {
    }

    public Bujia(float potencia, String tipoBujia) {
        this.potencia = potencia;
        this.tipoBujia = tipoBujia;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public String getTipoBujia() {
        return tipoBujia;
    }

    public void setTipoBujia(String tipoBujia) {
        this.tipoBujia = tipoBujia;
    }
}
