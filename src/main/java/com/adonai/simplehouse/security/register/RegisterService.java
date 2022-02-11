package com.adonai.simplehouse.security.register;

import com.adonai.simplehouse.model.Users;
import com.adonai.simplehouse.util.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class RegisterService {

    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    private JavaMailSender mailSender;

    public void onSaveRegister(Users user){
        registerRepository.save(user, GlobalVariables.dbName+"master");
    }

    public void onSendEmailConfirmation(Users user) {

        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail);

        try {

            helper.setFrom("noreply@adonaisoft.com.br");
            helper.setSubject("Olá seja Bem vindo");
            helper.setText("<h1>Thunai</h1>",true);
            helper.setTo(user.getEmail());
            mailSender.send(mail);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void onCreatedTenant(Users user){

    }
}
