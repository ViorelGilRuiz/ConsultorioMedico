package bbddVgil;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javax.swing.JComboBox;

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

    public static boolean nuevaCitaEnfermeria_Vgil(CitaVgil citaenfermeria) throws Exception {
        String consultaInsert = "INSERT INTO citasEnfermeria (dniPaciente, nombre, dia, hora) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement st = conn.prepareStatement(consultaInsert);
            st.setString(1, EncriptadoVgil.encriptar_Vgil(citaenfermeria.getDniPacienteVgil()));
            st.setString(2, EncriptadoVgil.encriptar_Vgil(citaenfermeria.getNombreVgil()));
            st.setDate(3, new java.sql.Date(citaenfermeria.getDiaVgil().getTime()));
            st.setDouble(4, citaenfermeria.getHoraVgil());

            st.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al insertar la cita de enfermería: " + ex.getMessage());
        }
        return false;
    }

    public static boolean registrarConsultaMedica_Informe_Vgil(ConsultaVgil c) {

        try {
            String consulta = "INSERT INTO consultas (dniPaciente, fechaConsulta, diagnostico, tratamiento, "
                    + "observaciones, codigofacultativo) "
                    + "values (?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(consulta);
            try {
                pst.setString(1, EncriptadoVgil.encriptar_Vgil(c.getDniPacienteVgil()));
                pst.setDate(2, new java.sql.Date(c.getFechaConsultaVgil().getTime()));
                pst.setString(3, c.getDiagnosticoVgil());
                pst.setString(4, c.getTratamientoVgil());
                pst.setString(5, c.getObservacionesVgil());
                pst.setInt(6, c.getCodigoFacultativoVgil());

            } catch (Exception ex) {
                Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
            }

            pst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean nuevaCitaMedica_Vgil(CitaVgil citaMedica) throws Exception {

        String consultaInsert = "INSERT INTO citas (dniPaciente, nombre, dia, hora) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement st = conn.prepareStatement(consultaInsert);

            st.setString(1, EncriptadoVgil.encriptar_Vgil(citaMedica.getDniPacienteVgil()));
            st.setString(2, EncriptadoVgil.encriptar_Vgil(citaMedica.getNombreVgil()));
            st.setDate(3, new java.sql.Date(citaMedica.getDiaVgil().getTime()));
            st.setDouble(4, citaMedica.getHoraVgil());

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
            Logger.getLogger(ConexionVgil.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static PacienteVgil recuperaDatosPrsona_Vgil(String dni) throws Exception {
        PacienteVgil p = null;

        String consulta = "SELECT dni, nombre, apellidos, telefono, email FROM paciente WHERE dni = ?";

        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conn.prepareStatement(consulta);
            pst.setString(1, EncriptadoVgil.encriptar_Vgil(dni));
            rs = pst.executeQuery();

            if (rs.next()) {
                p = new PacienteVgil(
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getInt("telefono"),
                        rs.getString("email")
                );

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ConexionVgil.class
                    .getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ConexionVgil.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                datos[1] = rs.getString("dia");
                datos[2] = rs.getString("hora");

                modelo.addRow(datos);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean registrarConsultaMedicaInforme_Vgil(ConsultaVgil c) {

        try {
            String consulta = "INSERT INTO consultas (dniPaciente, fechaConsulta, diagnostico, tratamiento, "
                    + "observaciones, codigofacultativo) "
                    + "values (?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(consulta);
            try {
                pst.setString(1, EncriptadoVgil.encriptar_Vgil(c.getDniPacienteVgil()));
                pst.setDate(2, new java.sql.Date(c.getFechaConsultaVgil().getTime()));
                pst.setString(3, c.getDiagnosticoVgil());
                pst.setString(4, c.getTratamientoVgil());
                pst.setString(5, c.getObservacionesVgil());
                pst.setInt(6, c.getCodigoFacultativoVgil());

            } catch (Exception ex) {
                Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
            }

            pst.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void cargarcitasEnfermeria_Vgil(DefaultTableModel modelo) {

        try {
            Object[] datos = new Object[5];
            String consulta = " SELECT fechaConsulta, tensionMax, tensionMin, glucosa, peso  from enfermeria where fechaConsulta = CURRENT_DATE()";

            ResultSet rs = conn.createStatement().executeQuery(consulta);
            while (rs.next()) {

                datos[0] = rs.getString("fechaConsulta");

                datos[1] = rs.getString("tensionMax");
                datos[2] = rs.getString("tensionMax");
                datos[3] = rs.getString("glucosa");
                datos[4] = rs.getString("peso");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void cargarTablaConsultasMedicas_Vgil(DefaultTableModel modelo, String dni) {

        try {
            Object[] datos = new Object[4];
            String consulta = " SELECT fechaConsulta, diagnostico, tratamiento, observaciones  from consultas";

            ResultSet rs = conn.createStatement().executeQuery(consulta);
            while (rs.next()) {

                datos[0] = rs.getString("fechaConsulta");

                datos[1] = rs.getString("diagnostico");
                datos[2] = rs.getString("tratamiento");
                datos[3] = rs.getString("observaciones");
                modelo.addRow(datos);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

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
            Logger.getLogger(ConexionVgil.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean registrarConsultasEnfermeria_Vil(ConsultaEnfermeriaVgil c) {
        try {
            String consulta = "INSERT INTO enfermeria(dniPaciente, fechaConsulta, tensionMax, tensionMin, "
                    + "glucosa, peso, codigoFacultativo) "
                    + "values (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pst = conn.prepareStatement(consulta)) {
                pst.setString(1, EncriptadoVgil.encriptar_Vgil(c.getDniPacienteVgil()));
                pst.setDate(2, new java.sql.Date(c.getFechaConsultaVgil().getTime()));
                pst.setDouble(3, c.getMaximaVgil());
                pst.setDouble(4, c.getMinimaVgil());
                pst.setDouble(5, c.getGlucosaVgil());
                pst.setDouble(6, c.getPesoVgil());
                pst.setInt(7, c.getCodigoFacultativoVgil());

                pst.execute();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void cargarCombocp_Vgil(JComboBox<String> comboCp) {
        try {
            conectar_Vgil();
            String sql = "SELECT codigopostal FROM codigospostales";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                comboCp.addItem(rs.getString("codigopostal"));
            }

            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion_Vgil();
        }
    }

    public static boolean registrarPaciente_Vgil(PacienteVgil pa) {

        String consultaInsert = "INSERT INTO paciente (dni, nombre, apellidos, fechaNacimiento, telefono, email, cp, sexo, tabaquismo, consumoAlcohol, antecedentesSalud, datosSaludGeneral, fechaRegistro)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement st = conn.prepareStatement(consultaInsert)) {
            try {
                st.setString(1, EncriptadoVgil.encriptar_Vgil(pa.getDniVgil()));
                st.setString(2, EncriptadoVgil.encriptar_Vgil(pa.getNombreVgil()));
                st.setString(3, EncriptadoVgil.encriptar_Vgil(pa.getApellidosVgil()));
            } catch (Exception ex) {
                Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
            }

            st.setDate(4, new java.sql.Date(pa.getFechaNacimientoVgil().getTime()));

            st.setInt(5, pa.getTelefonoVgil());
            st.setString(6, pa.getEmailVgil());
            st.setInt(7, pa.getCpVgil());
            st.setString(8, pa.getSexoVgil());
            st.setString(9, pa.getTabaquismoVgil());
            st.setString(10, pa.getConsumoalcholVgil());
            st.setString(11, pa.getAntecedentesSaludVgil());
            st.setString(12, pa.getDatosSaludGeneralVgil());
            st.setDate(13, new java.sql.Date(pa.getFechaRegistroVgil().getTime()));

            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
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

    public static void cargarDatosPacientes_Vgil(DefaultTableModel modelo) {
        try {
            conn = ConexionVgil.conectar_Vgil();
            Object[] datos = new Object[5];

            String consulta = "SELECT dni, nombre, apellidos, telefono, cp FROM paciente ";

            ResultSet rs = conn.createStatement().executeQuery(consulta);
            while (rs.next()) {
                try {
                    datos[0] = EncriptadoVgil.desencriptar_Vgil(rs.getString("dni"));
                    datos[1] = EncriptadoVgil.desencriptar_Vgil(rs.getString("nombre"));
                    datos[2] = EncriptadoVgil.desencriptar_Vgil(rs.getString("apellidos"));
                } catch (Exception ex) {
                    Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
                }

                datos[3] = rs.getString("telefono");
                datos[4] = rs.getString("cp");

                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean actualizaDatos(PacienteVgil p, String dni) {

        try {
            String consultasUpdate = "UPDATE paciente set nombre=?, apellidos=?, cp=? WHERE dni=?";

            try (com.mysql.jdbc.PreparedStatement stat = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(consultasUpdate)) {
                stat.setString(1, p.getNombreVgil());
                stat.setString(2, p.getApellidosVgil());
                stat.setInt(3, p.getCpVgil());
                stat.setString(4, dni);

                stat.executeUpdate();
            }
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ConexionVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

}
