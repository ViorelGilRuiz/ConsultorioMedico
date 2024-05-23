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

/**
 *
 * @author oceans
 */
public class UtilidadEmailVgil {

    public UtilidadEmailVgil(String asunto, String mensage, String destinatario, String ruta) {
        this.asunto = asunto;
        this.mensage = mensage;
        this.destinatario = destinatario;
        this.ruta = ruta;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "UtilidadEmailVgil{" + "asunto=" + asunto
                + ", mensage=" + mensage + ", destinatario="
                + destinatario + ", ruta=" + ruta + '}';
    }

    String asunto;
    String mensage;
    String destinatario;
    String ruta;

    public  Boolean enviaremailsimple() {

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
            Logger.getLogger(UtilidadEmailVgil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public   Boolean enviaremailadjunto() {

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
            Logger.getLogger(UtilidadEmailVgil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
