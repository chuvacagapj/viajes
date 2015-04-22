/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vo.Cliente;

/**
 *
 * @author jesus
 */
public class ClienteDAO {
    
    private Conexion conexion;
    
    public ClienteDAO(Conexion con){
        this.conexion = con;
    }
    
    public ArrayList <Cliente> select (Cliente cliente) throws SQLException{
        String query = "SELECT clienteId, nombre, apellido\nFROM cliente\n";
        PreparedStatement consulta;
        PreparedStatement l;
        ResultSet resultado;
        ResultSet r;
        ArrayList <Cliente> lista = new ArrayList();
        
        if (!(cliente.getClienteId() == null)) {
            query = String.format("%s%s%s%s", query, "WHERE clienteId = ", 
                    cliente.getClienteId().toString(), ";");
        }else if(!(cliente.getApellidos() == null && cliente.getNombres() == null)){
            query = String.format("%s%s", query, "WHERE ");
            if(!(cliente.getApellidos() == null)){
                query = String.format("%s%s", query, "apellido = ", cliente.getApellidos(), "\n");
            }
            if(!(cliente.getApellidos() == null || cliente.getNombres() == null)){
                query = String.format("%s%s", query,"AND ");
            }
            if(!(cliente.getNombres() == null)){
                query = String.format("%s%s", query, "nombre = ", cliente.getNombres(), "\n");
            }
            query = String.format("%s%s", query, ";");
        }else {
            query = String.format("%s%s", query, ";");
        }
        query = String.format("%s%s", query, ";");
        consulta = this.conexion.sentencia(query);
        resultado = consulta.executeQuery();
        
        resultado.beforeFirst();
        while(resultado.next()){
            Cliente c   = new Cliente();
            ArrayList <String> tel = new ArrayList();
            String[] telefonos = null;
            
            c.setApellidos((String)resultado.getString("apellido"));
            c.setClienteId((Integer)resultado.getInt("clienteId"));
            c.setNombres((String)resultado.getString("nombre"));
            
            l = this.conexion.sentencia(String.format("SELECT telefono FROM telefono WHERE clienteId = %s;", c.getClienteId().toString()));
            r = l.executeQuery();
            r.beforeFirst();
            while(r.next()){
                tel.add(r.getString("telefono"));
            }
            
            telefonos =  new String[tel.toArray().length];
            c.setTelefono(tel.toArray(telefonos));
            lista.add(c);
        }
        
        resultado.close();
        consulta.close();
        return lista;
    }
    
    public void insert(Cliente cliente)throws SQLException {
        PreparedStatement sentencia;
        PreparedStatement pClave;
        ResultSet clave;
        String query = "SELECT MAX(clienteId) + 1 FROM cliente";
        
        pClave = conexion.sentencia(query);
        clave = pClave.executeQuery();
        clave.first();
        cliente.setClienteId(clave.getInt(1));
        
        query = "INSERT INTO cliente(clienteId, nombre, apellido) VALUES(?,?,?);";
        sentencia = conexion.sentencia(query);
        sentencia.setInt(1, cliente.getClienteId().intValue());
        sentencia.setNString(2, cliente.getNombres  ());
        sentencia.setNString(3, cliente.getApellidos());
        sentencia.executeUpdate();
        
        clave.close();
        sentencia.close();
        pClave.close();
    }
    
    public void update (Cliente cliente) throws SQLException{
        PreparedStatement sentencia;
        String query = "UPDATE cliente\nSET nombre = ?, apellido =?\nWHERE clienteId =?;";
        sentencia = conexion.sentencia(query);
        sentencia.setNString(1, cliente.getNombres());
        sentencia.setNString(2, cliente.getApellidos());
        sentencia.setInt(3, cliente.getClienteId());
        sentencia.executeUpdate();
    }
    
    public void delete (Cliente cliente) throws SQLException{
        PreparedStatement sentencia;
        String query = String.format("DELETE FROM cliente WHERE clienteId = %s", cliente.getClienteId().toString());
        sentencia = conexion.sentencia(query);
        sentencia.executeUpdate();
    }
}
