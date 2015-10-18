package com.app.devfest.nyeri.staterestoration.model;

/**
 * Created by Mac on 10/17/2015.
 */
public class SportActivity {

    private String name;
    private String venueName;
    private String photoUrl;
    private boolean isFree;

    public SportActivity(String name, String venueName, String photoUrl, boolean isFree) {
        this.name = name;
        this.venueName = venueName;
        this.photoUrl = photoUrl;
        this.isFree = isFree;
    }

    public String getName() {
        return name;
    }

    public String getVenueName() {
        return venueName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public boolean isFree() {
        return isFree;
    }
}
