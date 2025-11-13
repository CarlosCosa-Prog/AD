package com.dam2;


import static com.dam2.consulta1Forward.consultaResulSetForward;
import static com.dam2.consulta2Scrolleable.consultaResulsetScrolleble;
import static com.dam2.consulta3Actualizable.actualizarSalario;
import static com.dam2.consulta3Actualizable.insertarUsuario;
import static com.dam2.ejercicio1conexion.probarConexion;

public class principal
{
    public static void main( String[] args )
    {
        probarConexion();
        consultaResulSetForward();
        //consultaResulsetScrolleble();
        //actualizarSalario();
        //insertarUsuario();
    }
}
