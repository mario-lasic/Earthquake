package com.example.earthquake;

public class Earthquakes {

    private String mPlace;
    private long mDate;
    private Double mPower;



    // Constructor
    public Earthquakes(String place, long date, Double power) {
        mPlace = place;
        mDate = date;
        mPower = power;
    }

    //Getters and Setters
    public String getPlace() {
        return mPlace;
    }

    public void setPlace(String place) {
        mPlace = place;
    }

    public long getDate() {
        return mDate;
    }

    public void setDate(long date) {
        mDate = date;
    }

    public Double getPower() {
        return mPower;
    }

    public void setPower(Double power) {
        mPower = power;
    }

}
