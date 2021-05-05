package com.udecar.Datos;
import java.io.Serializable;

public class Automovil implements Serializable{
    private String nombreAutomovil;
    private int imagenAutomovil;//cambiar para usar BD
    private float pesoAutomovil;
    private String descripcion;
    private String categoria;
    private String nombreMotor;
    private String nombreFrenos;

    public Automovil(){

    }

    public Automovil( String nombreAutomovil, int imagenAutomovil, float pesoAutomovil, String descripcion, String categoria, String nombreMotor,String nombreFrenos) {
        this.nombreAutomovil = nombreAutomovil;
        this.imagenAutomovil = imagenAutomovil;
        this.pesoAutomovil = pesoAutomovil;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.nombreMotor = nombreMotor;
        this.nombreFrenos = nombreFrenos;
    }

    public String getNombreAutomovil() {
        return nombreAutomovil;
    }

    public void setNombreAutomovil(String nombreAutomovil) {
        this.nombreAutomovil = nombreAutomovil;
    }

    public int getImagenAutomovil() {
        return imagenAutomovil;
    }

    public void setImagenAutomovil(int imagenAutomovil) {
        this.imagenAutomovil = imagenAutomovil;
    }

    public float getPesoAutomovil() {
        return pesoAutomovil;
    }

    public void setPesoAutomovil(float pesoAutomovil) {
        this.pesoAutomovil = pesoAutomovil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombreMotor() {
        return nombreMotor;
    }

    public void setNombreMotor(String nombreMotor) {
        this.nombreMotor = nombreMotor;
    }

    public String getNombreFrenos() {
        return nombreFrenos;
    }

    public void setNombreFrenos(String nombreFrenos) {
        this.nombreFrenos = nombreFrenos;
    }
}
