package com.adonai.simplehouse.security.register;

import com.adonai.simplehouse.model.Users;
import com.adonai.simplehouse.util.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
public class RegisterService {

    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    private JavaMailSender mailSender;

    public void onSaveRegister(Users user) throws Exception {
        registerRepository.save(user, GlobalVariables.dbName+"master");

    }

    public String onSendEmailConfirmation(Users user) {

        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail);
        Random randon = new Random();
        String ra = String.valueOf(randon.nextInt((999999 - 100000)+1)+100000);


        try {

            helper.setFrom("noreply@adonaisoft.com.br");
            helper.setSubject("Olá seja Bem vindo");
            helper.setText(onTextHtml(ra),true);
            helper.setTo(user.getEmail());
            mailSender.send(mail);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return ra;
    }

    public void onCreatedTenant(Users user){

    }

    public String onTextHtml(String code){
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\n" +
                "<head>\n" +
                "  <style>\n" +
                "    body {\n" +
                "      background-color: #E5E5E5;\n" +
                "    }\n" +
                "\n" +
                "    .table {\n" +
                "      margin-left: auto;\n" +
                "      margin-right: auto;\n" +
                "    }\n" +
                "  </style>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "  <table class=\"table\">\n" +
                "    <tr>\n" +
                "      <td></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td>\n" +
                "        <div style=\"width: 100%; background-color: #E5E5E5; font-family:sans-serif;justify-content: center;display:grid;\">\n" +
                "          <div style=\"margin-left: auto;\">\n" +
                "            <div style=\"width: 700px; background-color: aliceblue;\">\n" +
                "              <div style=\"width: 100%; height: 30%; background-color: #FFE6E1;display: flex;\">\n" +
                "                <div style=\"margin-left: 20px;\">\n" +
                "                  <img src=\"https://arquivos.adonaisoft.com.br/images/logo-simple.png\" alt=\"\">\n" +
                "                  <h3 style=\"font-size: 30px; margin-left: 45px;\">Olá este é o seu código de confirmação</h3>\n" +
                "                </div>\n" +
                "\n" +
                "              </div>\n" +
                "              <div style=\"height: 600px;background-color: #FFE6E1; display: flex;flex-direction: column;justify-content: center;align-items: center;\">\n" +
                "\n" +
                "                <div style=\"font-size: 25px; margin: 0px 20px 60px 20px; text-align: center;\">\n" +
                "                  Olá Ficamos felizes em saber que decidiu usar o app para ajudar na organização de sua casa\n" +
                "                  <p>Abaixo está o código para ativação da conta, insira-o no app:</p>\n" +
                "                  <br><br>\n" +
                "                  <p>\n" +
                "                  <H1>@@code</H1>\n" +
                "                  </p>\n" +
                "                </div>\n" +
                "\n" +
                "              </div>\n" +
                "              <div style=\"display: flex; align-items: center; height: 100px;\">\n" +
                "                <div style=\"margin-left: 40px;\">\n" +
                "                  2022 - Todos os direitos reservados a AdonaiSoft\n" +
                "                  conheça nossos produtos <a href=\"https://www.adonaisoft.com.br\">Aqui</a>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </table>\n" +
                "</body>\n" +
                "\n" +
                "</html>";



        return html.replace("@@code",code);
    }
}
