package com.example.earthquake;

public class Earthquakes {

    private String mPlace;
    private String mDate;
    private String mPower;

    // Constructor
    public Earthquakes(String place, String date, String power) {
        mPlace = place;
        mDate = date;
        mPower = power;
    }
    //Getters and Setters for constructor
    public String getPlace() {
        return mPlace;
    }

    public void setPlace(String place) {
        mPlace = place;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getPower() {
        return mPower;
    }

    public void setPower(String power) {
        mPower = power;
    }
}
