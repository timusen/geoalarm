package com.chadov.getalarm.model;

import java.util.StringTokenizer;
import java.util.UUID;

/**
 * Created by ChadovTA on 16.10.2017.
 */

public class Geofence {

    private UUID mId;
    private String mName;
    private double mLatitude;
    private double mLongitude;
    private int mRadius;
    private boolean mActive;


    public Geofence(String name, double latitude, double longitude, int radius) {
        mName = name;
        mId = UUID.randomUUID();
        mLatitude = latitude;
        mLongitude = longitude;
        mRadius = radius;
        mActive = false;
    }

    public UUID getId() {
        return mId;
    }
    public void setId(UUID Id) {
        this.mId = Id;
    }

    public String getName() {
        return  mName;
    }
    public void setName(String name) { mName = name; }

    public double getLatitude() { return mLatitude; }
    public void   getLatitude(double lat) { mLatitude = lat; }

    public double getLongitude() { return mLongitude; }
    public void   setLongitude(double longitude) { mLongitude = longitude; }

    public int    getRadius() { return mRadius; }
    public void   setRadius(int radius) { mRadius = radius; }

    public boolean isActive() { return mActive; }
    public void    setActive(boolean value) { mActive = value; }
}

