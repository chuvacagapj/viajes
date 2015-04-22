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
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        this.cliente = new Cliente();
        this.clienteDao = new ClienteDAO(this.conexion);
        this.cliente.setNombres("Jesus Jose");
        this.cliente.setApellidos("Garcia Pardo");
        this.clienteDao.insert(this.cliente);
        
        assertNotNull(this.cliente.getClienteId());
    }
    
    @Test
    public void buscarCliente(){
        
    }
    
    @Test
    public void actualizarCliente(){
    }
    
    @Test
    public void eliminarCliente()throws SQLException{
        this.clienteDao = new ClienteDAO(this.conexion);
        this.cliente = new Cliente();
        this.cliente.setClienteId(0);
        this.clienteDao.delete(cliente);
        
    }
    
    @Before
    public void abrirConexion()throws SQLException{
        ConexionMysql.setData("root", "localhost", "viajes", "chocolate4194");
        this.conexion = ConexionMysql.getInstance();
    }
    
    @After
    public void cerrarConexion()throws SQLException{
        this.conexion.close();
        ConexionMysql.CloseConexion();
    }
}