package com.sinopec.ldar.mvp.model.entity;

import java.io.Serializable;

public class UserResult implements Serializable {
    private double UserId;
    private String Name;
    private String Password;
    private double PrdtCellId;
    private String PrdtCellSname;

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
}
