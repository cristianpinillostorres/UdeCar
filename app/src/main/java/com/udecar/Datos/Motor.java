package com.udecar.Datos;

import java.io.Serializable;

public class Motor implements Serializable {
    private String nombreMotor;
    private long cilindraje;
    private long potencia;
    private String tipoBujia;
    private String tipoFiltro;

    public Motor(){

    }

    public Motor(String nombreMotor, long cilindraje, long potencia, String tipoBujia, String tipoFiltro) {
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

    public void setCilindraje(long cilindraje) {
        this.cilindraje = cilindraje;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(long potencia) {
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
