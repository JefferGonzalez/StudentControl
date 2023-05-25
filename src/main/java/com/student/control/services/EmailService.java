package com.student.control.services;

import com.student.control.dto.EmailDetails;
import com.student.control.interfaces.EmailModel;
import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailModel {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String sendMail(EmailDetails details) {
        try {
            MimeMessage mailMessage = javaMailSender.createMimeMessage();
            mailMessage.setFrom(sender);

            mailMessage.setRecipients(MimeMessage.RecipientType.TO, details.getRecipientAddress());

            String htmlContent = "<!DOCTYPE html>\n"
                    + "<html lang=\"es\">\n"
                    + "\n"
                    + "<head>\n"
                    + "  <style>\n"
                    + "    .table {\n"
                    + "      width: 100%;\n"
                    + "      max-width: 100%;\n"
                    + "      margin-bottom: 1rem;\n"
                    + "      background-color: transparent;\n"
                    + "      border-collapse: collapse;\n"
                    + "    }\n"
                    + "\n"
                    + "    .table-dark {\n"
                    + "      color: #fff;\n"
                    + "      background-color: #343a40;\n"
                    + "    }\n"
                    + "\n"
                    + "    .table-striped-columns tbody tr:nth-child(even) {\n"
                    + "      background-color: rgba(0, 0, 0, .05);\n"
                    + "    }\n"
                    + "  </style>\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "  <table class=\"table table-dark table-striped-columns\">\n"
                    + "    <thead>\n"
                    + "      <tr>\n"
                    + "        <th scope=\"col\">#</th>\n"
                    + "        <th scope=\"col\">NOTA</th>\n"
                    + "        <th scope=\"col\">PORCENTAJE</th>\n"
                    + "        <th scope=\"col\">CORTE</th>\n"
                    + "      </tr>\n"
                    + "    </thead>\n"
                    + "    <tbody>\n"
                    + "      <tr>\n"
                    + "        <th scope=\"row\">2</th>\n"
                    + "        <td>4.3</td>\n"
                    + "        <td>30%</td>\n"
                    + "        <td>1</td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <th scope=\"row\">3</th>\n"
                    + "        <td>4.3</td>\n"
                    + "        <td>30%</td>\n"
                    + "        <td>1</td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <th scope=\"row\">4</th>\n"
                    + "        <td>4.3</td>\n"
                    + "        <td>30%</td>\n"
                    + "        <td>1</td>\n"
                    + "      </tr>\n"
                    + "    </tbody>\n"
                    + "  </table>\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>";

            mailMessage.setContent(details.getBody(), "text/html; charset=utf-8");

            mailMessage.setSubject(details.getSubject());

            javaMailSender.send(mailMessage);
            return "El correo fue enviado con éxito...";
        } catch (Exception e) {
            return "Error enviando el correo, intente más tarde.";
        }
    }

    @Override
    public String sendMailWithAttachment(EmailDetails details) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipientAddress());
            mimeMessageHelper.setText(details.getBody());
            mimeMessageHelper.setSubject(details.getSubject());

            FileSystemResource file = new FileSystemResource(new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(file.getFilename(), file);

            javaMailSender.send(mimeMessage);
            return "El correo fue enviado con éxito...";
        } catch (MessagingException e) {
            return "Error enviando el correo, intente más tarde.";
        }
    }

}
