package br.com.softbank.academy.service;

import br.com.softbank.academy.model.User;
import br.com.softbank.academy.util.CommonFunctions;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService implements IEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    private CommonFunctions commonFunctions = new CommonFunctions();

    @Override
    public void sendEmailWelcome(User user) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("Acesso Liberado");
        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setFrom("bruno.softbank@gmail.com");
        simpleMailMessage.setText("Seja bem vindo a Softbank.");
        sendEmail(simpleMailMessage);
    }

    private void sendEmail(SimpleMailMessage simpleMailMessage){
        LOGGER.debug("::: "+this.getClass().getPackage().getName()+"."+this.getClass().getName()+".sendSimpleMailMessage(SimpleMailMessage simpleMailMessage) - Begin :::::: ");
        try{
            Gson gson = new Gson();
            String parameters = gson.toJson(simpleMailMessage);
            commonFunctions.getHttpClientConnect(parameters, SIMPLEMAILMESSAGE);

        } catch (Exception ex){
            LOGGER.error("::: "+this.getClass().getPackage().getName()+"."+this.getClass().getName()+".sendSimpleMailMessage(SimpleMailMessage simpleMailMessage) - Exception :::::: ", ex);
            throw new RuntimeException(ex);
        }
        LOGGER.debug("::: "+this.getClass().getPackage().getName()+"."+this.getClass().getName()+".sendSimpleMailMessage(SimpleMailMessage simpleMailMessage)) - End :::::: ");
    }
}
