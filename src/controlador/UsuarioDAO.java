package controlador;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;
import vista.UsuarioRegistrado;

/**
 *
 * @author laura
 */
public class UsuarioDAO {

    //Creamos la conexión
    private Conexion conexion = new Conexion();

    //Permite agregar nuevos Usuarios en nustra base de datos
    public boolean agregarUsuario(Usuario usuarios) throws SQLException {

        boolean fueAgregado = false;

        Connection conn = conexion.conectar();

        try {

            String sql = "insert into usuarios (nombre_usuario, email, telefono, username, pass, tipo_nivel, estatus, registrado_por) values (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuarios.getNombre());
            stmt.setString(2, usuarios.getEmail());
            stmt.setString(3, usuarios.getTelefono());
            stmt.setString(4, usuarios.getUsername());
            stmt.setString(5, usuarios.getPassword());
            stmt.setString(6, usuarios.getTipo_nivel());
            stmt.setString(7, usuarios.getEstatus());
            stmt.setString(8, usuarios.getRegistrado());

            // ejecutar sentencia
            int cantidad = stmt.executeUpdate();

            fueAgregado = (cantidad > 0);

        } catch (Exception e) {

            System.out.println("Error al agregar usuario " + e.getMessage());

        } finally {

            conn.close();

        }
        return fueAgregado;
    }

    //Comprobamos si exite un usuario registrado con ese Username
    public boolean existeUsuario(String Username) throws SQLException {

        boolean Existe = false;

        Connection conn = conexion.conectar();

        try {
            String username = "";
            String sql = "select username from usuarios where username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Username);

            // ejecutar sentencia
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                username = rs.getString("username");
            }

            if (username.isEmpty()) {
                Existe = false;

            } else {

                Existe = true;

            }

        } catch (Exception e) {

            System.out.println("Error al seleccionar usuario " + e.getMessage());

        } finally {

            conn.close();

        }
        return Existe;
    }

    //Comprobamos si ha sido asignado ese permiso con anterioridad
    public boolean existePermiso(String Permiso) throws SQLException {

        boolean Existe = false;

        Connection conn = conexion.conectar();

        try {
            String permiso = "";
            String sql = "select tipo_nivel from usuarios where tipo_nivel = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Permiso);

            // ejecutar sentencia
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                permiso = rs.getString("tipo_nivel");
            }

            if (permiso.isEmpty()) {
                Existe = false;

            } else {

                Existe = true;

            }

        } catch (Exception e) {

            System.out.println("Error al seleccionar permiso " + e.getMessage());

        } finally {

            conn.close();

        }
        return Existe;
    }

    //Crea un listado de todos los usuarios registrados en nuestra base de datos
    public ArrayList<Usuario> listadoUsuarios() throws SQLException {

        ArrayList<Usuario> usuario = new ArrayList();
        Connection conn = conexion.conectar();

        try {
            String sql = "select * from usuarios";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Extraigo datos
                Usuario u = new Usuario();
                u.setId(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre_usuario"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("pass"));
                u.setEstatus(rs.getString("estatus"));
                usuario.add(u);

            }

        } catch (Exception e) {
            System.out.println("Error lista usuarios: " + e.getMessage());
        } finally {
            conn.close();
        }
        return usuario;
    }

    //Crea un listado de los datos del usuario registrado con ese ID
    public ArrayList<Usuario> listarUsuarios() throws SQLException {

        ArrayList<Usuario> usuario = new ArrayList();
        Connection conn = conexion.conectar();

        try {
            String sql = "select * from usuarios where id_usuario = '" + UsuarioRegistrado.user_update + "'";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Extraigo datos
                Usuario u = new Usuario();
                u.setId(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre_usuario"));
                u.setEmail(rs.getString("email"));
                u.setTelefono(rs.getString("telefono"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("pass"));
                u.setTipo_nivel(rs.getString("tipo_nivel"));
                u.setEstatus(rs.getString("estatus"));
                u.setRegistrado(rs.getString("registrado_por"));
                usuario.add(u);

            }

        } catch (Exception e) {
            System.out.println("Error lista usuarios: " + e.getMessage());
        } finally {
            conn.close();
        }
        return usuario;
    }

    //Permite actualizar los datos del usuario registrado en la base de datos
    public boolean actualizarUsuario(Usuario usuario) throws SQLException {

        boolean fueActualizado = false;

        Connection conn = conexion.conectar();

        try {

            String sql = "update usuarios set nombre_usuario = ?, email = ?, telefono = ?, username = ?, tipo_nivel = ?, estatus = ?, registrado_por = ? where id_usuario = '" + UsuarioRegistrado.user_update + "'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefono());
            stmt.setString(4, usuario.getUsername());
            stmt.setString(5, usuario.getTipo_nivel());
            stmt.setString(6, usuario.getEstatus());
            stmt.setString(7, usuario.getRegistrado());

            // ejecutar sentencia
            int cantidad = stmt.executeUpdate();

            fueActualizado = (cantidad > 0);

        } catch (Exception e) {

            System.out.println("Error al actualizar usuario " + e.getMessage());

        } finally {

            conn.close();

        }
        return fueActualizado;
    }

    //Permite actualizar el Password del usuario en nuestra base de datos
    public boolean actualizarPassword(Usuario usuario) throws SQLException {

        boolean fueActualizado = false;

        Connection conn = conexion.conectar();

        try {

            String sql = "update usuarios set pass = ? where id_usuario = '" + UsuarioRegistrado.user_update + "'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getPassword());

            // ejecutar sentencia
            int cantidad = stmt.executeUpdate();

            fueActualizado = (cantidad > 0);

        } catch (Exception e) {

            System.out.println("Error al actualizar password " + e.getMessage());

        } finally {

            conn.close();

        }
        return fueActualizado;
    }

    //Permite el acceso si el Password y el Username coinciden con los de la base de datos
    public boolean permitirAcceso(String Username, String Pass) throws SQLException {

        boolean Acceso = false;

        Connection conn = conexion.conectar();

        try {
            String pass = "";
            String username = "";
            String sql = "select username, pass from usuarios where username = ? and pass = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Username);
            stmt.setString(2, Pass);

            // ejecutar sentencia
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                username = rs.getString("username");
                pass = rs.getString("pass");
            }

            if ((pass.isEmpty()) || (username.isEmpty())) {
                Acceso = false;

            } else {

                Acceso = true;

            }

        } catch (Exception e) {

            System.out.println("Error al permitir acceso " + e.getMessage());

        } finally {

            conn.close();

        }
        return Acceso;
    }
}
