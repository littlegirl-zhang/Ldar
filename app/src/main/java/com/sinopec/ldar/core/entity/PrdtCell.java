package com.sinopec.ldar.core.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class PrdtCell {
    private double OUId;
    private double OrgId;
    private String Name;
    private String Sname;
    private double ParentId;

    @Generated(hash = 1555303345)
    public PrdtCell(double OUId, double OrgId, String Name, String Sname,
            double ParentId) {
        this.OUId = OUId;
        this.OrgId = OrgId;
        this.Name = Name;
        this.Sname = Sname;
        this.ParentId = ParentId;
    }

    @Generated(hash = 150916261)
    public PrdtCell() {
    }

    public double getOUId() {
        return OUId;
    }

    public void setOUId(double OUId) {
        this.OUId = OUId;
    }

    public double getOrgId() {
        return OrgId;
    }

    public void setOrgId(double orgId) {
        OrgId = orgId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public double getParentId() {
        return ParentId;
    }

    public void setParentId(double parentId) {
        ParentId = parentId;
    }

    @Override
    public String toString() {
        return "PrdtCell{" +
                "OUId=" + OUId +
                ", OrgId=" + OrgId +
                ", Name='" + Name + '\'' +
                ", Sname='" + Sname + '\'' +
                ", ParentId=" + ParentId +
                '}';
    }
}
