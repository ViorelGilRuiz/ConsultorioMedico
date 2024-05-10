/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UtilidadesVgil;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oceans
 */
public class UtilidadEmailVgil {

    public Boolean enviaremailsimple() {

        try {
            SimpleEmail email = new SimpleEmail();
            email.setHostName("smtp.hostinger.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("noreply@reynaldomd.com", "2024-Daw"));
            email.setSSLOnConnect(true);
            email.setCharset("UTF-8");
            email.setFrom("noreply@reynaldomd.com");
            email.setSubject(this.asunto);
            email.setMsg(this.mensage);
            email.addTo(this.destinatario);
            email.send();
            return true;
        } catch (EmailException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public Boolean enviaremailadjunto() {

        try {
            EmailAttachment ficheroadjunto = new EmailAttachment();
            ficheroadjunto.setPath(ruta);
            ficheroadjunto.setDisposition(EmailAttachment.ATTACHMENT);
            ficheroadjunto.setDescription("Documento");
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("smtp.hostinger.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("noreply@reynaldomd.com", "2024-Daw"));
            email.setSSLOnConnect(true);
            email.setCharset("UTF-8");
            email.setFrom("noreply@reynaldomd.com");
            email.setSubject(this.asunto);
            email.setMsg(this.mensage);
            email.addTo(this.destinatario);

            email.attach(ficheroadjunto);
            email.send();
            return true;
        } catch (EmailException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        

    }
}
