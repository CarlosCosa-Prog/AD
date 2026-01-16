package com.jossanbro;


import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ej3 {

    public static void main(String[] args) throws SQLException {

        final String jdbcurl = "jdbc:postgresql://localhost:5432/pedidos";
        final String user = "root";
        final String pwd = "root";

        String sql = "select * from categorias where categoriaId < ? ";

        try (Connection con = DriverManager.getConnection(jdbcurl, user, pwd)) {
            System.out.println("¡Estamos dentro!");
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, 500);
            ResultSet rs = cs.executeQuery();
            //PreparedStatement stmt = con.prepareStatement(sql);
            //ResultSet rs = stmt.executeQuery();
            //Statement stmt = con.createStatement();
            //System.out.println(ResultSet rs = stmt.executeQuery(sql));



        }

    }

}

/*
5.(1 punto). Que problema de seguridad tiene la interfaz Statement que corrija Prepared Statement? Explica brevemente en qué consiste el problema

    -Cuando se usa Statement, las consultas SQL se construyen concatenando cadenas con datos proporcionados por el usuario,
    por lo que es posible la inyección intencional o no intencional de scripts que alteren la base de datos, ya sea por error
    o con intenciones malignas.

    -PreparedStatement corrije este problema introduciendo sentencias SQL con estructuras previamente configuradas como parámetro.



7.(1 punto). Explica la diferencia entre los búferes directos y los no directos de ByteBuffer.
Indica cuáles hemos utilizado en clase.

    -En clase hemos utilizado los bufferes no directos, se inicializan de la siguiente forma:

            - ByteBuffer BufferNoDirecto = ByteBuffer.allocate() //pasandole como parámetro la longitud que queremos darle

    Frente a los bufferes directos:

            -ByteBuffer BufferDirecto = ByteBuffer.allocateDirect()


    -Los Bufferes no directos son más rápidos ya que se alojan en la JVM. Los Directos se alojan
    en memoria por lo que son más costosos de crear y destruir.
 */
