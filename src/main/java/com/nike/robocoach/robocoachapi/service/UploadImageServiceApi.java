package com.nike.robocoach.robocoachapi.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadImageServiceApi {

    void uploadImage(MultipartFile file);
}
