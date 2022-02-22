
package controlador;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Equipo;
import vista.ClienteRegistrado;
import vista.EquipoRegistrado;

/**
 *
 * @author laura
 */
public class EquipoDAO {

    //Declaramos variables
    static String cliente = "";

    //Creamos la conexión
    private static Conexion conexion = new Conexion();

    //Comprobamos si exite un cliente registrado con ese Nombre
    public boolean existeNombre(String Nombre) throws SQLException {

        boolean Existe = false;

        Connection conn = conexion.conectar();

        try {
            String nombre = "";
            String sql = "select nombre_cliente from clientes where nombre_cliente = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Nombre);

            // ejecutar sentencia
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("nombre_cliente");
            }

            if (nombre.isEmpty()) {
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

    //Buscamos el ID del cliente según el nombre introducido
    public static String buscarId(String Nombre) throws SQLException {

        Connection conn = conexion.conectar();

        try {
            String sql = "select id_cliente from clientes where nombre_cliente  = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Nombre);

            // ejecutar sentencia
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Extraigo datos
                cliente = String.valueOf(rs.getInt("id_cliente"));
            }

        } catch (Exception e) {

            System.out.println("Error al seleccionar cliente " + e.getMessage());

        } finally {

            conn.close();

        }
        return cliente;
    }

    //Permite agregar un nuevo equipo a nuestra base de datos
    public boolean agregarEquipo(Equipo equipos) throws SQLException {

        boolean fueAgregado = false;

        Connection conn = conexion.conectar();

        try {

            String sql = "insert into equipos (id_cliente, tipo_equipo, marca, modelo, num_serie, dia_ingreso, mes_ingreso, annio_ingreso, observaciones, estatus, ultima_modificacion, comentarios_tecnicos, revision_tecnica) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, equipos.getId_cliente());
            stmt.setString(2, equipos.getTipo_equipo());
            stmt.setString(3, equipos.getMarca());
            stmt.setString(4, equipos.getModelo());
            stmt.setString(5, equipos.getNum_serie());
            stmt.setString(6, equipos.getDia_ingreso());
            stmt.setString(7, equipos.getMes_ingreso());
            stmt.setString(8, equipos.getAnyo_ingreso());
            stmt.setString(9, equipos.getObservaciones());
            stmt.setString(10, equipos.getEstatus());
            stmt.setString(11, equipos.getUltima_modificacion());
            stmt.setString(12, equipos.getComentarios_tecnicos());
            stmt.setString(13, equipos.getRevision_tecnica_de());

            // ejecutar sentencia
            int cantidad = stmt.executeUpdate();

            fueAgregado = (cantidad > 0);

        } catch (Exception e) {

            System.out.println("Error al agregar equipo " + e.getMessage());

        } finally {

            conn.close();

        }
        return fueAgregado;
    }

    //Comprueba si hay un equipo con ese númereo de serie
    public boolean existeEquipo(String Serie) throws SQLException {

        boolean Existe = false;

        Connection conn = conexion.conectar();

        try {
            String serie = "";
            String sql = "select num_serie from equipos where num_serie = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Serie);

            // ejecutar sentencia
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                serie = rs.getString("num_serie");
            }

            if (serie.isEmpty()) {
                Existe = false;

            } else {

                Existe = true;

            }

        } catch (Exception e) {

            System.out.println("Error al seleccionar número de serie " + e.getMessage());

        } finally {

            conn.close();

        }
        return Existe;
    }

    //Crea un listado de los equipos guardados en nuestra base de datos según ID cliente
    public ArrayList<Equipo> listadoEquipos() throws SQLException {

        ArrayList<Equipo> equipo = new ArrayList();
        Connection conn = conexion.conectar();

        try {
            String sql = "select id_equipo , tipo_equipo, marca, estatus, num_serie from equipos where id_cliente = '" + ClienteRegistrado.user_update + "'";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Extraigo datos
                Equipo eq = new Equipo();
                eq.setId(rs.getInt("id_equipo"));
                eq.setTipo_equipo(rs.getString("tipo_equipo"));
                eq.setMarca(rs.getString("marca"));
                eq.setEstatus(rs.getString("estatus"));
                eq.setNum_serie(rs.getString("num_serie"));
                equipo.add(eq);

            }

        } catch (Exception e) {
            System.out.println("Error lista equipos: " + e.getMessage());
        } finally {
            conn.close();
        }
        return equipo;
    }

    //Crea un listado de los equipos guardados en nuestra base de datos 
    public ArrayList<Equipo> listarEquipos() throws SQLException {

        ArrayList<Equipo> equipo = new ArrayList();
        Connection conn = conexion.conectar();

        try {
            String sql = "select id_equipo, tipo_equipo, marca, modelo, num_serie from equipos ";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Extraigo datos
                Equipo eq = new Equipo();
                eq.setId(rs.getInt("id_equipo"));
                eq.setTipo_equipo(rs.getString("tipo_equipo"));
                eq.setMarca(rs.getString("marca"));
                eq.setEstatus(rs.getString("modelo"));
                eq.setNum_serie(rs.getString("num_serie"));
                equipo.add(eq);

            }

        } catch (Exception e) {
            System.out.println("Error lista equipos: " + e.getMessage());
        } finally {
            conn.close();
        }
        return equipo;
    }

    //Muestra toda la información del equipo correspondiente al ID del Equipo seleccionado
    public ArrayList<Equipo> listadoEquipo() throws SQLException {

        ArrayList<Equipo> equipo = new ArrayList();
        Connection conn = conexion.conectar();

        try {
            String sql = "select * from equipos where id_equipo = '" + EquipoRegistrado.user_update + "'";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //Extraigo datos
                Equipo eq = new Equipo();
                eq.setTipo_equipo(rs.getString("tipo_equipo"));
                eq.setMarca(rs.getString("marca"));
                eq.setModelo(rs.getString("modelo"));
                eq.setEstatus(rs.getString("estatus"));
                eq.setNum_serie(rs.getString("num_serie"));
                eq.setUltima_modificacion(rs.getString("ultima_modificacion"));
                eq.setDia_ingreso(rs.getString("dia_ingreso"));
                eq.setMes_ingreso(rs.getString("mes_ingreso"));
                eq.setAnyo_ingreso(rs.getString("annio_ingreso"));
                eq.setComentarios_tecnicos(rs.getString("comentarios_tecnicos"));
                eq.setRevision_tecnica_de(rs.getString("revision_tecnica"));
                equipo.add(eq);

            }

        } catch (Exception e) {
            System.out.println("Error lista equipos: " + e.getMessage());
        } finally {
            conn.close();
        }
        return equipo;
    }

    //Permite actualizar el equipo en nuestra base de datos
    public boolean actualizarEquipo(Equipo equipos) throws SQLException {

        boolean fueActualizado = false;

        Connection conn = conexion.conectar();

        try {

            String sql = "update equipos set tipo_equipo = ?, marca = ?, modelo =?, num_serie = ?, dia_ingreso =?, mes_ingreso =?, annio_ingreso =?, estatus = ?,comentarios_tecnicos = ?, revision_tecnica = ? where id_equipo  = '" + EquipoRegistrado.user_update + "'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, equipos.getTipo_equipo());
            stmt.setString(2, equipos.getMarca());
            stmt.setString(3, equipos.getModelo());
            stmt.setString(4, equipos.getNum_serie());
            stmt.setString(5, equipos.getDia_ingreso());
            stmt.setString(6, equipos.getMes_ingreso());
            stmt.setString(7, equipos.getAnyo_ingreso());
            stmt.setString(8, equipos.getEstatus());
            stmt.setString(9, equipos.getComentarios_tecnicos());
            stmt.setString(10, equipos.getRevision_tecnica_de());

            // ejecutar sentencia
            int cantidad = stmt.executeUpdate();

            fueActualizado = (cantidad > 0);

        } catch (Exception e) {

            System.out.println("Error al actualizar equipo " + e.getMessage());

        } finally {

            conn.close();

        }
        return fueActualizado;
    }
}
