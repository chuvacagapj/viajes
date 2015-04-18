/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author jesus
 */
public class Locacion {
    private Integer locacionId;
    private String nombre;
    private Municipio municipio;

    public Integer getLocacionId() {
        return locacionId;
    }

    public void setLocacionId(Integer locacionId) {
        this.locacionId = locacionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    
    
}
