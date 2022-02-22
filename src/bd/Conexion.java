
package bd;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author laura
 */
public class Conexion {

    // Declaramos variables
    private Connection conexion;

    private String host = "localhost:33065";
    private String usuario = "root";
    private String password = "";
    private String nombreBD = "equipo_tec";

    private String url = "jdbc:mysql://" + host + "/" + nombreBD;

    public Connection conectar() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Nos conectamos a la base de datos
            this.conexion = DriverManager.getConnection(this.url, this.usuario, this.password);

        } catch (Exception e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return this.conexion;
    }
}
