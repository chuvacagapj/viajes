/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import vo.*;
import dao.*;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * La funcion de esta clase es la de hacer de interfaz entre los DAO y el codigo
 * cliente, debe ser capas de devolver los objeto VO correspondientes, manejar
 * las SQLExceptions que surjan, adaptarse a cada base de datos y realizar las
 * consultas que por su naturaleza no se puedan realizar con el patron DAO, ya
 * sea por necesitar comandos adicionales, por que tira los tiempos de respuesta
 * o por afectar algun otro requerimiento no funcional, debe tener una funcion
 * por cada accion CRUD de cada objeto DAO
 *
 * @author jesus
 */
public class BO {
    
    private Conexion conexion;
    private ClienteDAO cliente;
    /* TODO faltan los atributos, debe haber un atributo por cada objeto DAO
     que exita en el paquete dao
     */

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public ClienteDAO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDAO cliente) {
        this.cliente = cliente;
    }
    
    

    // funciones create
    public boolean createCliente(Cliente cliente) {
        if (cliente.getApellidos() == null) {
            JOptionPane.showMessageDialog(null, "¡Es obligatorio llenar el apellido!", "¡¡Error en la Captura!!", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (cliente.getNombres() == null) {
            JOptionPane.showMessageDialog(null, "¡Es obligatorio llenar el nombre!", "¡¡Error en la Captura!!", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            try {
                this.cliente.insert(cliente);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "¡¡Error en la Base de datos!!", JOptionPane.ERROR_MESSAGE);
                return false;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex, "¡¡Error inusual!!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
 
    // funciones read
    public ArrayList<Cliente> readCliente(Cliente cliente) {
        ArrayList<Cliente> lista = null;
        try {
            lista = this.cliente.select(cliente);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "¡¡Error en la Base de datos!!", JOptionPane.ERROR_MESSAGE);
        }catch (NullPointerException ex) {
            throw ex;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "¡¡Error inusual!!", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    // funciones update
    public boolean updateCliente(Cliente cliente) {
        try {
            this.cliente.update(cliente);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "¡¡Error en la Base de datos!!", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "¡¡Error inusual!!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // funciones delete
    public void deleteCliente(Cliente cliente) {
        try {
            this.cliente.delete(cliente);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "¡¡Error en la Base de datos!!", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "¡¡Error inusual!!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
