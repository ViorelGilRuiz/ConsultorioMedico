/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloVgil;

/**
 *
 * @author oceans
 */
public class PersonalVgil {

    public PersonalVgil(int numero_colegiado, String nombre, String apellidos, int telefono, String usuario, String contrasenya, String tipo) {
        this.numero_colegiado = numero_colegiado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        this.tipo = tipo;
    }

    public int getNumero_colegiado() {
        return numero_colegiado;
    }

    public void setNumero_colegiado(int numero_colegiado) {
        this.numero_colegiado = numero_colegiado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "PersonalVgil{" + "numero_colegiado=" + numero_colegiado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", usuario=" + usuario + ", contrasenya=" + contrasenya + ", tipo=" + tipo + '}';
    }
    private int numero_colegiado;
    private String nombre;
    private String apellidos;
    private int telefono;
    private String usuario;
    private String contrasenya;
    private String tipo;
    
}
