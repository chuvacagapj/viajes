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
public class Empresa {
    private Integer     empresaId;
    private String      nombre;
    private Transporte  tipoTransporte;
    private String      rfc;
    private String[]    telefono;

    public String[] getTelefono() {
        return telefono;
    }

    public void setTelefono(String[] telefono) {
        this.telefono = telefono;
    }

    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Transporte getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(Transporte tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    
}
