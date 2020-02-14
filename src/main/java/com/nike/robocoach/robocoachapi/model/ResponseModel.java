package com.nike.robocoach.robocoachapi.model;

import java.io.Serializable;
import java.util.List;

public class ResponseModel implements Serializable {

    private static final long serialVersionUID = -5631465757765329046L;
    private int frameIndex;
    private List<Coordinate> athleteCoordinates;
    private List<Coordinate> userCoordinates;
    private double frameScore;

    public ResponseModel(int frameIndex, List<Coordinate> athleteCoordinates, List<Coordinate> userCoordinates, double frameScore) {
        this.frameIndex = frameIndex;
        this.athleteCoordinates = athleteCoordinates;
        this.userCoordinates = userCoordinates;
        this.frameScore = frameScore;
    }

    public int getFrameIndex() {
        return frameIndex;
    }

    public void setFrameIndex(int frameIndex) {
        this.frameIndex = frameIndex;
    }

    public List<Coordinate> getAthleteCoordinates() {
        return athleteCoordinates;
    }

    public void setAthleteCoordinates(List<Coordinate> athleteCoordinates) {
        this.athleteCoordinates = athleteCoordinates;
    }

    public List<Coordinate> getUserCoordinates() {
        return userCoordinates;
    }

    public void setUserCoordinates(List<Coordinate> userCoordinates) {
        this.userCoordinates = userCoordinates;
    }

    public double getFrameScore() {
        return frameScore;
    }

    public void setFrameScore(double frameScore) {
        this.frameScore = frameScore;
    }
}
