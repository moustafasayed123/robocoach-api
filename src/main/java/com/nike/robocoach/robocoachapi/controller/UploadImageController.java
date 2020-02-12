package com.nike.robocoach.robocoachapi.controller;

import com.nike.robocoach.robocoachapi.service.UploadImageServiceApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadImageController {

    @Autowired
    UploadImageServiceApi uploadImageService;
    private static final Logger logger = LogManager.getLogger(UploadImageController.class);

    /**
     * just for test, this function will be removed later
     * @param name
     * @return
     */
    @GetMapping("/welcome/{name}")
    public ResponseEntity<Object> welcomeUser(@PathVariable String name) {
        try {
            logger.info("welcomeUser function");
            return ResponseEntity.ok().body("welcome: " + name);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<Object> uploadImage(@RequestParam("image") MultipartFile image) {
        try{
            logger.info("calling uploadImage function");
            uploadImageService.uploadImage(image);
            return ResponseEntity.ok().body("file uploaded" );
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

}
