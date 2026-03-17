package org.cosa;

public class App 
{
    public static void main( String[] args )
    {
        Conexion.probarConexion();
        ejercicio4A.insertarTransaccion("prueba1",545,"prueba2",454);
        ejercicio4B.mostrarCategorias(500);
    }
}
