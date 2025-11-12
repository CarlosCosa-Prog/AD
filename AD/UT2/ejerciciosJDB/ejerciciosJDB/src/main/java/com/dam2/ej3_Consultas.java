package com.dam2;

import java.sql.*;

/*  3. Navegación con ResultSet No Actualizable. Haz una clase Consultas que incluya:
	    - void navegarResultSetForward(), mostrar todos los empleados del primero al último
	    - void navegarResultSetScrollable(), muestra el último, el primero, el tercero y todos en orden inverso, desde el final
*/
public class ej3_Consultas {
    // void navegarResultSetForward(), mostrar todos los empleados del primero al último
    public void navegarResultSetForward(){
        String sql = "SELECT id, nombre, apellido, salario FROM empleados ORDER BY salario DESC";
        try(Connection conn = ej1_ConexionBaseDatos.getConnection();
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                double salario = rs.getDouble("salario");
                System.out.println(id+" "+nombre+" "+apellido+" "+salario);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    // void navegarResultSetScrollable(), muestra el último, el primero, el tercero y todos en orden inverso, desde el final
    public void navegarResultSetBackward(){
        String sql = "SELECT id, nombre, apellido, salario FROM empleados ORDER BY id";
        try(Connection conn = ej1_ConexionBaseDatos.getConnection();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                double salario = rs.getDouble("salario");
                System.out.println(id+" "+nombre+" "+apellido+" "+salario);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
