/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Aprendiz
 */
public class Mailer {

    public static void send(String para, String sujeto, String mensaje) throws UnsupportedEncodingException {

        final String user = "santamartaflowers@gmail.com";//cambiará en consecuencia al servidor utilizado
        final String pass = "flowersx";
        String nuevoMensaje = "<h1 style=\"font-size: 20px; color:#0C0; font-weight: bold; text-transform: uppercase ; \">Correo de Prueba" + "</h1>" + "<img src='https://lh3.googleusercontent.com/-oO-7N-Wpc3Q/AAAAAAAAAAI/AAAAAAAAAAw/fycSKvFah3c/s125-c-k-no/photo.jpg'/ style=\"float: left;\"><p>" + mensaje + "<br>\n"
                + "<p style=\"text-align: center; color: #307EDF\">\n"
                + "</p> \n"
                + "<br>\n"
                + "<p style=\"color:#0C0;font-weight: bold;\" > Gracias por formar parte de nuestra comunidad. </p> ";
//1st paso) Obtener el objeto de sesión

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", "smtp.gmail.com"); // envia 
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.starttls.required", "false");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

//2nd paso)compose message
        try {
            //Archivos adjuntos
            BodyPart texto = new MimeBodyPart();
            texto.setContent(nuevoMensaje, "text/html");
            //BodyPart adjunto = new MimeBodyPart();
            //adjunto.setDataHandler(new DataHandler(new FileDataSource("d:/cartagena.txt")));
            //adjunto.setFileName("cartagena.txt");

            MimeMultipart multiparte = new MimeMultipart();
            multiparte.addBodyPart(texto);
            //multiparte.addBodyPart(adjunto);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user, ""));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(para));
            message.setSubject(sujeto);
            message.setContent(multiparte, "text/html; charset=utf-8");

            //3rd paso)send message
            Transport.send(message);

            System.out.println("Enviado");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}
