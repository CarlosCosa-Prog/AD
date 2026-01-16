package org.example;

import java.sql.*;
import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try{

            //Hacemos la sentencia y la conexion dentro de un try anidado para que nos deje hacer el commit.
            String sql = "INSERT INTO categorias (categoriaid, nombrecat) VALUES (?,?)";
            Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos", "root", "root");
            //Establecemos el autocommit a false porque por defecto esta a true.
            conexion.setAutoCommit(false);

            //EN este caso uso scroll sensitive y updatable para que me guarde y haga cambios en las tablas.
            try{

                PreparedStatement ps = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);


                //Le pedimos al usuario 2 veces que introduzca los datos que quiere insertar.
                System.out.println("Introduzca el ID de la categoria : ");
                int num = sc.nextInt();
                System.out.println("Introduzca el nombre de la categoria : ");
                String nombrecat = sc.next();

                ps.setInt(1, num);
                ps.setString(2, nombrecat);
                ps.executeUpdate();

                System.out.println("Introduzca el segundo ID de la categoria 2 a añadir : ");
                int num2 = sc.nextInt();
                System.out.println("Introduzca el segundo nombre de la categoria 2 a añadir : ");
                String nombrecat2 = sc.next();

                ps.setInt(1, num2);
                ps.setString(2, nombrecat2);
                ps.executeUpdate();

                //Hacemos el commit para que los cambios se hagan
                conexion.commit();


            }catch(Exception e){
                //Hacemos rollback para que vuelva si falla algo al inicio
                conexion.rollback();
                e.printStackTrace();
            }finally{
                conexion.setAutoCommit(true);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

//RESPUESTA DE LAS PREGUNTAS TEORICAS
/*

2-Los parametros para distintas posiciones que se usan sobretodo en el Búfer son :
mark: Establecemos una especie de punto guardado en una parte de el recorrido de el buffer, es decir que guardamos la posicion actual del bufer para usarla posteriormente.
reset: Este parametro nos permite volver al mark(), es el que indica que debe volver al mark utilizado anteriormente.
flip: Flip nos prepara para escribir a un fichero, cuando esta lleno el buffer, establece el limite donde haya quedado la posicion del buffer si le introducimos 20 pues su limite será 20 porque estaba la posición ahí, y la posición la devuelve a 0.
rewind: Nos prepara para leer en este caso se utilizaría mas o menos igual que el flip, no obstante rewind es como rebobinar por lo que cuando se utiliza devuelve la posicion 0 por igual pero el limite en este caso será el tamaño del buffer en .allocate().


3-La diferencia entre los Búferes directos y no directos es : Los directos tratan directamente con el sistema de archivos haciendo asi que su manejo sea más peligroso, sirve sobretodo para cuando hacemos un gran manejo de datos que son muy pesados.
Los no directos que son los que hemos usado en clase, trabajan con una reserva de memoria en la máquina virtual, por lo que no son tan peligrosos como los directos, por ello para cargas de trabajo de manipulación de datos ligeros es más recomendable usar los no directos.
*/