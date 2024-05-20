package bbddVgil;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.lang.ExceptionInInitializerError;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modeloVgil.CitaVgil;
import modeloVgil.ConsultaVgil;
import modeloVgil.ConsultaEnfermeriaVgil;

public class ConexionVgil {

    public static Connection conn;

    public static Connection conectar_Vgil() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://145.14.151.1/u812167471_consultorioDaw", "u812167471_consultorioDaw", "2024-Daw");
            System.out.println("Conexi�n exitosa a la base de datos");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void cerrarConexion_Vgil() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexi�n cerrada");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean registrarCitaMedica_Vgil(CitaVgil cita) {
        String consultaInsert = "INSERT INTO citas (dniPaciente, nombre, dia, hora) " + " VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement st = conn.prepareStatement(consultaInsert);
            st.setString(1, cita.getDniPacienteVgil());
            st.setString(2, cita.getNombreVgil());
            st.setString(3, cita.getDiaVgil().toString());
            st.setString(4, String.valueOf(cita.getHoraVgil()));

            st.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al insertar la cita: " + ex.getMessage());
        }

        return false;
    }

    public static boolean registrarCitaEnfermeria_Vgil(CitaVgil citaenfermeria) {
        String consultaInsert = "INSERT INTO citasenfermeria (dniPaciente, nombre, dia, hora) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement st = conn.prepareStatement(consultaInsert);
            st.setString(1, citaenfermeria.getDniPacienteVgil());
            st.setString(2, citaenfermeria.getNombreVgil());
            st.setString(3, citaenfermeria.getDiaVgil().toString());
            st.setDouble(4, citaenfermeria.getHoraVgil());

            st.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al insertar la cita de enfermer�a: " + ex.getMessage());
        }
        return false;
    }

    public static boolean datosPersonal_Vgil() {
        try {
            String consulta = "SELECT numero_colegiado, nombre , apellidos , usuario , tipo FROM personal ";
            PreparedStatement pst = conn.prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                // Procesa los resultados seg�n sea necesario
                System.out.println("N�mero de colegiado: " + rs.getString("numero_colegiado"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Apellidos: " + rs.getString("apellidos"));
                System.out.println("Usuario: " + rs.getString("usuario"));
                System.out.println("Tipo: " + rs.getString("tipo"));
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean acceder_Vgil(String usuario, String pass) {
        String consulta = "SELECT usuario, contrase�a FROM empleados WHERE usuario=? AND contrase�a=?";

        try {
            PreparedStatement pst = conn.prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static String[] recuperaDatosUsuariosLoqueados_Vgil(String user) {
        /**
         * Recupera los datos del usuario logado tomando como referencia el
         * nombre de usuario (unico ) Recuperamos una cadena compuesta por el
         * nombre y los apellidos , su DNI y el numero de colegiado, todo ello
         * en una array de tipo String con 3 posiciones
         */
        String[] usuario = new String[3];
        String consulta = "SELECT CONCAT(nombre, ' ', apellidos), numero_colegiado, tipo FROM personal WHERE usuario= ?";

        try {
            PreparedStatement st = conn.prepareStatement(consulta);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                usuario[0] = rs.getString(1);
                usuario[1] = rs.getString(2);
                usuario[2] = rs.getString(3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    public static void recuperaCitasMedicas_Vgil(DefaultTableModel modelo) throws SQLException {

        /**
         * Metodo que nos permitira obtener de la base de datos las citas
         * medicas correspondientes a la fecha actual para cargarlas en una
         * tabla
         */
        String consulta = "SELECT dniPaciente, nombre, dia, hora FROM citasenfermeria";
        ResultSet rs = conn.createStatement().executeQuery(consulta);
        while (rs.next()) {
            String dniPaciente = rs.getString("dniPaciente");
            String nombre = rs.getString("nombre");
            String fecha = rs.getString("dia");
            String hora = rs.getString("hora");
            Object[] citaMedica = {dniPaciente, nombre, fecha, hora};
            modelo.addRow(citaMedica);
        }
    }

    public static void recuperarCitasEnfermeria_Vgil(DefaultTableModel modelo) {

        String consulta = "SELECT dniPaciente, nombre, dia, hora FROM citasenfermeria";
        try {
            ResultSet rs = conn.createStatement().executeQuery(consulta);
            while (rs.next()) {
                String dniPaciente = rs.getString("dniPaciente");
                String nombre = rs.getString("nombre");
                String fecha = rs.getString("dia");
                String hora = rs.getString("hora");
                Object[] citaMedica = {dniPaciente, nombre, fecha, hora};
                modelo.addRow(citaMedica);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean registrarCitaMedica(ConsultaEnfermeriaVgil consulta) {

        String consultaInsert = "INSERT INTO consultas (dniPaciente, fechaConsulta,codigoFacultativo)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        String salud = "INSERT INTO enfermeria (tensionMax, tensionMin, glucosa, peso ) " + "VALUES (?,?,?,?)";

        try {
            PreparedStatement st = conn.prepareStatement(consultaInsert);
            st.setString(1, consulta.getDniPacienteVgil());
            st.setDate(2, (java.sql.Date) new Date(consulta.getFechaConsultaVgil().getTime())); // Convertir java.util.Date a java.sql.Date
            st.setDouble(3, consulta.getMaximaVgil());
            st.setDouble(4, consulta.getMinimaVgil());
            st.setInt(5, consulta.getGlucosaVgil());
            st.setDouble(6, consulta.getPesoVgil());
            st.setInt(7, consulta.getCodigoFacultativoVgil());

            st.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al insertar la cita: " + ex.getMessage());
        }

        return false;
    }

    public static boolean comprobarDni(String campo) {

        /**
         * Consulta para comprobar si un DNI existe en la tabla de p acientes
         * asociado a algun paciente
         */
        try {
            String consulta = "SELECT dniPaciente from pacientes where dniPaciente =?";

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

    public static boolean registrarCitaEnfermeria_Vgil(ConsultaEnfermeriaVgil cita) {
        /**
         * Consulta para el registro de citasEnfermeria con el nombre y el dni
         * del paciente encriptados
         */
        String consultaInsert = "INSERT INTO consultas (dniPaciente, fechaConsulta, maxima, minima, glucosa, peso, codigoFacultativo)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement st = conn.prepareStatement(consultaInsert);
            st.setString(1, cita.getDniPacienteVgil());
            st.setDate(2, (java.sql.Date) new Date(cita.getFechaConsultaVgil().getTime())); // Convertir java.util.Date a java.sql.Date
            st.setDouble(3, cita.getMaximaVgil());
            st.setDouble(4, cita.getMinimaVgil());
            st.setInt(5, cita.getGlucosaVgil());
            st.setDouble(6, cita.getPesoVgil());
            st.setInt(7, cita.getCodigoFacultativoVgil());

            st.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al insertar la cita: " + ex.getMessage());
        }

        return false;

    }

    public static void cargasCombocp_Vgil() {
                
    /**
     * Carglos los codigos postales asocados a los consultorios medicos 
     */
    }
    
    public static boolean registrarPaciente_Vgil() {
    
        
        
    }
    
    public static void cargarTablaPacientes_Vgil() {
    
    }
    
    
    
}
