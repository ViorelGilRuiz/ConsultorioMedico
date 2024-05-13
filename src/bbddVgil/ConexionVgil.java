/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbddVgil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionVgil {
 
        public static Connection conn;

    public static Connection conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                conn = (Connection) DriverManager.getConnection(    "jdbc:mysql://145.14.151.1/u812167471_consultorioDaw", "u812167471_consultorioDaw", "password=2024-Daw");
            } catch (SQLException ex) {
                Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Connection cerrarconexion() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
public static boolean acceder(String user, String pass) {

        String consulta = "SELECT usuario, contraseña FROM empleados WHERE usuario=? AND contraseña=?";

        try {

            PreparedStatement pst = conn.prepareStatement(consulta);
            ResultSet rs;

            pst.setString(1, user);
            pst.setString(2, pass);

            rs = pst.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
