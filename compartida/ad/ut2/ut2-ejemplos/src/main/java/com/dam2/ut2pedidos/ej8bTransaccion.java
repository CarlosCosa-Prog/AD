package com.dam2.ut2pedidos;

import java.sql.*;

// IGUAL PERO CON PREPAREDSTATEMENT
public class ej8bTransaccion
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

       String sqlAltaProducto = "INSERT INTO productos (productoid,proveedorid,categoriaid,descripcion, preciounit,existencia) VALUES (?,?, ?,?, ?,?)";
       String sqlAltaCategoria = 
              "INSERT INTO categorias(categoriaid, nombrecat) " + "VALUES (?, ?)";
                                     
       try ( Connection conexion =  DriverManager.getConnection(jdbcUrl,"root","root"); )
       {
           ResultSet idGenerados=null;
         //Inicia transacción
           try {
               conexion.setAutoCommit(false);

               PreparedStatement sentencia = conexion.prepareStatement(sqlAltaProducto, PreparedStatement.RETURN_GENERATED_KEYS);
               sentencia.setInt(1, 14);
               sentencia.setInt(2, idProveedor);
               sentencia.setInt(3, idCategoria);
               sentencia.setString(4, descripcionProducto);
               sentencia.setFloat(5, preciounit);
               sentencia.setInt(6, existencias);
               sentencia.executeUpdate();

               // Obtiene el id del producto que se acaba de registrar
/*               idGenerados = sentencia.getGeneratedKeys();
               idGenerados.next();
               int idProducto = idGenerados.getInt(1);
               //System.out.println("El identificador del producto añadido es " + idProducto);
               idGenerados.close();
               sentencia.close();*/

               PreparedStatement sentencia2 = conexion.prepareStatement(sqlAltaCategoria);
               idCategoria = 800;
               String nomCateg = "deportes";
               sentencia2.setInt(1, idCategoria);
               sentencia2.setString(2, nomCateg);
               sentencia2.executeUpdate();
               // Valida la transacción
               conexion.commit();
               sentencia.close();
               sentencia2.close();
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
