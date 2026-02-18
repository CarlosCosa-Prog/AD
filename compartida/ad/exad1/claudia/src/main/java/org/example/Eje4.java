package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Eje4 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/pedidos";
        String user = "root";
        String password = "root";
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);
        String sql = "INSERT INTO categorias(categoriaid,nombrecat) VALUES(?,?)";
        int id;
        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            System.out.println("Ingrese el id de la primera categoria: ");
            id = sc.nextInt();
            pstmt.setInt(1, id);
            pstmt.setString(2, "deportesxx");
            pstmt.executeUpdate();
            System.out.println("Ingrese el id de la segunda categoria: ");
            id = sc.nextInt();
            pstmt.setInt(1, id);
            pstmt.setString(2, "parafarmacia");
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            System.out.println("Transación finalizada con exito");

        } catch (SQLException e) {
            System.out.println("Problema al cargar los datos. Se hace el rollback");
            e.printStackTrace();
            // EN ESTE CASO TAMBIÉN SE HA DE PONER EL AUTOCOMMIT A TRUE NUEVAMENTE
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        }

    }
}

/*RESPUESTAS A LAS PREGUNTAS
5. DAO es un padrón de programación que tiene como objetivo separar la capa o clases de definición de los objetos de la capa/clases de conexión con la base y manipulación de los objetos. Por ejemplo, si los objetos son definidos en una clase empleados, los métodos de manipulación en una clase EmpleadosDAOCRUD. Para implementar se crea una interface solo con las definiciones de los métodos de manipulacion. En seguida se crea una clase que implementa esa interface donde serán desarrollados los métodos definidos en la interface. Las ventajas de utilizar ese padrón es por adquirir seguridad y agilidad en el mantenimiento del programa, porque si hay alteraciones en la forma de manipular los datos solamente esas clases serán alteradas. Al igual que se cambia el gestor de base de datos, solamente la clase responsable por la conexión serán alteradas.

7. Los buferes directos trabajan directamente con la memoria nativa del sistema operacional. Son mas rápidos pero mas costosos de implementar. Solo está indicado para utilizar con operaciones masivas de I/O o de redes.
Los búferes no directos acceden a la memoria de la maquina java, como los demás objetos. Es lo mas indicado para operaciones menores y es el que estamos utilizando en clase.
* */

