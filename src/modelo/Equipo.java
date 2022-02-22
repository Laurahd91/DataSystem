package modelo;

/**
 *
 * @author laura
 */
public class Equipo {

    //Declaramos variables
    int id;
    int id_cliente;
    String tipo_equipo;
    String marca;
    String modelo;
    String num_serie;
    String dia_ingreso;
    String mes_ingreso;
    String anyo_ingreso;
    String observaciones;
    String estatus;
    String ultima_modificacion;
    String comentarios_tecnicos;
    String revision_tecnica_de;

    // Constructor sin parámetros
    public Equipo() {
    }

    //Constructor con parámetros
    public Equipo(int id, int id_cliente, String tipo_equipo, String marca, String modelo, String num_serie, String dia_ingreso, String mes_ingreso, String anyo_ingreso, String observaciones, String estatus, String ultima_modificacion, String comentarios_tecnicos, String revision_tecnica_de) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.tipo_equipo = tipo_equipo;
        this.marca = marca;
        this.modelo = modelo;
        this.num_serie = num_serie;
        this.dia_ingreso = dia_ingreso;
        this.mes_ingreso = mes_ingreso;
        this.anyo_ingreso = anyo_ingreso;
        this.observaciones = observaciones;
        this.estatus = estatus;
        this.ultima_modificacion = ultima_modificacion;
        this.comentarios_tecnicos = comentarios_tecnicos;
        this.revision_tecnica_de = revision_tecnica_de;
    }

    //Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTipo_equipo() {
        return tipo_equipo;
    }

    public void setTipo_equipo(String tipo_equipo) {
        this.tipo_equipo = tipo_equipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public String getDia_ingreso() {
        return dia_ingreso;
    }

    public void setDia_ingreso(String dia_ingreso) {
        this.dia_ingreso = dia_ingreso;
    }

    public String getMes_ingreso() {
        return mes_ingreso;
    }

    public void setMes_ingreso(String mes_ingreso) {
        this.mes_ingreso = mes_ingreso;
    }

    public String getAnyo_ingreso() {
        return anyo_ingreso;
    }

    public void setAnyo_ingreso(String anyo_ingreso) {
        this.anyo_ingreso = anyo_ingreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getUltima_modificacion() {
        return ultima_modificacion;
    }

    public void setUltima_modificacion(String ultima_modificacion) {
        this.ultima_modificacion = ultima_modificacion;
    }

    public String getComentarios_tecnicos() {
        return comentarios_tecnicos;
    }

    public void setComentarios_tecnicos(String comentarios_tecnicos) {
        this.comentarios_tecnicos = comentarios_tecnicos;
    }

    public String getRevision_tecnica_de() {
        return revision_tecnica_de;
    }

    public void setRevision_tecnica_de(String revision_tecnica_de) {
        this.revision_tecnica_de = revision_tecnica_de;
    }

    // Sobreescribimos el método toString()
    @Override
    public String toString() {
        return "Equipo{" + "id=" + id + "id_cliente=" + id_cliente + ", tipo_equipo=" + tipo_equipo + ", marca=" + marca + ", modelo=" + modelo + ", num_serie=" + num_serie + ", dia_ingreso=" + dia_ingreso + ", mes_ingreso=" + mes_ingreso + ", anyo_ingreso=" + anyo_ingreso + ", observaciones=" + observaciones + ", estatus=" + estatus + ", ultima_modificacion=" + ultima_modificacion + ", comentarios_tecnicos=" + comentarios_tecnicos + ", revision_tecnica_de=" + revision_tecnica_de + '}';
    }

}
