package com.example.kinenhelper3;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class InitialData extends RealmObject {
//    @PrimaryKey
    private Date quitSmokingDay;
    private int smokingNum;
    private int numberInBox;
    private int totalSmokingPeriod;
    private int nicotine;
    private int tar;

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

    public int getNicotine() {
        return nicotine;
    }

    public void setNicotine(int nicotine) {
        this.nicotine = nicotine;
    }

    public int getTar() {
        return tar;
    }

    public void setTar(int tar) {
        this.tar = tar;
    }
}
