/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UtilidadesVgil;

import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author oceans
 */
public class UtilidadesVgil {
     public static boolean validacionLetraDni(String dni) {

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        String numeroDni = dni.substring(0, 8);
        char letraDni = dni.charAt(8);

        int posicion = Integer.parseInt(numeroDni) % 23;

        return letraDni == letras.charAt(posicion);

    }

    public static boolean campoVacio(JTextField campo) {
        return campo.getText().isBlank();
    }

    public static boolean lanzaAlertaCampoVacio(JTextField campo) {
        JOptionPane.showMessageDialog(null, "El campo " + campo.getName() + " es obligatorio");
        return false;
    }

    public static boolean confirmaacionDNI(JTextField campo) {

        String patDni = "^[0-9]{8}[A-Z]{1}$";

        return campo.getText().matches(patDni);

    }

    public static boolean validacionLetra(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        String numeroDni = dni.substring(0, 8);
        char letraDni = dni.charAt(8);

        int posicion = Integer.parseInt(numeroDni) % 23;

        return letraDni == letras.charAt(posicion);

    }

    public static boolean validaciontelefonofijo(String telefono) {
        String patrontelefonofijo = "^[9,8]{1}[0-8]{1}[0-9]{7}$";
        return telefono.matches(patrontelefonofijo);

    }

    public static boolean rangotel(int tefn) {
        return tefn <= 988999999;

    }

    public static boolean LazarAlertaCampoNumerico(Component c, JTextField campo) {
        JOptionPane.showMessageDialog(c, "El campo" + campo.getName() + "solo admite numeros");
        return false;
    }

    public static boolean enteroCorrecto(JTextField campo) {
        try {
            String texto = campo.getText();

            int numero = Integer.parseInt(texto);

            if (numero > 0) {
                return true;
            }
        } catch (NumberFormatException e) {

        }

        return false;
    }
    
    public static boolean comboNoSeleccionado (JComboBox combo) {
        return combo.getSelectedIndex() == 0;
    }
    
    public static void alertaComboNoSeleccionado (Component padre, JComboBox combo) {
        JOptionPane.showMessageDialog(padre, "Debes seleccionar un elemento del campo " + combo.getName());
}

    public static void limpiarcampos() {

}
    public static boolean comprobarDni(String campo) {

        try {
            String consulta = "SELECT dniCliente from clientes where dniCliente =?";

            PreparedStatement pst = conn.prepareStatement(consulta);
            ResultSet rs;

            pst.setString(1, campo);

            rs = pst.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
}
