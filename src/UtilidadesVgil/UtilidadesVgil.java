/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UtilidadesVgil;

import VistasVgil.MedicoVgil;
import bbddVgil.ConexionVgil;
import static bbddVgil.ConexionVgil.conn;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author oceans
 */
public class UtilidadesVgil {

    public static boolean validacionLetraDni_Vgil(JTextField campoDNI) {
        String dni = campoDNI.getText().trim(); // Extract DNI text from JTextField and trim spaces

        if (dni.length() != 9) {
            return false; // Invalid length
        }

        // Verificar que los primeros 8 caracteres sean dígitos
        String numeroDni = dni.substring(0, 8);
        if (!numeroDni.matches("\\d+")) {
            return false; // No es un número válido
        }

        char letraDni = dni.charAt(8);
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        try {
            int posicion = Integer.parseInt(numeroDni) % 23;
            return letraDni == letras.charAt(posicion);
        } catch (NumberFormatException e) {
            return false; // Maneja el caso donde no se pueda convertir el número
        }
    }

    public static boolean campoVacio_Vgil(JTextField campo) {
        return campo.getText().isBlank();
    }

    public static boolean areaVacia_Vgil(JTextArea campo) {
        return campo.getText().isBlank();
    }

    public static boolean lanzaAlertaAreaVacia_Vgil(JTextArea campo) {
        JOptionPane.showMessageDialog(null, "El campo " + campo.getName() + " es obligatorio");
        return false;
    }

    public static void mostrarAlertaDNIFormatoInvalido_Vgil() {
        JOptionPane.showMessageDialog(null, "El formato del DNI no es válido");
    }

    public static void lanzarAlertaFormatoDeTelefonoIncorrecto_Vgil() {

        JOptionPane.showMessageDialog(null, "El formato del telefono no es válido");
    }

    public static boolean lanzaAlertaCampoVacio_Vgil(JTextField campo) {
        JOptionPane.showMessageDialog(null, "El campo " + campo.getName() + " es obligatorio");
        return false;
    }

    public static boolean confirmaacionDNI_Vgil(JTextField campo) {

        String patDni = "^[0-9]{8}[A-Z]{1}$";

        return campo.getText().matches(patDni);

    }

    public static boolean validacionLetra_Vgil(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        String numeroDni = dni.substring(0, 8);
        char letraDni = dni.charAt(8);

        int posicion = Integer.parseInt(numeroDni) % 23;

        return letraDni == letras.charAt(posicion);

    }

    public static boolean validaciontelefonofijo_Vgil(String telefono) {
        String patrontelefonofijo = "^[9,8]{1}[0-8]{1}[0-9]{7}$";
        return telefono.matches(patrontelefonofijo);

    }

    public static boolean rangotel_Vgil(int telefono) {
        // Convertir el número de teléfono a una cadena de texto
        String telefonoStr = String.valueOf(telefono);

        // El número de teléfono debe tener exactamente 9 dígitos
        if (telefonoStr.length() != 9) {
            return false;
        }

        // Verificar que todos los caracteres sean dígitos
        for (int i = 0; i < telefonoStr.length(); i++) {
            if (!Character.isDigit(telefonoStr.charAt(i))) {
                return false;
            }
        }

        // Verificar que el teléfono comience con 6 o 7
        char primerDigito = telefonoStr.charAt(0);
        if (primerDigito != '6' && primerDigito != '7') {
            return false;
        }

        return true;
    }

    public static boolean LazarAlertaCampoNumerico_Vgil(Component c, JTextField campo) {
        JOptionPane.showMessageDialog(c, "El campo" + campo.getName() + "solo admite numeros");
        return false;
    }

    public static boolean enteroCorrecto_Vgil(JTextField campo) {
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

    public static boolean comboNoSeleccionado_Vgil(JComboBox combo) {
        return combo.getSelectedIndex() == 0;
    }

    public static void alertaComboNoSeleccionado_Vgil(Component padre, JComboBox combo) {
        JOptionPane.showMessageDialog(padre, "Debes seleccionar un elemento del campo " + combo.getName());
    }

    public static void limpiarcampos_Vgil() {

    }

    public static boolean comprobarDni_Vgil(String campo) {

        try {
            String consulta = "SELECT dniCliente from clientes where dniCliente =?";

            PreparedStatement pst = conn.prepareStatement(consulta);
            ResultSet rs;

            pst.setString(1, campo);

            rs = pst.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Date sumarRestarDiasFecha_Vgil(Date fecha, int dias) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

}
