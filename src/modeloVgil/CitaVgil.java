/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloVgil;

import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author oceans
 */
public class CitaVgil {
    
     private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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
        return "<h1>--------------------------- DATOS DE LA CITA ---------------------------</h1>" 
                + "\nDni del paciente: <b>" + dniPacienteVgil + "</b>" 
                +"\nNombre: <b>" + nombreVgil + "</b>"
                + "\nDia: <b>" + sdf.format(diaVgil) + "</b>"
                + "\nHora: <b>" + horaVgil + "</b>"
                + "<h2>---------------------------------------------------------</h2>"
                + "<br/><br/><img src =http://reynaldomd.com/firmacorreo/firmacorreo.png>"
                + "<br/><br/> Has recibido este email porque has solicitado una cita en el centro médico. Por favot, no responda a este correo electrónico: ha sido generado automáticamente.";
    }

    String dniPacienteVgil;
    String nombreVgil;
    Date diaVgil;
    double horaVgil;
    
    
    
}
