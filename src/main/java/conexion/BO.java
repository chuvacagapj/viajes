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
    public void createCliente(Cliente cliente) {
        if (cliente.getApellidos() == null) {
            JOptionPane.showMessageDialog(null, "¡Es obligatorio llenar el apellido!", "¡¡Error en la Captura!!", JOptionPane.ERROR_MESSAGE);
        } else if (cliente.getNombres() == null) {
            JOptionPane.showMessageDialog(null, "¡Es obligatorio llenar el nombre!", "¡¡Error en la Captura!!", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                this.cliente.insert(cliente);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "¡¡Error en la Base de datos!!", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex, "¡¡Error inusual!!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void createCorrida(Corrida corrida) {
        //TODO
    }
    
    public void createEmpresa(Empresa cliente) {
        //TODO
    }
    
    public void createEstado(Estado estado) {
        //TODO
    }
    
    public void createLocacion(Locacion locacion) {
        //TODO
    }
    
    public void createMunicipio(Municipio municipio) {
        //TODO
    }
    
    public void createReservacion(Reservacion reservacion) {
        //TODO
    }
    
    public void createTransporte(Transporte transporte) {
        //TODO
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
    
    public ArrayList<Corrida> readCorrida(Corrida corrida) {
        //TODO
        return null;
    }
    
    public ArrayList<Empresa> readEmpresa(Empresa cliente) {
        //TODO
        return null;
    }
    
    public ArrayList<Estado> readEstado(Estado estado) {
        //TODO
        return null;
    }
    
    public ArrayList<Locacion> readLocacion(Locacion locacion) {
        //TODO
        return null;
    }
    
    public ArrayList<Municipio> readMunicipio(Municipio municipio) {
        //TODO
        return null;
    }
    
    public ArrayList<Reservacion> readReservacion(Reservacion reservacion) {
        //TODO
        return null;
    }
    
    public ArrayList<Transporte> readTransporte(Transporte transporte) {
        //TODO
        return null;
    }

    // funciones update
    public void updateCliente(Cliente cliente) {
        try {
            this.cliente.update(cliente);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "¡¡Error en la Base de datos!!", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "¡¡Error inusual!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateCorrida(Corrida corrida) {
        //TODO
    }
    
    public void updateEmpresa(Empresa cliente) {
        //TODO
    }
    
    public void updateEstado(Estado estado) {
        //TODO
    }
    
    public void updateLocacion(Locacion locacion) {
        //TODO
    }
    
    public void updateMunicipio(Municipio municipio) {
        //TODO
    }
    
    public void updateReservacion(Reservacion reservacion) {
        //TODO
    }
    
    public void updateTransporte(Transporte transporte) {
        //TODO
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
    
    public void deleteCorrida(Corrida corrida) {
        //TODO
    }
    
    public void deleteEmpresa(Empresa cliente) {
        //TODO
    }
    
    public void deleteEstado(Estado estado) {
        //TODO
    }
    
    public void deleteLocacion(Locacion locacion) {
        //TODO
    }
    
    public void deleteMunicipio(Municipio municipio) {
        //TODO
    }
    
    public void deleteReservacion(Reservacion reservacion) {
        //TODO
    }
    
    public void deleteTransporte(Transporte transporte) {
        //TODO
    }
}
