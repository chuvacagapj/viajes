/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

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
}
