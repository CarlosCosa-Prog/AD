package com.dam2;
import java.sql.*;
/*4. ResultSet Actualizable. Haz una clase ConsultasUpdatable que incluya:
	- void actualizarSalariosViaResultSet(), incrementará un 10% cada salario inferior a 30000 euros usando updateRow()
	- void insertarEmpleadoViaResultSet(), insertará un nuevo empleado usando moveToInsertRow()
	- void eliminarEmpleadoViaResultSet(int id), eliminará un empleado usando deleteRow()*/

public class ej4_ConsultasUpdatable {
    // void actualizarSalariosViaResultSet(), incrementará un 10% cada salario inferior a 30000 euros usando updateRow()
    public void actualizarSalariosViaResultSet(){
        String sql =  "SELECT id, nombre, apellido, salario FROM empleados WHERE salario < 30000";
    }
}
