package kz.iitu.itse1905.komekbay.service;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReciever {

    private Integer servicePayment;

    @JmsListener(destination = "queue", containerFactory = "myFactory")
    public void receiveMessage(Integer servicePayment) {
        this.servicePayment = servicePayment;
    }

    public Integer messageInQueue(){
        return servicePayment;
    }

}
