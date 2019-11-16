package com.sinopec.ldar.core.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

@Entity
public class UserResult implements Serializable {

    private static final long serialVersionUID = 5499430722247256919L;
    @Id
    private int id;
    private double UserId;
    private String Name;
    private String Password;
    private double PrdtCellId;
    private String PrdtCellSname;

    @Generated(hash = 900019307)
    public UserResult(int id, double UserId, String Name, String Password,
            double PrdtCellId, String PrdtCellSname) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
