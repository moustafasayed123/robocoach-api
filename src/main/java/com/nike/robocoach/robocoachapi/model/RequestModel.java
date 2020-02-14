package com.nike.robocoach.robocoachapi.model;

import java.io.Serializable;

public class RequestModel implements Serializable {
    private static final long serialVersionUID = -4184650075042955249L;
    private Activity activity;
    private Sport sport;
    private Athlete athlete;
    private String upmId;
    private String userImage;
    private int frameIndex;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public String getUpmId() {
        return upmId;
    }

    public void setUpmId(String upmId) {
        this.upmId = upmId;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public int getFrameIndex() {
        return frameIndex;
    }

    public void setFrameIndex(int frameIndex) {
        this.frameIndex = frameIndex;
    }
}
