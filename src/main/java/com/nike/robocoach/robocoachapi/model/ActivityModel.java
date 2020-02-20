package com.nike.robocoach.robocoachapi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ActivityModel implements Serializable {
    private static final long serialVersionUID = 6311662493159512307L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Sport sport;
    private Activity activity;
    private Athlete athlete;
    @Column(length = 1073741824)
    private String professionalImage;

    public ActivityModel() {
    }

    public ActivityModel(long id, Sport sport, Activity activity, Athlete athlete) {
        this.id = id;
        this.sport = sport;
        this.activity = activity;
        this.athlete = athlete;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public String getProfessionalImage() {
        return professionalImage;
    }

    public void setProfessionalImage(String professionalImage) {
        this.professionalImage = professionalImage;
    }
}


