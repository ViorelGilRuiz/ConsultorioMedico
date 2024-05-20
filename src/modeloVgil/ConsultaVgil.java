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
public class ConsultaVgil {

    public ConsultaVgil(String dniPacienteVgil, Date fechaConsultaVgil, String diagnosticoVgil, String tratamientoVgil, String observacionesVgil, int codigoFacultativoVgil) {
        this.dniPacienteVgil = dniPacienteVgil;
        this.fechaConsultaVgil = fechaConsultaVgil;
        this.diagnosticoVgil = diagnosticoVgil;
        this.tratamientoVgil = tratamientoVgil;
        this.observacionesVgil = observacionesVgil;
        this.codigoFacultativoVgil = codigoFacultativoVgil;
    }

    public String getDniPacienteVgil() {
        return dniPacienteVgil;
    }

    public void setDniPacienteVgil(String dniPacienteVgil) {
        this.dniPacienteVgil = dniPacienteVgil;
    }

    public Date getFechaConsultaVgil() {
        return fechaConsultaVgil;
    }

    public void setFechaConsultaVgil(Date fechaConsultaVgil) {
        this.fechaConsultaVgil = fechaConsultaVgil;
    }

    public String getDiagnosticoVgil() {
        return diagnosticoVgil;
    }

    public void setDiagnosticoVgil(String diagnosticoVgil) {
        this.diagnosticoVgil = diagnosticoVgil;
    }

    public String getTratamientoVgil() {
        return tratamientoVgil;
    }

    public void setTratamientoVgil(String tratamientoVgil) {
        this.tratamientoVgil = tratamientoVgil;
    }

    public String getObservacionesVgil() {
        return observacionesVgil;
    }

    public void setObservacionesVgil(String observacionesVgil) {
        this.observacionesVgil = observacionesVgil;
    }

    public int getCodigoFacultativoVgil() {
        return codigoFacultativoVgil;
    }

    public void setCodigoFacultativoVgil(int codigoFacultativoVgil) {
        this.codigoFacultativoVgil = codigoFacultativoVgil;
    }

    @Override
    public String toString() {
        return "ConsultaVgil{" + "dniPacienteVgil=" + dniPacienteVgil + ", fechaConsultaVgil=" + fechaConsultaVgil + ", diagnosticoVgil=" + diagnosticoVgil + ", tratamientoVgil=" + tratamientoVgil + ", observacionesVgil=" + observacionesVgil + ", codigoFacultativoVgil=" + codigoFacultativoVgil + '}';
    }


    private String dniPacienteVgil;
    private Date fechaConsultaVgil;
    private String diagnosticoVgil;
    private String tratamientoVgil;
    private String observacionesVgil;
    private int codigoFacultativoVgil;

    public ConsultaVgil(String dniPacienteVgil, String diagnosticoVgil, String tratamientoVgil, String observacionesVgil) {
        this.dniPacienteVgil = dniPacienteVgil;
        this.diagnosticoVgil = diagnosticoVgil;
        this.tratamientoVgil = tratamientoVgil;
        this.observacionesVgil = observacionesVgil;
    }
    
    
    
    
}
