package com.nike.robocoach.robocoachapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nike.robocoach.robocoachapi.exception.BusinessException;
import com.nike.robocoach.robocoachapi.model.*;
import com.nike.robocoach.robocoachapi.service.UploadImageServiceApi;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UploadImageServiceImpl implements UploadImageServiceApi {
    private static final Logger logger = LogManager.getLogger(UploadImageServiceImpl.class);
    final String modelApiUrl = "http://robocoachlb-1485644589.us-west-2.elb.amazonaws.com:8081/v1/estimate/pose";
    // final String modelApiUrl = "http://localhost:8081/v1/estimate/pose";

    @Override
    public ResponseModel sendToCVModel(RequestModel requestModel) throws BusinessException, IOException {
        logger.info("calling sendToCVModel service function ");
        PoseEstimationApiResponse user = extractCoordinateFromMlResponse(callPoseEstimationModelAPI(requestModel.getUserImage()));
        PoseEstimationApiResponse professional = extractCoordinateFromMlResponse(callPoseEstimationModelAPI(requestModel.getProfessionalImage()));

        List<Coordinate> userCoordinates = user.getBodyPart().values().stream().map(element -> new Coordinate(element[0], element[1])).collect(Collectors.toList());
        List<Coordinate> profCoordinates = professional.getBodyPart().values().stream().map(element -> new Coordinate(element[0], element[1])).collect(Collectors.toList());

        return new ResponseModel(requestModel.getFrameIndex(), profCoordinates, userCoordinates, calculateFormFactor(user, professional));
    }

    private CloseableHttpResponse callPoseEstimationModelAPI(String image) throws BusinessException {
        try {
            logger.info("calling callPoseEstimationModelAPI service function ");
            PoseEstimationApiRequest poseEstimationApiRequest = new PoseEstimationApiRequest();
            poseEstimationApiRequest.setUserImage(image);
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(modelApiUrl);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = Obj.writeValueAsString(poseEstimationApiRequest);

            StringEntity entity = new StringEntity(jsonStr);
            httpPost.setEntity(entity);
            httpPost.setHeader("content-type", "application/json");
            CloseableHttpResponse response = client.execute(httpPost);
            logger.info(response);
            client.close();
            return response;
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    private PoseEstimationApiResponse extractCoordinateFromMlResponse(CloseableHttpResponse closeableHttpResponse) throws IOException {

        logger.info("calling extractCoordinateFromMlResponse service function ");
        String json = EntityUtils.toString(closeableHttpResponse.getEntity());

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        JsonObject data = jsonObject.getAsJsonObject("body_parts");
        Map<String, Double[]> bodyParts = new HashMap<>();

        for (String key : data.keySet()) {
            Double[] temp = new Double[2];
            temp[0] = data.get(key).getAsJsonArray().get(0).getAsDouble();
            temp[1] = data.get(key).getAsJsonArray().get(1).getAsDouble();
            bodyParts.put(key, temp);
        }
        BigInteger bodyArea = jsonObject.getAsJsonPrimitive("body_area").getAsBigInteger();

        return new PoseEstimationApiResponse(bodyParts, bodyArea);
    }

    private double calculateFormFactor(PoseEstimationApiResponse user, PoseEstimationApiResponse professional) {
        logger.info("calling calculateFormFactor service function ");
        Map<String, Double> coordinateResult = new HashMap<>();
        for (String key : user.getBodyPart().keySet()) {
            Double[] userCoordinate = user.getBodyPart().get(key);
            Double[] profCoordinate = professional.getBodyPart().get(key);
            coordinateResult.put(key, Math.sqrt(((userCoordinate[1] - profCoordinate[1]) * (userCoordinate[1] - profCoordinate[1]))
                    + ((userCoordinate[0] - profCoordinate[0]) * (userCoordinate[0] - profCoordinate[0]))));
        }
        double sum = coordinateResult.values().stream().reduce(0.0, Double::sum);
        logger.info("final score is " + (sum / 17) / 640);
        return (sum / 17) / 640;
    }
}

