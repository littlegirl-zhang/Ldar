package com.sinopec.ldar.core.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;

import org.greenrobot.greendao.annotation.Generated;

@Entity
public class UserResult implements Parcelable {
    private double UserId;
    private String Name;
    private String Password;
    private double PrdtCellId;
    private String PrdtCellSname;

    @Generated(hash = 371972321)
    public UserResult(double UserId, String Name, String Password,
            double PrdtCellId, String PrdtCellSname) {
        this.UserId = UserId;
        this.Name = Name;
        this.Password = Password;
        this.PrdtCellId = PrdtCellId;
        this.PrdtCellSname = PrdtCellSname;
    }

    @Generated(hash = 185447815)
    public UserResult() {
    }

    public double getUserId() {
        return UserId;
    }

    public void setUserId(double userId) {
        UserId = userId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public double getPrdtCellId() {
        return PrdtCellId;
    }

    public void setPrdtCellId(double prdtCellId) {
        PrdtCellId = prdtCellId;
    }

    public String getPrdtCellSname() {
        return PrdtCellSname;
    }

    public void setPrdtCellSname(String prdtCellSname) {
        PrdtCellSname = prdtCellSname;
    }

    @Override
    public String toString() {
        return "UserResult{" +
                "UserId=" + UserId +
                ", Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                ", PrdtCellId=" + PrdtCellId +
                ", PrdtCellSname='" + PrdtCellSname + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
