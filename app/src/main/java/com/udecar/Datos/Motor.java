package com.udecar.Datos;

public class Motor {
    private int idMotor;
    private String nombreMotor;
    private float cilindraje;
    private float potencia;
    private String tipoBujia;
    private String tipoFiltro;

    public Motor(int idMotor, String nombreMotor, float cilindraje, float potencia) {
        this.idMotor = idMotor;
        this.nombreMotor = nombreMotor;
        this.cilindraje = cilindraje;
        this.potencia = potencia;
    }

    public int getIdMotor() {
        return idMotor;
    }

    public void setIdMotor(int idMotor) {
        this.idMotor = idMotor;
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
