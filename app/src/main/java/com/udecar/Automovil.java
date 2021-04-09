package com.udecar;

public class Automovil {
    private int idAutomovil;
    private String nombreAutomovil;
    private float tamañoAutomovil;
    private float pesoAutomovil;
    private String motorAutomovil;
    private String frenosAutomovil;
    private String transmisionAutomovil;

    public Automovil(int idAutomovil, String nombreAutomovil, float tamañoAutomovil, float pesoAutomovil, String motorAutomovil, String frenosAutomovil, String transmisionAutomovil) {
        this.idAutomovil = idAutomovil;
        this.nombreAutomovil = nombreAutomovil;
        this.tamañoAutomovil = tamañoAutomovil;
        this.pesoAutomovil = pesoAutomovil;
        this.motorAutomovil = motorAutomovil;
        this.frenosAutomovil = frenosAutomovil;
        this.transmisionAutomovil = transmisionAutomovil;
    }

    public int getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(int idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public String getNombreAutomovil() {
        return nombreAutomovil;
    }

    public void setNombreAutomovil(String nombreAutomovil) {
        this.nombreAutomovil = nombreAutomovil;
    }

    public float getTamañoAutomovil() {
        return tamañoAutomovil;
    }

    public void setTamañoAutomovil(float tamañoAutomovil) {
        this.tamañoAutomovil = tamañoAutomovil;
    }

    public float getPesoAutomovil() {
        return pesoAutomovil;
    }

    public void setPesoAutomovil(float pesoAutomovil) {
        this.pesoAutomovil = pesoAutomovil;
    }

    public String getMotorAutomovil() {
        return motorAutomovil;
    }

    public void setMotorAutomovil(String motorAutomovil) {
        this.motorAutomovil = motorAutomovil;
    }

    public String getFrenosAutomovil() {
        return frenosAutomovil;
    }

    public void setFrenosAutomovil(String frenosAutomovil) {
        this.frenosAutomovil = frenosAutomovil;
    }

    public String getTransmisionAutomovil() {
        return transmisionAutomovil;
    }

    public void setTransmisionAutomovil(String transmisionAutomovil) {
        this.transmisionAutomovil = transmisionAutomovil;
    }
}
