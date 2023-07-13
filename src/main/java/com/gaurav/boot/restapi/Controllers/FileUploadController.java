package com.gaurav.boot.restapi.Controllers;

import com.gaurav.boot.restapi.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
  // this comment inserted by shyamTesting branch
    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        try {

            System.out.println(file.getOriginalFilename());
            System.out.println(file.getName());
            System.out.println(file.getSize());
            System.out.println(file.getContentType());
            System.out.println(file.hashCode());
            System.out.println("shyam");

            //If file is empty
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request must contain file");
            }

            boolean f = fileUploadHelper.uploadFile(file);
            if (f){
                return ResponseEntity.ok("File is successfully uploaded");
            }

        }catch (Exception exception)   {
            exception.printStackTrace();

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Working and testing ");
    }

}
