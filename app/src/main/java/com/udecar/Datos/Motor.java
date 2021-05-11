package com.udecar.Datos;

import java.io.Serializable;

public class Motor implements Serializable {
    private String nombreMotor;
    private float cilindraje;
    private float potencia;
    private String tipoBujia;
    private String tipoFiltro;

    public Motor(){
    }

    public Motor(String nombreMotor, float cilindraje, float potencia, String tipoBujia, String tipoFiltro) {
        this.nombreMotor = nombreMotor;
        this.cilindraje = cilindraje;
        this.potencia = potencia;
        this.tipoBujia = tipoBujia;
        this.tipoFiltro = tipoFiltro;
    }

    public String getNombreMotor() {
        return nombreMotor;
    }

    public void setNombreMotor(String nombreMotor) {
        this.nombreMotor = nombreMotor;
    }

    public float getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(float cilindraje) {
        this.cilindraje = cilindraje;
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

    public String getTipoFiltro() {
        return tipoFiltro;
    }

    public void setTipoFiltro(String tipoFiltro) {
        this.tipoFiltro = tipoFiltro;
    }
}
