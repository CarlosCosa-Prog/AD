package org.cosa;


public class App 
{
    public static void main( String[] args )
    {
        Conexion.probarConexion();
        Ejercicio3.mostrarCategorias();
        Ejercicio3.insertarTransaccion("prueba1",788,"prueba2",55);
        System.out.println();
        Ejercicio3.mostrarCategorias();
    }
}
