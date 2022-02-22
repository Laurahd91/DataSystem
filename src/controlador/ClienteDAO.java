
package controlador;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
import vista.ClienteRegistrado;
import vista.EquipoRegistrado;

/**
 *
 * @author laura
 */
public class ClienteDAO {

    //Creamos la conexión
    private Conexion conexion = new Conexion();

    //Permite agregar nuevos Clientes en nustra base de datos
    public boolean agregarCliente(Cliente clientes) throws SQLException {

        boolean fueAgregado = false;

        Connection conn = conexion.conectar();

        try {

            String sql = "insert into clientes (nombre_cliente, email_cliente, tel_cliente, direc_cliente, ultima_modificacion) values (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, clientes.getNombre());
            stmt.setString(2, clientes.getEmail());
            stmt.setString(3, clientes.getTelefono());
            stmt.setString(4, clientes.getDireccion());
            stmt.setString(5, clientes.getModificacion());

            // ejecutar sentencia
            int cantidad = stmt.executeUpdate();

            fueAgregado = (cantidad > 0);

        } catch (Exception e) {

            System.out.println("Error al agregar cliente " + e.getMessage());

        } finally {

            conn.close();

        }
        return fueAgregado;
    }

    //Comprueba si hay un cliente guardado con ese email
    public boolean existeCliente(String Email) throws SQLException {

        boolean Existe = false;

        Connection conn = conexion.conectar();

        try {
            String email = "";
            String sql = "select email_cliente from clientes where email_cliente  = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Email);

            // ejecutar sentencia
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                email = rs.getString("email_cliente");
            }

            if (email.isEmpty()) {
                Existe = false;

            } else {

                Existe = true;

            }

        } catch (Exception e) {

            System.out.println("Error al seleccionar cliente " + e.getMessage());

        } finally {

            conn.close();

        }
        return Existe;
    }

    //Crea un listado de clientes tras consultar la base de datos
    public ArrayList<Cliente> listadoClientes() throws SQLException {

        ArrayList<Cliente> cliente = new ArrayList();
        Connection conn = conexion.conectar();

        try {
            String sql = "select * from clientes";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Extraigo datos
                Cliente c = new Cliente();
                c.setId(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre_cliente"));
                c.setEmail(rs.getString("email_cliente"));
                c.setTelefono(rs.getString("tel_cliente"));
                c.setModificacion(rs.getString("ultima_modificacion"));
                cliente.add(c);

            }

        } catch (Exception e) {
            System.out.println("Error lista clientes: " + e.getMessage());
        } finally {
            conn.close();
        }
        return cliente;
    }

    //Busca el cliente correspondiente a un ID
    public ArrayList<Cliente> buscarId() throws SQLException {

        ArrayList<Cliente> cliente = new ArrayList();
        Connection conn = conexion.conectar();

        try {
            String sql = "select * from clientes where id_cliente = '" + ClienteRegistrado.user_update + "'";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Extraigo datos
                Cliente c = new Cliente();
                c.setId(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre_cliente"));
                c.setEmail(rs.getString("email_cliente"));
                c.setTelefono(rs.getString("tel_cliente"));
                c.setDireccion(rs.getString("direc_cliente"));
                c.setModificacion(rs.getString("ultima_modificacion"));
                cliente.add(c);

            }

        } catch (Exception e) {
            System.out.println("Error lista clientes: " + e.getMessage());
        } finally {
            conn.close();
        }
        return cliente;
    }

    //Permite actualizar la tabla clientes en nuestra base de datos
    public boolean actualizarCliente(Cliente cliente) throws SQLException {

        boolean fueActualizado = false;

        Connection conn = conexion.conectar();

        try {

            String sql = "update clientes set nombre_cliente = ?, email_cliente = ?, tel_cliente = ?, direc_cliente = ?, ultima_modificacion = ? where id_cliente = '" + ClienteRegistrado.user_update + "'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getDireccion());
            stmt.setString(5, cliente.getModificacion());

            // ejecutar sentencia
            int cantidad = stmt.executeUpdate();

            fueActualizado = (cantidad > 0);

        } catch (Exception e) {

            System.out.println("Error al actualizar cliente " + e.getMessage());

        } finally {

            conn.close();

        }
        return fueActualizado;
    }

    //Busca el nombre del cliente según el ID de Equipo  
    public ArrayList<Cliente> buscarCliente() throws SQLException {

        ArrayList<Cliente> cliente = new ArrayList();
        Connection conn = conexion.conectar();

        try {
            String sql = "select clientes.nombre_cliente, clientes.id_cliente, equipos.id_equipo, equipos.id_cliente from clientes inner join equipos on clientes.id_cliente = equipos.id_cliente where id_equipo = '" + EquipoRegistrado.user_update + "'";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Extraigo datos
                Cliente c = new Cliente();
                c.setNombre(rs.getString("nombre_cliente"));
                cliente.add(c);

            }

        } catch (Exception e) {
            System.out.println("Error lista clientes: " + e.getMessage());
        } finally {
            conn.close();
        }
        return cliente;
    }
}
