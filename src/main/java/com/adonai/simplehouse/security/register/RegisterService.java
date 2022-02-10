package com.adonai.simplehouse.security.register;

import com.adonai.simplehouse.model.Users;
import com.adonai.simplehouse.util.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class RegisterService {

    @Autowired
    RegisterRepository registerRepository;

    public void onSaveRegister(Users user){
        registerRepository.save(user, GlobalVariables.dbName+"master");
    }

    public void onSendEmailConfirmation(Users user){
        String to = user.getEmail();

        String from = "noreply@adonaisoft.com.br";
        String userName = "Simple House";
        String password = "553322@@##";

        String host = "mail.adonaisoft.com.br";

        Properties props = new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("Simple House","553322@@##");
            }
        });

        try{
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Casa Simples");

            message.setContent("<h1>Olá é um teste</h1>","text/html");
            Transport.send(message);

        }  catch (MessagingException ex){
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public void onCreatedTenant(Users user){

    }
}
