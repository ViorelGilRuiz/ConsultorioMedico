/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbddVgil;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionVgil {

    public static Connection conn;

    public static Connection conectar_Vgil() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                conn = (Connection) DriverManager.getConnection("jdbc:mysql://145.14.151.1/u812167471_consultorioDaw", "u812167471_consultorioDaw", "2024-Daw");
            } catch (SQLException ex) {
                Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Connection cerrarconexion_Vgil() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean datosPersona_Vgil() {

        try {
            String consulta = "SELECT numero_colegiado, nombre , apellidos , usuario , tipo FROM personal ";

            PreparedStatement pst = conn.prepareStatement(consulta);
            ResultSet rs;

            pst.setString(0, "numero_colegiado");
            pst.setString(1, "nombre");
            pst.setString(2, "usuario");
            pst.setString(4, "tipo");

            rs = pst.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public static boolean acceder_Vgil(String usuario, String pass) {

        String consulta = "SELECT usuario, contraseña FROM empleados WHERE usuario=? AND contraseña=?";

        try {

            PreparedStatement pst = conn.prepareStatement(consulta);
            ResultSet rs;

            pst.setString(1, usuario);
            pst.setString(2, pass);

            rs = pst.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static String[] recuperadatosUsuarios_Vgil(String user) {

        String[] usuario = new String[3];

        String consulta = "SELECT CONCAT (nombre, ' ', apellidos), numero_colegiado, tipo FROM personal WHERE usuario= '" + user + "'";

        try {
            Statement st = conn.createStatement();
            try (ResultSet rs = st.executeQuery(consulta)) {
                if (rs.next()) {
                    usuario[0] = rs.getString(1);
                    usuario[1] = rs.getString(2);
                    usuario[2] = rs.getString(3);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;

    }

    public static Connection cargarCitas_Vgil() {
        return null;
    }

    public static Connection cargarcitasEnfermerias_Vgil() {
        return null;

    }

    public static Connection registrarPaciente_Vgil() {

        return null;

    }

}
