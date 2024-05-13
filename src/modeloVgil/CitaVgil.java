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
public class CitaVgil {

    public CitaVgil(String dniPacienteVgil, String nombreVgil, Date diaVgil, double horaVgil) {
        this.dniPacienteVgil = dniPacienteVgil;
        this.nombreVgil = nombreVgil;
        this.diaVgil = diaVgil;
        this.horaVgil = horaVgil;
    }

    public String getDniPacienteVgil() {
        return dniPacienteVgil;
    }

    public void setDniPacienteVgil(String dniPacienteVgil) {
        this.dniPacienteVgil = dniPacienteVgil;
    }

    public String getNombreVgil() {
        return nombreVgil;
    }

    public void setNombreVgil(String nombreVgil) {
        this.nombreVgil = nombreVgil;
    }

    public Date getDiaVgil() {
        return diaVgil;
    }

    public void setDiaVgil(Date diaVgil) {
        this.diaVgil = diaVgil;
    }

    public double getHoraVgil() {
        return horaVgil;
    }

    public void setHoraVgil(double horaVgil) {
        this.horaVgil = horaVgil;
    }

    @Override
    public String toString() {
        return "CitaVgil{" + "dniPacienteVgil=" + dniPacienteVgil + ", nombreVgil=" + nombreVgil + ", diaVgil=" + diaVgil + ", horaVgil=" + horaVgil + '}';
    }
    
    String dniPacienteVgil;
    String nombreVgil;
    Date diaVgil;
    double horaVgil;
    
}
