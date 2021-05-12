package com.udecar.Datos;

public class PartesMotor {

    private int idParte;
    private int categoria;
    private String nombreParte;
    private String categoriaAuto;
    private int idCategoria;

    public PartesMotor(int i1, int i, String s) {
    }

    public PartesMotor(int idParte, int categoria, String nombreParte, int idCategoria, String categoriaAuto) {
        this.idParte = idParte;
        this.categoria = categoria;
        this.nombreParte = nombreParte;
        this.idCategoria = idCategoria;
        this.categoriaAuto = categoriaAuto;
    }
    public int getIdParte() {
        return idParte;
    }

    public void setIdParte(int idParte) {
        this.idParte = idParte;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoriae(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoriaAuto() { return categoriaAuto; }

    public void setCategoriaAuto(String categoriaAuto) {
        this.categoriaAuto = categoriaAuto;
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
