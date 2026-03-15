package org.cosa;


public class App 
{
    public static void main( String[] args )
    {
        Conexion.probarConexion();
        /*Ejercicio3.insertarCategoria("Categoria 1", 465);
        Ejercicio3.insertarCategoria("Categoria 2", 350);
        Ejercicio3.insertarCategoria("Categoria 3", 600);
        Ejercicio3.insertarCategoria("Categoria 4", 500);*/
        Ejercicio3.listarCategorias();
        System.out.println();
        Ejercicio3.mostrarCategoriaId(500);
    }
}
