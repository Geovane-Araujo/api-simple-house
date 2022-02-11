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
            helper.setText(onTextHtml("5565654"),true);
            helper.setTo(user.getEmail());
            mailSender.send(mail);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void onCreatedTenant(Users user){

    }

    public String onTextHtml(String code){
        String html = "<head>\n" +
                "  <style>\n" +
                "    body{\n" +
                "      height: 100vh;\n" +
                "      width: 100vw;\n" +
                "      background-color: #E5E5E5;\n" +
                "      margin: 0;\n" +
                "      font-family: 'Roboto', sans-serif;\n" +
                "    }\n" +
                "    .body{\n" +
                "      display: flex;\n" +
                "      justify-content: center;\n" +
                "      align-items: center;\n" +
                "      height: 100%;\n" +
                "      width: 100%;\n" +
                "    }\n" +
                "    .card-header{\n" +
                "      height: 95vh;\n" +
                "      width: 700px;\n" +
                "      background-color: aliceblue;\n" +
                "    }\n" +
                "    .top{\n" +
                "      width: 100%;\n" +
                "      height: 30%;\n" +
                "      margin: 0;\n" +
                "      background-color: #FFE6E1;\n" +
                "      justify-content: left;\n" +
                "      align-items: center;\n" +
                "      display: flex;\n" +
                "      \n" +
                "    }\n" +
                "    .center{\n" +
                "      width: 100%;\n" +
                "      height: 60%;\n" +
                "      background-color: #FFE6E1;\n" +
                "      display: flex;\n" +
                "      flex-direction: column;\n" +
                "      justify-content: center;\n" +
                "      align-items: center;\n" +
                "    }\n" +
                "    .text{\n" +
                "      font-size: 30px;\n" +
                "      margin-left: 45px;\n" +
                "    }\n" +
                "    .botton{\n" +
                "      display: flex;\n" +
                "      align-items: center;\n" +
                "      width: 100%;\n" +
                "      height: 10%;\n" +
                "    }\n" +
                "    .code{\n" +
                "      height: 40px;\n" +
                "      width: 200px;\n" +
                "      background-color: bisque;\n" +
                "      display: flex;\n" +
                "      justify-content: center;\n" +
                "      align-items: center;\n" +
                "    }\n" +
                "    .text-center{\n" +
                "      font-size: 25px;\n" +
                "      margin: 0px 20px 60px 20px;\n" +
                "      text-align: center;\n" +
                "    }\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div class=\"body\">\n" +
                "    <div class=\"card-header\">\n" +
                "      <div class=\"top\">\n" +
                "        <div style=\"margin-left: 20px;\">\n" +
                "          <img src=\"https://arquivos.adonaisoft.com.br/images/logo-simple.png\" alt=\"\">\n" +
                "          <h3 class=\"text\">Olá este é o seu código de confirmação</h3>\n" +
                "        </div>\n" +
                "        \n" +
                "      </div>\n" +
                "      <div class=\"center\">\n" +
                "        \n" +
                "        <div class=\"text-center\">\n" +
                "          Olá Ficamos felizes em saber que decidiu usar o app para ajudar na organização de sua casa\n" +
                "          <p>Abaixo está o código para ativação da conta, insira-o no app:</p>\n" +
                "        </div>\n" +
                "        <div class=\"code\">\n" +
                "            <h1>@@code</h1>\n" +
                "        </div>\n" +
                "        \n" +
                "      </div>\n" +
                "      <div class=\"botton\">\n" +
                "        <div style=\"margin-left: 40px;\">\n" +
                "          2022 - Todos os direitos reservados a AdonaiSoft\n" +
                "          conheça nossos produtos <a href=\"https:www.adonaisoft.com.br\">Aqui</a>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</body>";



        return html.replace("@@code",code);
    }
}
