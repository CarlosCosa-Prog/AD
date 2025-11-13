package com.dam2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class consulta2Scrolleable {
    public static void consultaResulsetScrolleble(){
        String sql = "select * from empleados order by id asc";
        try(Connection con = ejercicio1conexion.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql);){

            rs.last();
            System.out.println("Ultimo empleado: "+ rs.getString("id") + " " + rs.getString("nombre"));
            rs.first();
            System.out.println("Primer empleado: "+ rs.getString("id") + " " + rs.getString("nombre"));
            rs.next();
            System.out.println("Segundo empleado: "+ rs.getString("id") + " " + rs.getString("nombre"));

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
