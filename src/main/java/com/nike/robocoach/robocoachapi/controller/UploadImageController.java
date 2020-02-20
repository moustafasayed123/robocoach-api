package com.nike.robocoach.robocoachapi.controller;

import com.nike.robocoach.robocoachapi.exception.BusinessException;
import com.nike.robocoach.robocoachapi.model.ActivityModel;
import com.nike.robocoach.robocoachapi.model.RequestModel;
import com.nike.robocoach.robocoachapi.model.ResponseModel;
import com.nike.robocoach.robocoachapi.service.UploadImageServiceApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/activity/addActivity")
    public ResponseEntity<Object> addActivity(@RequestBody ActivityModel activityModel) {
        try {
            logger.info("calling addActivity controller function");
            ActivityModel result = uploadImageService.addActivity(activityModel);
            return ResponseEntity.ok().body(result.getId());
        } catch (BusinessException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/activity/getActivity/{id}")
    public ResponseEntity<Object> getActivity(@PathVariable long id) {
        try {
            logger.info("calling getActivity controller function");
            ActivityModel result = uploadImageService.getActivity(id);
            if (result != null)
                return ResponseEntity.ok().body(result);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no record matches your search");
        } catch (BusinessException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/activity/loadAll")
    public ResponseEntity<Object> getAllActivity() {
        try {
            logger.info("calling getAllActivity controller function");
            List<ActivityModel> result = uploadImageService.getAllActivity();
            return ResponseEntity.ok().body(result);
        } catch (BusinessException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
