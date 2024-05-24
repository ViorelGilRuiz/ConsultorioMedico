/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UtilidadesVgil;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import modeloVgil.CitaVgil;

/**
 *
 * @author oceans
 */
public class UtilidadEmailVgil {

    public static void enviaremailsimple(CitaVgil datos) {

        try {
            SimpleEmail email = new SimpleEmail();

            email.setHostName("smtp.hostinger.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("noreply@reynaldomd.com", "2024-Daw"));
            email.setSSLOnConnect(true);
            email.setCharset("UTF-8");
            email.setFrom("noreply@reynaldomd.com");
            email.setSubject("Correo enviado automáticamente");

            email.setMsg(datos.toString());
            String correo = null;
            email.addTo(correo);

            email.send();

        } catch (EmailException ex) {
            Logger.getLogger(UtilidadEmailVgil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
