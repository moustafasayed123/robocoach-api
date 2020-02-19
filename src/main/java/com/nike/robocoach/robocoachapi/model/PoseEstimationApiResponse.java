package com.nike.robocoach.robocoachapi.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Map;

public class PoseEstimationApiResponse implements Serializable {
    private static final long serialVersionUID = 3784521074441098327L;

    private Map<String, Double[]> bodyPart;
    private BigInteger bodayArea;

    public PoseEstimationApiResponse(Map<String, Double[]> bodyPart, BigInteger bodayArea) {
        this.bodyPart = bodyPart;
        this.bodayArea = bodayArea;
    }

    public Map<String, Double[]> getBodyPart() {
        return bodyPart;
    }

    public BigInteger getBodayArea() {
        return bodayArea;
    }
}
