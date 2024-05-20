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
public class ConsultaEnfermeriaVgil {

    public ConsultaEnfermeriaVgil(String dniPacienteVgil, Date fechaConsultaVgil, double maximaVgil, double minimaVgil, int glucosaVgil, double pesoVgil, int codigoFacultativoVgil) {
        this.dniPacienteVgil = dniPacienteVgil;
        this.fechaConsultaVgil = fechaConsultaVgil;
        this.maximaVgil = maximaVgil;
        this.minimaVgil = minimaVgil;
        this.glucosaVgil = glucosaVgil;
        this.pesoVgil = pesoVgil;
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

    public double getMaximaVgil() {
        return maximaVgil;
    }

    public void setMaximaVgil(double maximaVgil) {
        this.maximaVgil = maximaVgil;
    }

    public double getMinimaVgil() {
        return minimaVgil;
    }

    public void setMinimaVgil(double minimaVgil) {
        this.minimaVgil = minimaVgil;
    }

    public int getGlucosaVgil() {
        return glucosaVgil;
    }

    public void setGlucosaVgil(int glucosaVgil) {
        this.glucosaVgil = glucosaVgil;
    }

    public double getPesoVgil() {
        return pesoVgil;
    }

    public void setPesoVgil(double pesoVgil) {
        this.pesoVgil = pesoVgil;
    }

    public int getCodigoFacultativoVgil() {
        return codigoFacultativoVgil;
    }

    public void setCodigoFacultativoVgil(int codigoFacultativoVgil) {
        this.codigoFacultativoVgil = codigoFacultativoVgil;
    }

    @Override
    public String toString() {
        return "ConsultaEnfermeriaVgil{" + "dniPacienteVgil="
                + dniPacienteVgil + ", fechaConsultaVgil=" + fechaConsultaVgil 
                + ", maximaVgil=" + maximaVgil + ", minimaVgil=" + minimaVgil 
                + ", glucosaVgil=" + glucosaVgil + ", pesoVgil=" + pesoVgil 
                + ", codigoFacultativoVgil=" + codigoFacultativoVgil + '}';
    }

   
    String dniPacienteVgil;
    Date fechaConsultaVgil;
    double maximaVgil, minimaVgil;
    int glucosaVgil;
    double pesoVgil;
    int codigoFacultativoVgil;
    
}
