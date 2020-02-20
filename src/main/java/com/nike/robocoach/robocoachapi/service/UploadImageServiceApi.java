package com.nike.robocoach.robocoachapi.service;

import com.nike.robocoach.robocoachapi.exception.BusinessException;
import com.nike.robocoach.robocoachapi.model.ActivityModel;
import com.nike.robocoach.robocoachapi.model.RequestModel;
import com.nike.robocoach.robocoachapi.model.ResponseModel;

import java.io.IOException;
import java.util.List;

public interface UploadImageServiceApi {

    ResponseModel sendToCVModel(RequestModel requestModel) throws BusinessException, IOException;

    ActivityModel addActivity(ActivityModel activityModel) throws BusinessException;

    ActivityModel getActivity(long uuid) throws BusinessException;

    List<ActivityModel> getAllActivity() throws BusinessException;
}
