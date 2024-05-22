package bbddVgil;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mysql.jdbc.Statement;
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
import modeloVgil.PersonalVgil;
import modeloVgil.PacienteVgil;
import UtilidadesVgil.EncriptadoVgil;
import static java.util.Calendar.DATE;

public class ConexionVgil {

    public static Connection conn;

    public static Connection conectar_Vgil() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://145.14.151.1/u812167471_consultorioDaw", "u812167471_consultorioDaw", "2024-Daw");
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void cerrarConexion_Vgil() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexión cerrada");
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
            System.err.println("Error al insertar la cita de enfermería: " + ex.getMessage());
        }
        return false;
    }

    public static boolean acceder_Vgil(String usuario, String pass) {
        String consulta = "SELECT usuario, contrasenya FROM personal WHERE usuario=? AND contrasenya=?";

        try {
            Connection c = conectar_Vgil();
            if (c == null) {
                System.out.println("No se pudo establecer la conexión.");
                return false;
            }
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

    public static PacienteVgil recuperaDatosPrsona_Vgil(String dni) throws Exception {
        PacienteVgil p = null ;

        String consulta = "SELECT dni, nombre, apellidos, telefono, email FROM paciente WHERE dni = ?";

        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conn.prepareStatement(consulta);
            pst.setString(1, dni);  // Asigna el valor del dni al parámetro de la consulta
            rs = pst.executeQuery();

            if (rs.next()) {
                p = new PacienteVgil(
                        EncriptadoVgil.desencriptar_Vgil(rs.getString(2)),
                        EncriptadoVgil.desencriptar_Vgil(rs.getString(3)),
                        rs.getInt(4),
                        rs.getString(5)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }

    public static String[] recuperaDatosUsuariosLoqueados_Vgil(String user) {
        /**
         * Recupera los datos del usuario logado tomando como referencia el
         * nombre de usuario (unico ) Recuperamos una cadena compuesta por el
         * nombre y los apellidos , su DNI y el numero de colegiado, todo ello
         * en una array de tipo String con 3 posiciones
         */
        String[] usuario = new String[3];
        String consulta = "SELECT CONCAT(nombre, ' ', apellidos), numero_colegiado, tipo FROM personal WHERE usuario = ?";

        try {
            PreparedStatement st = conn.prepareStatement(consulta);
            st.setString(1, user); // Establecer el valor del parámetro de la consulta
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                usuario[0] = rs.getString(1); // Nombre y apellidos
                usuario[1] = rs.getString(2); // Número colegiado
                usuario[2] = rs.getString(3); // Tipo         
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    public static void cargarcitasMedicas_Vgil(DefaultTableModel modelo) {

        try {
            Object[] datos = new Object[3];
            String consulta = " SELECT nombre, dia, hora from citas ";

            ResultSet rs = conn.createStatement().executeQuery(consulta);
            while (rs.next()) {
                try {
                    datos[0] = EncriptadoVgil.desencriptar_Vgil(rs.getString("nombre"));
                } catch (Exception ex) {
                    Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
                }
                datos[1] = rs.getString("dia");
                datos[2] = rs.getString("hora");

                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void cargarcitasEnfermeria_Vgil(DefaultTableModel modelo) {

        try {
            Object[] datos = new Object[3];
            String consulta = " SELECT nombre, dia, hora from citasenfermeria";

            ResultSet rs = conn.createStatement().executeQuery(consulta);
            while (rs.next()) {
                try {
                    datos[0] = EncriptadoVgil.desencriptar_Vgil(rs.getString("nombre"));
                } catch (Exception ex) {
                    Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
                }
                datos[1] = rs.getString("dia");
                datos[2] = rs.getString("hora");

                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean registrarCitaMedica_Vgil(ConsultaEnfermeriaVgil consulta) {

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

    public static boolean comprobarDni_Vgil(String campo) {

        /**
         * Consulta para comprobar si un DNI existe en la tabla de p acientes
         * asociado a algun paciente
         */
        try {
            String consulta = "SELECT dni from paciente where dni =?";

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
         * Carglos los codigos postales asociados a los consultorios medicos
         */
        String consultaCp = "SELECT * FROM codigospostales";

        ConexionVgil.conectar_Vgil();

    }

    public static boolean registrarPaciente_Vgil(PacienteVgil pa) {
        String consultaInsert = "INSERT INTO paciente (dni, nombre, apellidos, fechaNacimiento, telefono, email, cp, sexo, tabaquismo, consumoAlcohol, antecedentesSalud, datosSaludGeneral, fechaRegistro)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement st = conn.prepareStatement(consultaInsert)) {
            st.setString(1, pa.getDniVgil());
            st.setString(2, pa.getNombreVgil());
            st.setString(3, pa.getApellidosVgil());
            st.setDate(4, (java.sql.Date) java.sql.Date.valueOf(LocalDate.MAX) pa.getFechaNacimientoVgil()
            );
        st.setInt(5, pa.getTelefonoVgil());
            st.setString(6, pa.getEmailVgil());
            st.setInt(7, pa.getCpVgil());
            st.setString(8, pa.getSexoVgil());
            st.setString(9, pa.getTabaquismoVgil());
            st.setString(10, pa.getConsumoAlcoholVgil());
            st.setString(11, pa.getAntecedentesSaludVgil());
            st.setString(12, pa.getDatosSaludGeneralVgil());
            st.setDate(13, (java.sql.Date) pa.getFechaRegistroVgil()); // Assuming LocalDateTime

            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public static void cargarTablaPacientes_Vgil(DefaultTableModel modelo) throws SQLException {

        Object[] datos = new Object[5];

        String consulta = "SELECT  (dni, nombre, apellidos, telefono, cp FROM paciente)"
                + "VALUES (?,?,?,?,?)";

        ResultSet rs = conn.createStatement().executeQuery(consulta);

        while (rs.next()) {
            datos[0] = rs.getString("dni");
            datos[1] = rs.getString("nombre");
            datos[0] = rs.getString("apellidos");
            datos[0] = rs.getString("telefono");
            datos[0] = rs.getString("cp");

            modelo.addRow(datos);

        }
    }

    public static boolean compruebaUser_Vgil(String usuario) {

        String consultaComprueba = "SELECT usuario FROM personal WHERE usuario = ?";

        try (PreparedStatement ps = conn.prepareStatement(consultaComprueba)) {
            ps.setString(1, usuario);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaVgil.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean compruebaNumeroColegiado_Vgil(long numero) {

        String consultaComprueba = "SELECT numero_colegiado FROM personal WHERE numero_colegiado = ?";
        try (PreparedStatement ps = conn.prepareStatement(consultaComprueba)) {
            ps.setLong(1, numero);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaVgil.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean registrarPersonal_Vgil(PersonalVgil p) {

        String consultaInsert = "INSERT INTO personal (numero_colegiado, nombre, apellidos, telefono, usuario, contrasenya, tipo)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement st = conn.prepareStatement(consultaInsert)) {
            st.setString(1, String.valueOf(p.getNumero_colegiadoVgil()));
            st.setString(2, p.getNombreVgil());
            st.setString(3, p.getApellidosVgil());
            st.setString(4, String.valueOf(p.getTelefonoVgil()));
            st.setString(5, p.getUsuarioVgil());
            st.setString(6, p.getContrasenyaVgil());
            st.setString(7, p.getTipoVgil());

            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

}
