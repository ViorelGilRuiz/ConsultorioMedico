/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbddVgil;

import modeloVgil.PacienteVgil;
import modeloVgil.CitaVgil;
import modeloVgil.PersonalVgil;
import modeloVgil.ConsultaEnfermeriaVgil;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ConexionVgil {

    /**
     * La clase conexion nos va a permitir incorporar diversos metodos para
     * poder interacturar con la base de datos y rescatar los valores que
     * necesitemos en cada uno de los metodos que alberga esta clase.
     *
     */
    public static Connection conn;

    public static Connection conectar_Vgil() {

        /**
         * Método donde se establecen los parámetros de conexion con la base de
         * datos
         *
         */
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

        /**
         * Método para cerrar la conexion a la base de datos
         *
         */
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

        /**
         * Consulta para comprobar el logado de usarios (Personal)
         *
         *
         */
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

        /**
         * Recupera los datos del usario logado tomando como referencia el
         * nombre del usuario(unico). Recuperamos una cadena compuesta por el
         * nombre y los apellidos, su DNI y el numero de colegiado, todo ello en
         * una array de tipo String con tres posiciones
         */
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

    public static void recuperaCitasMedicas_Vgil(DefaultTableModel modelo) {

        /**
         * Método que nso permitira obtener de la base de datos las citas
         * medicas correspondientes a la fecha actual para cargarlas en una
         * tabla
         *
         */
    }

    public static void recuperarCitasEnfermeria_Vgil(DefaultTableModel modelo) {
        /**
         * Método que nso permitira obtener de la base de datos las citas de
         * enfermeria correspondientes a la fecha actual para cargarlas en una
         * tabla
         */
    }

    public static boolean registrarCitaMedica_Vgil(Cita citaMedica) {

        /**
         * Consulta para el registro de citas con el nombre y el dni del
         * paciente encriptados
         */
    }

    public static boolean registrarCitaEnfermeria_Vgil(Cita citaenfermeria) {
        /**
         * Consulta para el registro de citasEnfermeria con el nombre y el dni
         * del paciente encriptados
         */
    }

    public static boolean comprobarDni_Vgil(String campo) {

        /**
         * Consulta para comprobar si un DNI existe en la tabla de pacientes
         * asociado a algun paciente
         */
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

    public static PacienteVgil recuperarDatosPaciente_Vgil(String dni) {
        /**
         * Descarga de informacion especificia de pacientes cuyo dni se
         * corresponda al que pasamos como parámetro (nombre , apellidos,
         * telefono y email)
         */

    }

    public static void cargarTablaConsultasMedicas_Vgil(DefaultTableModel modelo, String dni) {
        /**
         *
         * Método para rescatar el listado de consulta medica de la base de
         * datos y organizarllos para su visualizacion en una tabla *
         */
    }

    public static void cargarTablaConsultasEnfermeria_Vgil(DefaultTableModel modelo, String dni) {
        /**
         * Método para rescatar el listado de consultade enfermeria de la base
         * de datos y organizarllos para su visualizacion en una tabla
         */
    }

    public static boolean registrsarConsultaMedica_Vgil(Consulta c) {

        /**
         * Consulta para el registro de consultas medicas en la base de datos
         */
    }

    public static boolean registrarConsultaEnfermeria_Vgil(ConsultaEnfermeriaVgil c) {
        /**
         * Consulta para el registro de consultas de enfermeria en la base de
         * datos
         */
    }

    public static void cargasComboCp_Vgil(JComboBox combo) {

        /**
         * carga en JComboBox de los codigos postales asociados al centro medico
         * desde la base de datos, dato inprescindible para el registro de
         * pacientes
         */
    }

    public static boolean registrarPaciente_Vgil(PacienteVgil paciente) {
        /**
         * Consulta para la incorporacion de nuevos pacientes a la aplicacionm
         */

    }

    public static void cargarTablaPacientes(DefaultTableModel modelo) {
        /**
         * Método para rescatar el listado de pacientes a la base de datos y
         * organizarlos para su visualizacion en una tabka
         */
    }

    public static boolean compruebaUsuario_Vgil(String usuario) {
        /**
         * Consulta para comprobar que el nombre de usuario en el proceso de
         * registro de personal esta disponible
         */
    }

    public static boolean compruebaNumeroColegiado_Vgil(long numero) {

        /**
         * Consulta para comprobar que el numero de colegiado del empleado en el
         * proceso de registro esta disponible o existe ya algun personal medico
         * registrado con ese numero de colegiado
         */
    }

    public static boolean registrarPersonal_Vgil(PersonalVgil persona) {

        /**
         * Consulta para la incorporacion de nuevos empleados medicos a la
         * aplicacion (Médicos o enfermeria)
         */
    }

}
