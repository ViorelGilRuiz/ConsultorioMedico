/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloVgil;

import java.util.Date;

/**
 *
 * @author oceans
 */
public class PacienteVgil {

    public PacienteVgil(String dni, String nombre, String apellidos, Date fechaNacimiento, int telefono, String email, int cp, String sexo, String tabaquismo, String consumoalchol, String antecedentesSalud, String datosSaludGeneral, Date fechaRegistro) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
        this.cp = cp;
        this.sexo = sexo;
        this.tabaquismo = tabaquismo;
        this.consumoalchol = consumoalchol;
        this.antecedentesSalud = antecedentesSalud;
        this.datosSaludGeneral = datosSaludGeneral;
        this.fechaRegistro = fechaRegistro;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTabaquismo() {
        return tabaquismo;
    }

    public void setTabaquismo(String tabaquismo) {
        this.tabaquismo = tabaquismo;
    }

    public String getConsumoalchol() {
        return consumoalchol;
    }

    public void setConsumoalchol(String consumoalchol) {
        this.consumoalchol = consumoalchol;
    }

    public String getAntecedentesSalud() {
        return antecedentesSalud;
    }

    public void setAntecedentesSalud(String antecedentesSalud) {
        this.antecedentesSalud = antecedentesSalud;
    }

    public String getDatosSaludGeneral() {
        return datosSaludGeneral;
    }

    public void setDatosSaludGeneral(String datosSaludGeneral) {
        this.datosSaludGeneral = datosSaludGeneral;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "PacienteVgil{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", email=" + email + ", cp=" + cp + ", sexo=" + sexo + ", tabaquismo=" + tabaquismo + ", consumoalchol=" + consumoalchol + ", antecedentesSalud=" + antecedentesSalud + ", datosSaludGeneral=" + datosSaludGeneral + ", fechaRegistro=" + fechaRegistro + '}';
    }
    
    private String dni;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private int telefono;
    private String email;
    private int cp;
    private String sexo;
    private String tabaquismo;
    private String consumoalchol;
    private String antecedentesSalud;
    private String datosSaludGeneral;
    private Date fechaRegistro;
    
}

