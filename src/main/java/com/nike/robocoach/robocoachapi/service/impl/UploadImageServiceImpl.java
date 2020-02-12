package com.nike.robocoach.robocoachapi.service.impl;

import com.nike.robocoach.robocoachapi.exception.FileStorageException;
import com.nike.robocoach.robocoachapi.service.UploadImageServiceApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class UploadImageServiceImpl implements UploadImageServiceApi {

    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;

    @Override
    public void uploadImage(MultipartFile file) {
        try {
            Path copyLocation = Paths
                    .get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store file " + file.getOriginalFilename()
                    + ". Please try again!");
        }
    }
}
