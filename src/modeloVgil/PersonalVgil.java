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

    public PersonalVgil(int numero_colegiadoVgil, String nombreVgil, String apellidosVgil, int telefonoVgil, String usuarioVgil, String contrasenyaVgil, String tipoVgil) {
        this.numero_colegiadoVgil = numero_colegiadoVgil;
        this.nombreVgil = nombreVgil;
        this.apellidosVgil = apellidosVgil;
        this.telefonoVgil = telefonoVgil;
        this.usuarioVgil = usuarioVgil;
        this.contrasenyaVgil = contrasenyaVgil;
        this.tipoVgil = tipoVgil;
    }

    public int getNumero_colegiadoVgil() {
        return numero_colegiadoVgil;
    }

    public void setNumero_colegiadoVgil(int numero_colegiadoVgil) {
        this.numero_colegiadoVgil = numero_colegiadoVgil;
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

    public int getTelefonoVgil() {
        return telefonoVgil;
    }

    public void setTelefonoVgil(int telefonoVgil) {
        this.telefonoVgil = telefonoVgil;
    }

    public String getUsuarioVgil() {
        return usuarioVgil;
    }

    public void setUsuarioVgil(String usuarioVgil) {
        this.usuarioVgil = usuarioVgil;
    }

    public String getContrasenyaVgil() {
        return contrasenyaVgil;
    }

    public void setContrasenyaVgil(String contrasenyaVgil) {
        this.contrasenyaVgil = contrasenyaVgil;
    }

    public String getTipoVgil() {
        return tipoVgil;
    }

    public void setTipoVgil(String tipoVgil) {
        this.tipoVgil = tipoVgil;
    }

    @Override
    public String toString() {
        return "PersonalVgil{" + "numero_colegiadoVgil=" + numero_colegiadoVgil + ", nombreVgil=" + nombreVgil + ", apellidosVgil=" + apellidosVgil + ", telefonoVgil=" + telefonoVgil + ", usuarioVgil=" + usuarioVgil + ", contrasenyaVgil=" + contrasenyaVgil + ", tipoVgil=" + tipoVgil + '}';
    }


    private int numero_colegiadoVgil;
    private String nombreVgil;
    private String apellidosVgil;
    private int telefonoVgil;
    private String usuarioVgil;
    private String contrasenyaVgil;
    private String tipoVgil;
    
}
