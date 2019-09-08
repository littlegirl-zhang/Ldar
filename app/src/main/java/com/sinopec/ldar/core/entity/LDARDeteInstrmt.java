package com.sinopec.ldar.core.entity;

public class LDARDeteInstrmt {
    private double LDARDeteInstrmtId;
    private double CompanyId;
    private String CompanyName;
    private String Num;
    private String Name;
    private String Model;
    private double LDARDeteInstrmtTypeId;
    private String LDARDeteInstrmtTypeName;
    private String PrdtManufactor;

    public double getLDARDeteInstrmtId() {
        return LDARDeteInstrmtId;
    }

    public void setLDARDeteInstrmtId(double LDARDeteInstrmtId) {
        this.LDARDeteInstrmtId = LDARDeteInstrmtId;
    }

    public double getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(double companyId) {
        CompanyId = companyId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getNum() {
        return Num;
    }

    public void setNum(String num) {
        Num = num;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public double getLDARDeteInstrmtTypeId() {
        return LDARDeteInstrmtTypeId;
    }

    public void setLDARDeteInstrmtTypeId(double LDARDeteInstrmtTypeId) {
        this.LDARDeteInstrmtTypeId = LDARDeteInstrmtTypeId;
    }

    public String getLDARDeteInstrmtTypeName() {
        return LDARDeteInstrmtTypeName;
    }

    public void setLDARDeteInstrmtTypeName(String LDARDeteInstrmtTypeName) {
        this.LDARDeteInstrmtTypeName = LDARDeteInstrmtTypeName;
    }

    public String getPrdtManufactor() {
        return PrdtManufactor;
    }

    public void setPrdtManufactor(String prdtManufactor) {
        PrdtManufactor = prdtManufactor;
    }

    @Override
    public String toString() {
        return "LDARDeteInstrmt{" +
                "LDARDeteInstrmtId=" + LDARDeteInstrmtId +
                ", CompanyId=" + CompanyId +
                ", CompanyName='" + CompanyName + '\'' +
                ", Num='" + Num + '\'' +
                ", Name='" + Name + '\'' +
                ", Model='" + Model + '\'' +
                ", LDARDeteInstrmtTypeId=" + LDARDeteInstrmtTypeId +
                ", LDARDeteInstrmtTypeName='" + LDARDeteInstrmtTypeName + '\'' +
                ", PrdtManufactor='" + PrdtManufactor + '\'' +
                '}';
    }
}
