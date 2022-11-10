package kz.iitu.itse1905.komekbay.controller;

import kz.iitu.itse1905.komekbay.model.Consumer;
import kz.iitu.itse1905.komekbay.model.Region;
import kz.iitu.itse1905.komekbay.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {
    private Service service;

    @Autowired
    public void setService(Service service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<Region>> listAllRegion(){
        List<Region> regions =  service.listAllRegion();
        return ResponseEntity.ok(regions);
    }

    @PostMapping(path = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> createRegion(@RequestBody Region newRegion) {
        return new ResponseEntity<>(service.createRegion(newRegion), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/header",method = RequestMethod.HEAD,produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Region>> findHeadRegion() {
        List<Region> regions = service.listAllRegion();
        return ResponseEntity.ok(regions);

    }

    @RequestMapping(value="/options", method = RequestMethod.OPTIONS)
    ResponseEntity<?> collectionOptionsRegion()
    {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET,HttpMethod.HEAD, HttpMethod.OPTIONS)
                .build();
    }

    @GetMapping(path = "/paging/{pageNO}/{pageSize}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<Region>> getAllItemWithPaging(
            @PathVariable int pageNO,
            @PathVariable int pageSize
    ){
        List<Region> regions = service.listAllRegionWithPagination(pageNO,pageSize);
        return ResponseEntity.ok(regions);
    }
}
