package com.riwi.encuestas.infrastructure.helpers;

import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class EmailHelper {
    // inyectar el servicio de email de la libreria
    private final JavaMailSender mailSender;

    public void sendMail(String nameCreator, String nameSurvey) {
        MimeMessage message = mailSender.createMimeMessage();

        String htmlContent = this.readHTMLTemplate(nameCreator, nameSurvey);

        try {
            message.setFrom(new InternetAddress("carlito1999@live.com"));
            message.setSubject("Cuestionario creado correctamente");

            message.setContent(htmlContent, MediaType.TEXT_HTML_VALUE);

            mailSender.send(message);
            System.out.println("Email enviado");
        } catch (Exception e) {
            System.out.println("no se pudo enviar el email" + e.getMessage());
        }

    }

    private String readHTMLTemplate(String nameCreator, String nameSurvey) {
        // indicar en donde se encuentra el template
        final java.nio.file.Path path = Paths.get("src/main/resources/emails/email_template.html");

        try (var lines = Files.lines(path)) {
            var html = lines.collect(Collectors.joining());

            return html.replace("{name}", nameCreator).replace("{survey}", nameSurvey);
        } catch (Exception e) {
            System.out.println("no se pudo leer el html");
            throw new RuntimeException();
        }
    }

}