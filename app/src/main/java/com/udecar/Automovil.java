package com.udecar;
import java.io.Serializable;

public class Automovil implements Serializable{
    private int idAutomovil;
    private String nombreAutomovil;
    private int imagenAutomovil;//cambiar para usar BD
    private float pesoAutomovil;
    private String descripcion;
    private String categoria;
    private String nombreMotor ;
    private float potenciaMotor;
    private float cilindrajeMotor;

    public Automovil(int idAutomovil, String nombreAutomovil, int imagenAutomovil, float pesoAutomovil, String descripcion, String categoria, String nombreMotor, float potenciaMotor, float cilindrajeMotor) {
        this.idAutomovil = idAutomovil;
        this.nombreAutomovil = nombreAutomovil;
        this.imagenAutomovil = imagenAutomovil;
        this.pesoAutomovil = pesoAutomovil;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.nombreMotor = nombreMotor;
        this.potenciaMotor = potenciaMotor;
        this.cilindrajeMotor = cilindrajeMotor;
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

    public float getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(float potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public float getCilindrajeMotor() {
        return cilindrajeMotor;
    }

    public void setCilindrajeMotor(float cilindrajeMotor) {
        this.cilindrajeMotor = cilindrajeMotor;
    }

}
