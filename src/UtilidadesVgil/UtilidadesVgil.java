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
     public static boolean validacionLetraDni_Vgil(String dni) {

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        String numeroDni = dni.substring(0, 8);
        char letraDni = dni.charAt(8);

        int posicion = Integer.parseInt(numeroDni) % 23;

        return letraDni == letras.charAt(posicion);

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

    public static boolean rangotel_Vgil(int tefn) {
        return tefn <= 988999999;

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
    
    public static boolean comboNoSeleccionado_Vgil (JComboBox combo) {
        return combo.getSelectedIndex() == 0;
    }
    
    public static void alertaComboNoSeleccionado_Vgil (Component padre, JComboBox combo) {
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
    
     private void datosFila() {

        String contenido = "FECHA DE CONSULTA: " + String.valueOf(tablaConsultas.getValueAt(tablaConsultas.getSelectedRow(), 0));
        contenido += "\n\nDIAGNÓSTICO:\n " + String.valueOf(tablaConsultas.getValueAt(tablaConsultas.getSelectedRow(), 1));
        contenido += "\n\nTRATAMIENTO:\n " + String.valueOf(tablaConsultas.getValueAt(tablaConsultas.getSelectedRow(), 2));
        contenido += "\n\nOBSERVACIONES:\n " + String.valueOf(tablaConsultas.getValueAt(tablaConsultas.getSelectedRow(), 3));

        JTextArea t = new JTextArea(20, 60);
        t.setText(contenido);
        t.setEditable(false);
        t.setLineWrap(true);
        t.setFocusable(false);
        t.setAutoscrolls(true);
        t.setMargin(new Insets(10, 10, 10, 10));

        JOptionPane.showMessageDialog(this, new JScrollPane(t), "INFORME", 1);

    }
    
}
