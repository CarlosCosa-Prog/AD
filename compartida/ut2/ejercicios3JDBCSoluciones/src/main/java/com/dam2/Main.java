package com.dam2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Probar la conexión a PostgreSQL
        ConexionBaseDatos.probarConexion();

        // Probar CRUD con Statement
        EmpleadosCRUD ec = new EmpleadosCRUD();
        ec.listarEmpleados();
        ec.insertarEmpleado("Ana", "Garcia", 28000, 2);

        // Probar ResultSet no actualizable
        Consultas consultas = new Consultas();
        consultas.navegarResultSetForward();
        consultas.navegarResultSetScrollable();

        // Probar ResultSet actualizable
        ConsultasUpdatable cu = new ConsultasUpdatable();
        cu.actualizarSalariosViaResultSet();
        cu.insertarEmpleadoViaResultSet();

        // Probar transacciones
        Transacciones transacciones = new Transacciones();
        transacciones.transferirSalario(1, 2, 1000);
        transacciones.actualizacionMasivaSalarios();

        // Probar PreparedStatement
        EmpleadosPreparedStatement eps = new EmpleadosPreparedStatement();
        Empleado empleado = new Empleado("Carlos", "Martinez", 32000, 1);
        eps.insertarEmpleadoPrepared(empleado);
        eps.buscarEmpleadosPorDepartamento(1);

        // Probar batch insert
        List<Empleado> nuevosEmpleados = Arrays.asList(
                new Empleado("Maria", "Lopez", 29000.0, 2),
                new Empleado("Pedro", "Rodriguez", 31000.0, 1),
                new Empleado("Laura", "Sanchez", 27000.0, 3)
        );
        eps.insercionMasivaEmpleados(nuevosEmpleados);

        // Probar funciones específicas de PostgreSQL
        FuncionalidadesVarias funcionesPG = new FuncionalidadesVarias();
        funcionesPG.listarEmpleadosActivos();
        funcionesPG.obtenerSalarioPromedioDepartamento(1);
        funcionesPG.ejecutarAumentoSalarial(2, 5.0); // 5% de aumento
        funcionesPG.usarTiposPostgreSQL();
    }
}
