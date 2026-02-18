package org.example;

import java.sql.*;

public class ex4 {
    // Parametro pedido al usuario: 500
    public static void main(String[] args) {
        // Nos conectamos a la BBDD de pedidos con el usuario y contraseña root
        try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos","root","root");
            Statement stmt = con.createStatement();
            // ERA CONSULTA PARAMETRIZADA (AMB PREPARED STATEMENT)
            // Creamos la consulta que nos mostrará la id y el nombre de las categorias con id menor al parametro ofrecido por el usuario
            ResultSet rs = stmt.executeQuery("select * from categorias where categoriaId < " + args[0]);){
            System.out.println("Iniciando conexion");

            // Aqui mostrara el id y el nombre de las categorias consultadas
            while(rs.next()){
                System.out.println("Id: "+rs.getInt("categoriaid") +
                        "\nNombre: "+rs.getString("nombrecat") + "\n"
                        );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
*  TEORIA:
*
* 7.
* La diferencia entre los 2 búferes es que el búfer directo tienes que indicarle en que espacio de memoria quieres que este, a diferencia de los no directos que no tienes que indicarselo y lo hace automaticamente.
* En clase hemos estado usando ByteBuffer e IntBuffer.
* */
