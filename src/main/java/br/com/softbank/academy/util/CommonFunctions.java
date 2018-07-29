package br.com.softbank.academy.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by root on 17/11/17.
 */

@Component
public class CommonFunctions {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonFunctions.class);


    public String encode(String message) {
        return new Base64().encodeToString(message.getBytes());
    }

    public String decode(String message)  {
        return new String(new Base64().decode(message));
    }

    public int getHttpClientConnect(String parameter, String messageType){
        LOGGER.debug("::: " + this.getClass().getPackage().getName() + "." + this.getClass().getName() + ".getHttpClientConnect(final String url, String parameter, String messageType) - Begin ::::::");
        int statusCode;
        try{
            String url = "http://localhost:8010/sendEmail/?type=".concat(messageType);
            HttpClient client = new HttpClient();
            PostMethod postMethod = new PostMethod(url);
            StringRequestEntity requestEntity = new StringRequestEntity((parameter), "text/plain", "UTF-8");
            postMethod.setRequestEntity(requestEntity);
            statusCode = client.executeMethod(postMethod);
            if(statusCode != HttpStatus.SC_OK){
                LOGGER.error("::: "+this.getClass().getPackage().getName()+"."+this.getClass().getName()+".getHttpClientConnect(final String url, String parameter, String messageType)");
                throw new RuntimeException("Erro ao se comunicar com o serviço de Email, status " + statusCode);
            }
        } catch (IOException e){
            LOGGER.error("::: "+this.getClass().getPackage().getName()+"."+this.getClass().getName()+".getHttpClientConnect(final String url, String parameter, String messageType) - Exception :::::: ", e);
            throw new RuntimeException("Erro ao se comunicar com o serviço de Email");
        }
        LOGGER.debug("::: " + this.getClass().getPackage().getName() + "." + this.getClass().getName() + ".getHttpClientConnect(final String url, String parameter, String messageType) - End ::::::");
        LOGGER.error("Email Enviado");
        return statusCode;
    }

    public String getHostName() throws Exception{
        return  InetAddress.getLocalHost().getHostName();
    }

    public String getBrazilianDate(){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return  dateTimeFormatter.format(localDate);
    }

    public String getAmericanDate(){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return  dateTimeFormatter.format(localDate);
    }
}