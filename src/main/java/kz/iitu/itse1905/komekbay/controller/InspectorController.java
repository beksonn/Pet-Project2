package kz.iitu.itse1905.komekbay.controller;

import kz.iitu.itse1905.komekbay.model.Inspector;
import kz.iitu.itse1905.komekbay.model.Region;
import kz.iitu.itse1905.komekbay.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inspectors")
public class InspectorController {
    private Service service;

    @Autowired
    public void setService(Service service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<Inspector>> listAllInspector(){
        List<Inspector> inspectors =  service.listAllInspector();
        return ResponseEntity.ok(inspectors);
    }
}
