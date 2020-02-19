package com.nike.robocoach.robocoachapi.controller;

import com.nike.robocoach.robocoachapi.model.RequestModel;
import com.nike.robocoach.robocoachapi.model.ResponseModel;
import com.nike.robocoach.robocoachapi.service.UploadImageServiceApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UploadImageController {

    @Autowired
    UploadImageServiceApi uploadImageService;
    private static final Logger logger = LogManager.getLogger(UploadImageController.class);

    @PostMapping("/uploadImage")
    public ResponseEntity<Object> uploadImage(@RequestBody RequestModel requestModel) {
        try {
            logger.info("calling uploadImage controller function");
            ResponseModel responseModel = uploadImageService.sendToCVModel(requestModel);
            return ResponseEntity.ok().body(responseModel);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
