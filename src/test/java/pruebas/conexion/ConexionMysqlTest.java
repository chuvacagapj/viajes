package pruebas.conexion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import conexion.ConexionMysql;
import conexion.Conexion;
import java.sql.SQLException;
import static org.junit.Assert.*;

/**
 *
 * @author jesus
 */
public class ConexionMysqlTest {
    
    public ConexionMysqlTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void conexionExitosa() throws SQLException {
        ConexionMysql.setData("root", "localhost", "viajes", "chocolate4194");
        Conexion con = ConexionMysql.getInstance();
        con.close();
    }
}