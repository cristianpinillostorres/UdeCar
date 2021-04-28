package com.udecar;

public class GuardarDatosModificados {

    String idDato, bujia, filtro, altas, porcentaje, pinza, tiposFrenos;

    public GuardarDatosModificados(String id, String bujias, String filtroAire) {
    }

    public String getIdDato() {
        return idDato;
    }

    public String getBujia() {
        return bujia;
    }

    public String getFiltro() {
        return filtro;
    }

    public String getAltas() {
        return altas;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public String getPinza() {
        return pinza;
    }

    public String getTiposFrenos() {
        return tiposFrenos;
    }


    public GuardarDatosModificados(String idDato, String bujia, String filtro, String altas, String porcentaje, String pinza, String tiposFrenos) {
        this.idDato = idDato;
        this.bujia = bujia;
        this.filtro = filtro;
        this.altas = altas;
        this.porcentaje = porcentaje;
        this.pinza = pinza;
        this.tiposFrenos = tiposFrenos;
    }








}
