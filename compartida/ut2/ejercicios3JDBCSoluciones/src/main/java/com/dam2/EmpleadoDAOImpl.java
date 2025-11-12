package com.dam2;

import java.sql.*;

public class EmpleadoDAOImpl implements EmpleadoDAO {
    @Override
    public void insert(Empleado empleado) {
        Connection con = null;
        try {
// abrir la conexion
            con = ConexionBaseDatos.getConexion();
            try (Statement stmt = con.createStatement()) {
// enviar el commando insert
                stmt.executeUpdate("insert into empleados values ("
                        + empleado.getId() + ",'"
                        + empleado.getNombre() + "',"
                        + empleado.getApellido() + "',"
                        + empleado.getSalario() + "','"
                        + empleado.getDptmtId() + ");"
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Empleado empleado) {
        Connection con = null;
        try {
// abrir la conexion
            con = ConexionBaseDatos.getConexion();
            try (Statement stmt = con.createStatement()) {
// enviar el commando insert
                stmt.executeUpdate("update into empleados values ("
                        + empleado.getNombre() + "',"
                        + empleado.getApellido() + "',"
                        + empleado.getSalario() + "','"
                        + empleado.getDptmtId() + " where id =" + empleado.getId() + ");"
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(Integer id) {
        Connection con = null;
        try {
// abrir la conexion
            con = ConexionBaseDatos.getConexion();
            try (Statement stmt = con.createStatement()) {
// enviar el commando insert
                stmt.executeUpdate("delete from empleados where id = " + id + ");"
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Empleado read(Integer id) {
        Connection con = null;
        Empleado empleado = null;
        try {
// abrir la conexion
            con = ConexionBaseDatos.getConexion();
// consulta select (selecciona el empleado con ID especificado)
            try (PreparedStatement ps = con.prepareStatement(
                    "select * from empleados where id = ?")) {
// indicar el ID que buscamos
                ps.setInt(1, id);
// ejecutar la consulta
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
// obtener cada columna y mapearlas a la clase Empleado
                        empleado = new Empleado(rs.getString("nombre"), rs.getString("apellido"),
                                rs.getDouble("salario"), rs.getInt("departamento_id"));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return empleado;
    }
}
