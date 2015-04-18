/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.sql.Date;

/**
 *
 * @author jesus
 */
public class Corrida {
    private Integer corridaId;
    private Locacion locacionPartida;
    private Date fechaPartida;
    private Locacion locacionDestino;
    private Date fechaDestino;
    private Empresa empresa;
    private Float costo;

    public Integer getCorridaId() {
        return corridaId;
    }

    public void setCorridaId(Integer corridaId) {
        this.corridaId = corridaId;
    }

    public Locacion getLocacionPartida() {
        return locacionPartida;
    }

    public void setLocacionPartida(Locacion locacionPartida) {
        this.locacionPartida = locacionPartida;
    }

    public Date getFechaPartida() {
        return fechaPartida;
    }

    public void setFechaPartida(Date fechaPartida) {
        this.fechaPartida = fechaPartida;
    }

    public Locacion getLocacionDestino() {
        return locacionDestino;
    }

    public void setLocacionDestino(Locacion locacionDestino) {
        this.locacionDestino = locacionDestino;
    }

    public Date getFechaDestino() {
        return fechaDestino;
    }

    public void setFechaDestino(Date fechaDestino) {
        this.fechaDestino = fechaDestino;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }
    
}
