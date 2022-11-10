package kz.iitu.itse1905.komekbay.controller;

import kz.iitu.itse1905.komekbay.model.BankAccount;
import kz.iitu.itse1905.komekbay.model.Consumer;
import kz.iitu.itse1905.komekbay.model.Region;
import kz.iitu.itse1905.komekbay.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bankAccounts")
public class BankAccountController {
    private Service service;

    @Autowired
    public void setService(Service service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<BankAccount>> listAllBankAccount(){
        List<BankAccount> bankAccounts =  service.listAllBankAccount();
        return ResponseEntity.ok(bankAccounts);
    }

    @GetMapping(value = "/{personalAccount}/{fillingMoney}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public ResponseEntity<String> fillUpBankAccount(@PathVariable(value = "personalAccount") int personalAccount,
                                                    @PathVariable(value = "fillingMoney") float fillingMoney){
        String messageForPayment = service.fillUpAccount(personalAccount,fillingMoney);
        return ResponseEntity.ok(messageForPayment);
    }
}
