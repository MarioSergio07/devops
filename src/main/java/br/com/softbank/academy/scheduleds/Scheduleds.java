package br.com.softbank.academy.scheduleds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by bruno on 5/30/17.
 */

@Service
public class Scheduleds {

    private static final Logger LOGGER = LoggerFactory.getLogger(Scheduleds.class);

    @Scheduled(cron=" 0 01 17 * * * ")
    public void sendReport(){
        LOGGER.debug("::: "+this.getClass().getPackage().getName()+"."+this.getClass().getName()+".sendReport - Begin :::::: ");
        try{
            System.out.println("Executei....");
        } catch (RuntimeException e){
            LOGGER.error("::: "+this.getClass().getPackage().getName()+"."+this.getClass().getName()+".sendReport - Exception :::::: ", e);
        }
        LOGGER.debug("::: "+this.getClass().getPackage().getName()+"."+this.getClass().getName()+".sendReport - End :::::: ");
    }
}
