package kz.iitu.itse1905.komekbay.controller;

import kz.iitu.itse1905.komekbay.model.Doc;
import kz.iitu.itse1905.komekbay.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/docs")
public class DocController {
    private Service service;


    @Autowired
    public void setService(Service service) {
        this.service = service;
    }


    @GetMapping("/")
    public List<Doc> get(Model model){
        List<Doc> docs = service.getFiles();
        return docs;
    }

    @PostMapping("/upload")
    public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
        for (MultipartFile file: files){
            service.saveFile(file);
        }
        return files.length + " Files Uploaded";
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId){
        Doc doc = service.getFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(doc.getDocType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=/" + doc.getDocName()+"\"")
                .body(new ByteArrayResource(doc.getData()));
    }
}
