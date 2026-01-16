package com.dam2;

import java.sql.*;

public class ej2_EmpleadosCrud {
    // insertarEmpleado(String nombre, String apellido, double salario, int departamentoId)
    public void insertarEmpleados(String nombre, String apellido, double salario, int departamentoId){
        String sql = "INSERT INTO empleados VALUES (" + nombre + ","+apellido+","+salario+","+departamentoId+")";

        try (Connection conn = ej1_ConexionBaseDatos.getConnection();
             Statement stm = conn.createStatement();){
            int filasAfectadas = stm.executeUpdate(sql);
            System.out.println("Las filas afectadas son " + filasAfectadas);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // listarEmpleados()
    public void listarEmpleados(){
        String sql = "SELECT * FROM empleados";
        try (Connection conn = ej1_ConexionBaseDatos.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(sql)){
            while (rs.next()){
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                double salario = rs.getDouble("salario");
                int departamentoId = rs.getInt("departamentoId");
                System.out.println("Nombre:"+nombre+"\nApellido:"+apellido+"\nSalario:"+salario+"\nDepartamentoID: "+departamentoId);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    // actualizarSalario(int id, double nuevoSalario)
    public void actualizarSalario(int id, double nuevoSalario){
        String sql = "UPDATE empleados SET salario="+nuevoSalario+" WHERE id="+id;
        try(Connection conn = ej1_ConexionBaseDatos.getConnection();
            Statement stm = conn.createStatement();){
            int  filasAfectadas = stm.executeUpdate(sql);
            System.out.println("Las filas afectadas son " + filasAfectadas);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    // eliminarEmpleado(int id)
    public void eliminarEmpleado(int id){
        String sql = "DELETE FROM empleados WHERE id="+id;
        try(Connection conn = ej1_ConexionBaseDatos.getConnection();
            Statement stm = conn.createStatement();){
            int  filasAfectadas = stm.executeUpdate(sql);
            System.out.println("Las filas afectadas son " + filasAfectadas);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
