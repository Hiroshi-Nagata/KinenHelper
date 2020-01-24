package com.example.kinenhelper3;

import java.util.Date;

import io.realm.RealmObject;

public class InitialData extends RealmObject {
    //    @PrimaryKey
    private Date quitSmokingDay;
    private int smokingNum;
    private int numberInBox;
    private int totalSmokingPeriod;
    private float nicotine;
    private float tar;

//    public Date getQuitSmokingDay() {
//        return quitSmokingDay;
//    }
//
//    public void setQuitSmokingDay(java.util.Date quitSmokingDay) {
//        this.quitSmokingDay = quitSmokingDay;
//    }

    public int getSmokingNum() {
        return smokingNum;
    }

    public void setSmokingNum(int smokingNum) {
        this.smokingNum = smokingNum;
    }

    public int getNumberInBox() {
        return numberInBox;
    }

    public void setNumberInBox(int numberInBox) {
        this.numberInBox = numberInBox;
    }

    public int getTotalSmokingPeriod() {
        return totalSmokingPeriod;
    }

    public void setTotalSmokingPeriod(int totalSmokingPeriod) {
        this.totalSmokingPeriod = totalSmokingPeriod;
    }

    public float getNicotine() {
        return nicotine;
    }

    public void setNicotine(float nicotine) {
        this.nicotine = nicotine;
    }

    public float getTar() {
        return tar;
    }

    public void setTar(float tar) {
        this.tar = tar;
    }
}
