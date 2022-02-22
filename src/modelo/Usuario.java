package modelo;

/**
 *
 * @author laura
 */
public class Usuario {

    //Declaramos variables
    int id;
    String nombre;
    String email;
    String telefono;
    String username;
    String password;
    String tipo_nivel;
    String estatus;
    String registrado;

    // Constructor sin parámetros
    public Usuario() {
    }

    //Constructor con parámetros
    public Usuario(int id, String nombre, String email, String telefono, String username, String password, String tipo_nivel, String estatus, String registrado) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.username = username;
        this.password = password;
        this.tipo_nivel = tipo_nivel;
        this.estatus = estatus;
        this.registrado = registrado;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo_nivel() {
        return tipo_nivel;
    }

    public void setTipo_nivel(String tipo_nivel) {
        this.tipo_nivel = tipo_nivel;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getRegistrado() {
        return registrado;
    }

    public void setRegistrado(String registrado) {
        this.registrado = registrado;
    }

    // Sobreescribimos el método toString()
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", username=" + username + ", password=" + password + ", tipo_nivel=" + tipo_nivel + ", estatus=" + estatus + ", registrado=" + registrado + '}';
    }

}
