/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import vo.*;
import java.util.ArrayList;

/**
 * La funcion de esta clase es la de hacer de interfaz entre los DAO y el codigo
 * cliente, debe ser capas de devolver los objeto VO correspondientes, manejar 
 * las SQLExceptions que surjan, adaptarse a cada base de datos y realizar las 
 * consultas que por su naturaleza no se puedan realizar con el patron DAO, ya 
 * sea por necesitar comandos adicionales, por que tira los tiempos de respuesta
 * o por afectar algun otro requerimiento no funcional, debe tener una funcion
 * por cada accion CRUD de cada objeto DAO
 * @author jesus
 */
public class BO {
    private Conexion conexion;
    private TipoConexion tipo;
    /* TODO faltan los atributos, debe haber un atributo por cada objeto DAO
            que exita en el paquete dao
    */
    
    // funciones create
    
    public void createCliente(Cliente cliente){
        //TODO
    }
    
    public void createCorrida(Corrida corrida){
        //TODO
    }
    
    public void createEmpresa(Empresa cliente){
        //TODO
    }
    
    public void createEstado(Estado estado){
        //TODO
    }
    
    public void createLocacion(Locacion locacion){
        //TODO
    }
    
    public void createMunicipio(Municipio municipio){
        //TODO
    }
    
    public void createReservacion(Reservacion reservacion){
        //TODO
    }
    
    public void createTransporte(Transporte transporte){
        //TODO
    }
    
    // funciones read
    
    public ArrayList <Cliente> readCliente(Cliente cliente){
        //TODO
        return null;
    }
    
    public ArrayList <Corrida> readCorrida(Corrida corrida){
        //TODO
        return null;
    }
    
    public ArrayList <Empresa> readEmpresa(Empresa cliente){
        //TODO
        return null;
    }
    
    public ArrayList <Estado> readEstado(Estado estado){
        //TODO
        return null;
    }
    
    public ArrayList <Locacion> readLocacion(Locacion locacion){
        //TODO
        return null;
    }
    
    public ArrayList <Municipio> readMunicipio(Municipio municipio){
        //TODO
        return null;
    }
    
    public ArrayList <Reservacion> readReservacion(Reservacion reservacion){
        //TODO
        return null;
    }
    
    public ArrayList <Transporte> readTransporte(Transporte transporte){
        //TODO
        return null;
    }
    
    // funciones update
    
    public void updateCliente(Cliente cliente){
        //TODO
    }
    
    public void updateCorrida(Corrida corrida){
        //TODO
    }
    
    public void updateEmpresa(Empresa cliente){
        //TODO
    }
    
    public void updateEstado(Estado estado){
        //TODO
    }
    
    public void updateLocacion(Locacion locacion){
        //TODO
    }
    
    public void updateMunicipio(Municipio municipio){
        //TODO
    }
    
    public void updateReservacion(Reservacion reservacion){
        //TODO
    }
    
    public void updateTransporte(Transporte transporte){
        //TODO
    }
    
    // funciones delete
    
    public void deleteCliente(Cliente cliente){
        //TODO
    }
    
    public void deleteCorrida(Corrida corrida){
        //TODO
    }
    
    public void deleteEmpresa(Empresa cliente){
        //TODO
    }
    
    public void deleteEstado(Estado estado){
        //TODO
    }
    
    public void deleteLocacion(Locacion locacion){
        //TODO
    }
    
    public void deleteMunicipio(Municipio municipio){
        //TODO
    }
    
    public void deleteReservacion(Reservacion reservacion){
        //TODO
    }
    
    public void deleteTransporte(Transporte transporte){
        //TODO
    }
}
