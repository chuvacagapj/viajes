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
public class Reservacion {
    private Integer reservacion;
    private Corrida corrida;
    private Cliente cliente;
    private Float adeudo;
    private Integer nAcientos;
    private String[] asientosReservados;

    public Integer getReservacion() {
        return reservacion;
    }

    public void setReservacion(Integer reservacion) {
        this.reservacion = reservacion;
    }

    public Corrida getCorrida() {
        return corrida;
    }

    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Float getAdeudo() {
        return adeudo;
    }

    public void setAdeudo(Float adeudo) {
        this.adeudo = adeudo;
    }

    public Integer getnAcientos() {
        return nAcientos;
    }

    public void setnAcientos(Integer nAcientos) {
        this.nAcientos = nAcientos;
    }

    public String[] getAsientosReservados() {
        return asientosReservados;
    }

    public void setAsientosReservados(String[] asientosReservados) {
        this.asientosReservados = asientosReservados;
    }
    
    
}
