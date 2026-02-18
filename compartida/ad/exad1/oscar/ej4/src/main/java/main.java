import java.io.IOException;
import java.sql.*;

public class main {
    //variables para acceder a la base de datos
    private static final String url ="jdbc:postgresql://localhost:5432/Pedidos";    // NO EXISTE Pedidos, pedidos SI
    private static final String user ="root";
    private static final String password ="root";
    public static void main(String[] args) {
        String sql = "SELECT * FROM categorias WHERE categoriaid < ?"; //sentencia ql
        try(Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement ps = conn.prepareStatement(sql); //como debe ser parametrizada hacemos preparedStametn
                ){
            int categoria = 500; // declaramos la categoria que vamos a comparar
            ps.setInt(1, categoria); // la ponemos como parametro en el resulSet
            ResultSet rs = ps.executeQuery(); // ejecutamos la sentencia  y guardamos el valor en el result set
            System.out.println("Categorias con id menor que 500");
            while(rs.next()){ //bucle para que lea los datps
                int cid = rs.getInt("categoriaid");
                String nombre = rs.getString("nombrecat");
                System.out.println(cid+" "+nombre);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    /*
    * 6.
El patron MVC es un patron que se basa en tres elementos claves y su objetivo principal es lograr separar la parte grafica con la que puede interactuar el usuario con la parte relacionada al acesso a datos esto tambien incluye los ficheros java, etc...
Los tres elementos que componen este patron son:
Modelo: Basicamente es la estructura de todo el patron aquí se almacenan todo lo relacionado al acceso a datos aislado del usuario.
Vista: basicamente es la parte grafica del modelo es decir donde aparecen los botones para hacer ciertas acciones, etc ...
Controlador: Este elemento es el que conecta el modelo y la vista basicamente si ha la vista se le pulsa un boton el controlador le envia una señal al modelo que realiza la accion de por ejemplo acceder a la base de datos y hacer algo.


7.La diferencia principal entre ambos bufferes es que el buffer directo necesita tener el documento completamente almacenado en la memoria nativa y por tanto funciona mas rapido pero consume mucho mas es mejor solo utilizarlo en casos donde sea necesario la velocidad.
En clase hemos usado el indirecto ya que usamos el metodo allocate() y para usar los directos debemos usar el metodo allocateDirect() y como no necesitamos mucha velocidad para los ejemplos nos sirve
    * */
}
