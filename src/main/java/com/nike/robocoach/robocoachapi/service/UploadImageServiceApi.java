package com.nike.robocoach.robocoachapi.service;

import com.nike.robocoach.robocoachapi.exception.BusinessException;
import com.nike.robocoach.robocoachapi.model.RequestModel;
import com.nike.robocoach.robocoachapi.model.ResponseModel;

import java.io.IOException;

public interface UploadImageServiceApi {

    ResponseModel sendToCVModel(RequestModel requestModel) throws BusinessException, IOException;
}
