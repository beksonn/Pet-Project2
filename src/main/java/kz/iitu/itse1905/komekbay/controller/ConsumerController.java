package kz.iitu.itse1905.komekbay.controller;

import kz.iitu.itse1905.komekbay.model.Consumer;
import kz.iitu.itse1905.komekbay.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/consumers")
public class ConsumerController {

    private Service service;

    @Autowired
    public void setService(Service service) {
        this.service = service;
    }



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<Consumer>> listAllConsumer(@RequestHeader Map<String,String> headers){
        headers.forEach((key,value) ->{
            System.out.println("Header Name: "+key+" Header Value: "+value);
        });
        List<Consumer> consumers =  service.listAllConsumer();
        return ResponseEntity.ok(consumers);
    }

    @PostMapping(path = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> createConsumer(@RequestBody Consumer newConsumer) {
        return new ResponseEntity<>(service.createConsumer(newConsumer), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{personalAccount}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<String> updateConsumerById(@RequestBody Consumer updConsumer,
                                                     @PathVariable(value = "personalAccount") int personalAccount) {
        return ResponseEntity.ok(service.updateConsumerById(updConsumer, personalAccount));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public ResponseEntity<String> deleteConsumerByPersonalAccount(@PathVariable(value = "id") int personalAccount){
        return ResponseEntity.ok(service.deleteConsumerByPersonalAccount(personalAccount));
    }



    @GetMapping(value = "/{idOfRegion}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public ResponseEntity<List<Consumer>> listConsumerByRegion(@PathVariable(value = "idOfRegion") int id){
        List<Consumer> consumers =  service.listConsumerByRegion(id);
        return ResponseEntity.ok(consumers);
    }

    @GetMapping(value = "/{personalAccount}/{meterReading}/{checkOrPay}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public ResponseEntity<String> makeBillToConsumerByPersonalAccount(@PathVariable(value = "personalAccount") int personalAccount,
                                                                      @PathVariable(value = "meterReading") float meterReading,
                                                                      @PathVariable(value = "checkOrPay") String checkOrPay){
        String messageForPayment = service.makeBillToConsumerByPersonalAccount(personalAccount,meterReading, checkOrPay);
        return ResponseEntity.ok(messageForPayment);
    }

    @GetMapping(value = "/callInspector/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public ResponseEntity<String> callInspector(@PathVariable(value = "id") int id){
        String message = service.callInspector(id);
        return ResponseEntity.ok(message);
    }

    @GetMapping(value = "/{personalAccount}/payInspector/{id}/{checkOrPay}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public ResponseEntity<String> payInspector(@PathVariable(value = "id") int id,
                                                                      @PathVariable(value = "personalAccount") int personalAccount,
                                                                      @PathVariable(value = "checkOrPay") String checkOrPay){
        String message = service.payInspector(personalAccount,id,checkOrPay);
        return ResponseEntity.ok(message);
    }
}
