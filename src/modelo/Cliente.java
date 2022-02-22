package modelo;

/**
 *
 * @author laura
 */
public class Cliente {

    //Declaramos variables
    int id;
    String nombre;
    String email;
    String telefono;
    String direccion;
    String modificacion;

    // Constructor sin parámetros
    public Cliente() {
    }

    //Constructor con parámetros
    public Cliente(int id, String nombre, String email, String telefono, String direccion, String modificacion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.modificacion = modificacion;
    }

    //Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getModificacion() {
        return modificacion;
    }

    public void setModificacion(String modificacion) {
        this.modificacion = modificacion;
    }

    // Sobreescribimos el método toString()
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", direccion=" + direccion + ", modificacion=" + modificacion + '}';
    }

}
