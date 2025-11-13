package com.dam2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class consulta1Forward {
    public static void consultaResulSetForward(){
        String sql = "SELECT id, nombre, apellido, salario FROM empleados ORDER BY id ASC";
        try(Connection con = ejercicio1conexion.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
                System.out.println("Id: " + rs.getString("id")
                        + " Nombre: " + rs.getString("nombre")
                        + " Apellido: " + rs.getString("apellido")
                        + " Salario: " + rs.getDouble("salario"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
