/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

/**
 *
 * @author jesus
 */
public class Factory {
    public Conexion obtenerConexion(TipoConexion tipo){
        switch (tipo) {
            case MySQL:
                return ConexionMysql.getInstance();
            case Oracle:
                return null;
            default:
                throw new AssertionError();
        }
    }
}
