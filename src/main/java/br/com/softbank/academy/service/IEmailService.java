package br.com.softbank.academy.service;

import br.com.softbank.academy.model.User;

public interface IEmailService {

     String MIMEMESSAGE = "1";
     String SIMPLEMAILMESSAGE = "2";

    void sendEmailWelcome(User user);
}
