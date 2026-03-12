package org.cosa;
import java.sql.*;
public class ConsultasUpdatable {

    // Actualiza los salarios de los empleados menores a 2000
    public static void actualizarSalarioResultSet(){
        String sql = "SELECT id, nombre, apellido, salario FROM empleados WHERE salario < 2000";

        // creo un ResultSet que puede hacer todo tipo de movimientos, es consciente de los cambios
        // y pude modificar el contenido del mismo mientras está abierto
        try (Connection conn = Conexion.getConexion();
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery(sql);) {
            System.out.println("Actualizando salarios < a 2000");

            while (rs.next()) {
                double salarioActual = rs.getDouble("salario");
                double nuevoSalario = salarioActual + 150;

                // modifica el salario de tipo double
                rs.updateDouble("salario", nuevoSalario);
                rs.updateRow(); // hace efectiva la operación
                System.out.println("Empleados: " + rs.getString("nombre") + "\nSalario anterior: " + salarioActual + " Salario nuevo: " + rs.getDouble("salario"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // Insertar una nueva fila
    public static void insertarEmpleadoResultSet(){
        String sql = "SELECT id, nombre, apellido, salario, departamento_id FROM empleados";

        try(Connection conn = Conexion.getConexion();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)) {
            ResultSet rs = stmt.executeQuery(sql);
            // 1. mueve el cursor
            rs.moveToInsertRow();

            // 2. establece los valores de la fila a insertar
            String nombre = "Manolo";
            rs.updateString("nombre", nombre);
            rs.updateString("apellido", "El del bomboclap");
            rs.updateInt("salario", 150);
            rs.updateInt("departamento_id", 1);

            // 3. inserta la fila
            rs.insertRow();

            // 4. Vuelve a la posición actual
            rs.moveToCurrentRow();

            System.out.println("Empleado " + nombre + " insertado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Eliminar empleado por id
    public static void eliminarEmpleadoResultSet(int id){
        String sql = "SELECT * FROM empleados WHERE id =" + id;

        try (Connection conn = Conexion.getConexion();
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery(sql);) {

            if (rs.next()) {
                rs.deleteRow();
                System.out.println("Empleado " + id + " eliminado correctamente");
            }else
                System.out.println("No existe el empleado " + id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
