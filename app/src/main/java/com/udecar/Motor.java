package com.udecar;

public class Motor {
    private int idMotor;
    private String nombreMotor;
    private int cilindraje;
    private int numeroCilindros;
    private int potencia;
    private int torque;
    private String tipoAlimentacion;
    private int algo;


    public Motor(int idMotor, String nombreMotor, int cilindraje, int numeroCilindros, int potencia, int torque, String tipoAlimentacion) {
        this.idMotor = idMotor;
        this.nombreMotor = nombreMotor;
        this.cilindraje = cilindraje;
        this.numeroCilindros = numeroCilindros;
        this.potencia = potencia;
        this.torque = torque;
        this.tipoAlimentacion = tipoAlimentacion;
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

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getNumeroCilindros() {
        return numeroCilindros;
    }

    public void setNumeroCilindros(int numeroCilindros) {
        this.numeroCilindros = numeroCilindros;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public String getTipoAlimentacion() {
        return tipoAlimentacion;
    }

    public void setTipoAlimentacion(String tipoAlimentacion) {
        this.tipoAlimentacion = tipoAlimentacion;
    }

}
