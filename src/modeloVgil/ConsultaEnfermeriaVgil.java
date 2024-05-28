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

    public ConsultaEnfermeriaVgil(String dniPacienteVgil, Date fechaConsultaVgil, Double maximaVgil, Double minimaVgil, Double glucosaVgil, Double pesoVgil, int codigoFacultativoVgil) {
        this.dniPacienteVgil = dniPacienteVgil;
        this.maximaVgil = maximaVgil;
        this.minimaVgil = minimaVgil;
        this.glucosaVgil = glucosaVgil;
        this.pesoVgil = pesoVgil;
        this.fechaConsultaVgil = fechaConsultaVgil;
        this.codigoFacultativoVgil = codigoFacultativoVgil;
    }

    public String getDniPacienteVgil() {
        return dniPacienteVgil;
    }

    public void setDniPacienteVgil(String dniPacienteVgil) {
        this.dniPacienteVgil = dniPacienteVgil;
    }

    public Double getMaximaVgil() {
        return maximaVgil;
    }

    public void setMaximaVgil(Double maximaVgil) {
        this.maximaVgil = maximaVgil;
    }

    public Double getMinimaVgil() {
        return minimaVgil;
    }

    public void setMinimaVgil(Double minimaVgil) {
        this.minimaVgil = minimaVgil;
    }

    public Double getGlucosaVgil() {
        return glucosaVgil;
    }

    public void setGlucosaVgil(Double glucosaVgil) {
        this.glucosaVgil = glucosaVgil;
    }

    public Double getPesoVgil() {
        return pesoVgil;
    }

    public void setPesoVgil(Double pesoVgil) {
        this.pesoVgil = pesoVgil;
    }

    public Date getFechaConsultaVgil() {
        return fechaConsultaVgil;
    }

    public void setFechaConsultaVgil(Date fechaConsultaVgil) {
        this.fechaConsultaVgil = fechaConsultaVgil;
    }

    public Integer getCodigoFacultativoVgil() {
        return codigoFacultativoVgil;
    }

    public void setCodigoFacultativoVgil(Integer codigoFacultativoVgil) {
        this.codigoFacultativoVgil = codigoFacultativoVgil;
    }

    @Override
    public String toString() {
        return "ConsultaEnfermeriaVgil{" + "dniPacienteVgil=" + dniPacienteVgil + ", maximaVgil=" + maximaVgil + ", minimaVgil=" + minimaVgil + ", glucosaVgil=" + glucosaVgil + ", pesoVgil=" + pesoVgil + ", fechaConsultaVgil=" + fechaConsultaVgil + ", codigoFacultativoVgil=" + codigoFacultativoVgil + '}';
    }

    public ConsultaEnfermeriaVgil(String dniPacienteVgil, Double maximaVgil, Double minimaVgil, Double glucosaVgil, Double pesoVgil, Date fechaConsultaVgil) {
        this.dniPacienteVgil = dniPacienteVgil;
        this.maximaVgil = maximaVgil;
        this.minimaVgil = minimaVgil;
        this.glucosaVgil = glucosaVgil;
        this.pesoVgil = pesoVgil;
        this.fechaConsultaVgil = fechaConsultaVgil;
    }





    private String dniPacienteVgil;
    private Double maximaVgil;
    private Double minimaVgil;
    private Double glucosaVgil;
    private Double pesoVgil;
    private Date fechaConsultaVgil;
    private Integer codigoFacultativoVgil;
    
    
}
