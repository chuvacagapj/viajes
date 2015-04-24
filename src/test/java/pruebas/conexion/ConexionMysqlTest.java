package pruebas.conexion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import conexion.ConexionMysql;
import conexion.Conexion;
import dao.*;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import vo.*;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author jesus
 */
public class ConexionMysqlTest {
    
    private Conexion conexion;
    private Cliente cliente;
    private ClienteDAO clienteDao;
    

    public ConexionMysqlTest() throws SQLException{

    }
    
    @Test
    public void InsertarCliente() throws SQLException{
        assertNotNull(this.conexion);
        this.cliente.setNombres("Jesus Jose");
        this.cliente.setApellidos("Garcia Pardo");
        this.clienteDao.insert(this.cliente);
        
        assertNotNull(this.cliente.getClienteId());
    }
    
    @Test
    public void buscarCliente()throws SQLException{
        ArrayList <Cliente> lista = this.clienteDao.select(this.cliente);
        for (Cliente lista1 : lista) {
            System.out.println(String.format("Nombres: %s, Apellidos: %s", lista1.getNombres(), lista1.getApellidos()));
        }
    }
    
    @Test
    public void actualizarCliente()throws SQLException{
        this.cliente.setClienteId(1);
        System.out.println(this.cliente = this.clienteDao.select(this.cliente).get(0));
        this.cliente.setNombres("Adrian Ernesto");
        this.clienteDao.update(cliente);
    }
    
    @Test
    public void eliminarCliente()throws SQLException{
        this.cliente.setClienteId(0);
        this.clienteDao.delete(cliente);
        
    }
    
    @Before
    public void abrirConexion()throws SQLException{
        ConexionMysql.setData("root", "localhost", "viajes", "chocolate4194");
        this.conexion = ConexionMysql.getInstance();
        this.cliente = new Cliente();
        this.clienteDao = new ClienteDAO(this.conexion);
    }
    
    @After
    public void cerrarConexion()throws SQLException{
        this.conexion.close();
        ConexionMysql.CloseConexion();
    }
}