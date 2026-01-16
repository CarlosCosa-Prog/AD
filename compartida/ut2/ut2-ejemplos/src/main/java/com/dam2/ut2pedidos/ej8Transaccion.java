package com.dam2.ut2pedidos;

import java.sql.*;

// IGUAL PERO CON PREPAREDSTATEMENT
public class ej8Transaccion
{

    public static void main(String args[])
    {
        //Connection conexion;
            System.out.println("Conectando con la Base de datos...");
            String jdbcUrl = "jdbc:postgresql://localhost:5432/pedidos";
        
       String descripcionProducto = "salsa de pisto";
       float preciounit = 1.8f;
       int idProveedor=10, idCategoria = 100, existencias =10;
       // El id del producto que vamos a registrar aún no se conoce

       String sqlAltaProducto = "INSERT INTO productos (productoid,proveedorid,categoriaid,descripcion, preciounit,existencia) VALUES (14," + idProveedor + "," + idCategoria + ",'" + descripcionProducto +"'," + preciounit + "," + existencias +")";
        idCategoria = 800;
        String nomCateg = "deportes";
       String sqlAltaCategoria = 
              "INSERT INTO categorias(categoriaid, nombrecat) " + "VALUES (" + idCategoria + ",'" + nomCateg + "')";
                                     
       try ( Connection conexion =  DriverManager.getConnection(jdbcUrl,"root","root");
             Statement sentencia = conexion.createStatement();)
       {
           ResultSet idGenerados=null;
         //Inicia transacción
           try {
               // iniciamos transacción
               conexion.setAutoCommit(false);
               // 1ª operación
               sentencia.executeUpdate(sqlAltaProducto);

               // Obtiene el id del producto que se acaba de registrar
/*               idGenerados = sentencia.getGeneratedKeys();
               idGenerados.next();
               int idProducto = idGenerados.getInt(1);
               //System.out.println("El identificador del producto añadido es " + idProducto);
               idGenerados.close();
               sentencia.close();*/
                // 2ª operación
               sentencia.executeUpdate(sqlAltaCategoria);

               // Valida la transacción
               conexion.commit();
               conexion.setAutoCommit(true);
           }
           catch (SQLException e)
           {
               conexion.rollback();
               conexion.setAutoCommit(true);
               if (idGenerados != null)
                   idGenerados.close();
               System.out.println(e.getMessage());
           }
       } catch (SQLException sqle) {

       }
    }
}
