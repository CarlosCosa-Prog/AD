package com.dam2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class consulta3Actualizable {
    private static Scanner sc = new Scanner(System.in);
    public static void  actualizarSalario(){
        String sql = "select * from empleados order by id asc ";
        try(Connection con = ejercicio1conexion.getConnection();
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stm.executeQuery(sql)){
            while(rs.next())
            {
                double salarioActual = rs.getDouble("salario");
                double nuevoSalario = 2000;
                rs.updateDouble("salario",nuevoSalario);
                rs.updateRow();
                System.out.println("nombre: "+rs.getString("nombre") + " salario: " + salarioActual);
                System.out.println("nombre: "+rs.getString("nombre") + " salarioActualizado: " + rs.getString("salario"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void insertarUsuario(){
        String sql = "select * from empleados order by id asc ";
        try(Connection con = ejercicio1conexion.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql)){

            // Se prepara una nueva fila en blanco
            rs.moveToInsertRow();
            System.out.println("Introduce un nombre");
            String nombre = sc.nextLine().toString();
            rs.updateString("nombre",nombre);
            rs.updateString("apellido","Cosa");
            rs.updateDouble("salario",3000);

            // Inserta ula final nueva
            rs.insertRow();
            // Regresa al cursor actual
            rs.moveToCurrentRow();
            System.out.println("Empleado insertado con exito");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
