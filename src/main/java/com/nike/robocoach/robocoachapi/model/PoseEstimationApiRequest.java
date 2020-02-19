package com.nike.robocoach.robocoachapi.model;

import java.io.Serializable;

public class PoseEstimationApiRequest implements Serializable {
    private static final long serialVersionUID = -721636684063597434L;
    private String userImage;

    public PoseEstimationApiRequest() {
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
}
