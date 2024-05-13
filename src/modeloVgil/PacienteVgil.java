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

    public PacienteVgil(String dniVgil, String nombreVgil, String apellidosVgil, Date fechaNacimientoVgil, int telefonoVgil, String emailVgil, int cpVgil, String sexoVgil, String tabaquismoVgil, String consumoalcholVgil, String antecedentesSaludVgil, String datosSaludGeneralVgil, Date fechaRegistroVgil) {
        this.dniVgil = dniVgil;
        this.nombreVgil = nombreVgil;
        this.apellidosVgil = apellidosVgil;
        this.fechaNacimientoVgil = fechaNacimientoVgil;
        this.telefonoVgil = telefonoVgil;
        this.emailVgil = emailVgil;
        this.cpVgil = cpVgil;
        this.sexoVgil = sexoVgil;
        this.tabaquismoVgil = tabaquismoVgil;
        this.consumoalcholVgil = consumoalcholVgil;
        this.antecedentesSaludVgil = antecedentesSaludVgil;
        this.datosSaludGeneralVgil = datosSaludGeneralVgil;
        this.fechaRegistroVgil = fechaRegistroVgil;
    }

    public String getDniVgil() {
        return dniVgil;
    }

    public void setDniVgil(String dniVgil) {
        this.dniVgil = dniVgil;
    }

    public String getNombreVgil() {
        return nombreVgil;
    }

    public void setNombreVgil(String nombreVgil) {
        this.nombreVgil = nombreVgil;
    }

    public String getApellidosVgil() {
        return apellidosVgil;
    }

    public void setApellidosVgil(String apellidosVgil) {
        this.apellidosVgil = apellidosVgil;
    }

    public Date getFechaNacimientoVgil() {
        return fechaNacimientoVgil;
    }

    public void setFechaNacimientoVgil(Date fechaNacimientoVgil) {
        this.fechaNacimientoVgil = fechaNacimientoVgil;
    }

    public int getTelefonoVgil() {
        return telefonoVgil;
    }

    public void setTelefonoVgil(int telefonoVgil) {
        this.telefonoVgil = telefonoVgil;
    }

    public String getEmailVgil() {
        return emailVgil;
    }

    public void setEmailVgil(String emailVgil) {
        this.emailVgil = emailVgil;
    }

    public int getCpVgil() {
        return cpVgil;
    }

    public void setCpVgil(int cpVgil) {
        this.cpVgil = cpVgil;
    }

    public String getSexoVgil() {
        return sexoVgil;
    }

    public void setSexoVgil(String sexoVgil) {
        this.sexoVgil = sexoVgil;
    }

    public String getTabaquismoVgil() {
        return tabaquismoVgil;
    }

    public void setTabaquismoVgil(String tabaquismoVgil) {
        this.tabaquismoVgil = tabaquismoVgil;
    }

    public String getConsumoalcholVgil() {
        return consumoalcholVgil;
    }

    public void setConsumoalcholVgil(String consumoalcholVgil) {
        this.consumoalcholVgil = consumoalcholVgil;
    }

    public String getAntecedentesSaludVgil() {
        return antecedentesSaludVgil;
    }

    public void setAntecedentesSaludVgil(String antecedentesSaludVgil) {
        this.antecedentesSaludVgil = antecedentesSaludVgil;
    }

    public String getDatosSaludGeneralVgil() {
        return datosSaludGeneralVgil;
    }

    public void setDatosSaludGeneralVgil(String datosSaludGeneralVgil) {
        this.datosSaludGeneralVgil = datosSaludGeneralVgil;
    }

    public Date getFechaRegistroVgil() {
        return fechaRegistroVgil;
    }

    public void setFechaRegistroVgil(Date fechaRegistroVgil) {
        this.fechaRegistroVgil = fechaRegistroVgil;
    }

    @Override
    public String toString() {
        return "PacienteVgil{" + "dniVgil=" + dniVgil + ", nombreVgil=" + nombreVgil + ", apellidosVgil=" + apellidosVgil + ", fechaNacimientoVgil=" + fechaNacimientoVgil + ", telefonoVgil=" + telefonoVgil + ", emailVgil=" + emailVgil + ", cpVgil=" + cpVgil + ", sexoVgil=" + sexoVgil + ", tabaquismoVgil=" + tabaquismoVgil + ", consumoalcholVgil=" + consumoalcholVgil + ", antecedentesSaludVgil=" + antecedentesSaludVgil + ", datosSaludGeneralVgil=" + datosSaludGeneralVgil + ", fechaRegistroVgil=" + fechaRegistroVgil + '}';
    }

    
    private String dniVgil;
    private String nombreVgil;
    private String apellidosVgil;
    private Date fechaNacimientoVgil;
    private int telefonoVgil;
    private String emailVgil;
    private int cpVgil;
    private String sexoVgil;
    private String tabaquismoVgil;
    private String consumoalcholVgil;
    private String antecedentesSaludVgil;
    private String datosSaludGeneralVgil;
    private Date fechaRegistroVgil;
    
}

