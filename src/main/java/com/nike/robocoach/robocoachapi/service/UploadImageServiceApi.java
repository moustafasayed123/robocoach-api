package com.nike.robocoach.robocoachapi.service;

import com.nike.robocoach.robocoachapi.exception.BusinessException;
import com.nike.robocoach.robocoachapi.model.RequestModel;
import com.nike.robocoach.robocoachapi.model.ResponseModel;

public interface UploadImageServiceApi {

    ResponseModel sendToCVModel(RequestModel requestModel) throws BusinessException;
}
