package org.cosa;

public class App 
{
    public static void main( String[] args ){
        Conexion.probarConexion();
        // Sentencias sql simples
        SentenciasSQL.insertarEmpleado("Antonio","Cosa",2000,10);
        SentenciasSQL.modificarSalario(3, 1500);
        SentenciasSQL.eliminarEmpleado(1);
        SentenciasSQL.listarEmpleado();

        // Sentencias SQL Actualizables con ResultSet
        ConsultasUpdatable.actualizarSalarioResultSet();
        ConsultasUpdatable.insertarEmpleadoResultSet();
        ConsultasUpdatable.eliminarEmpleadoResultSet(6);
        SentenciasSQL.listarEmpleado();

        // TRANSACCIONES
        Transacciones.tranferirDatos(2,3,500);
        SentenciasSQL.listarEmpleado();

    }
}
