package com.sinopec.ldar.core.entity;

import java.util.Date;

public class LDARStdGas {

    private double LDARStdGasId;
    private double CompanyId;
    private String CompanyName;
    private String Num;
    private String Name;
    private double CnctValue;
    private Date EffDate;
    private double ExtendUncertainty;
    private String Des;

    public double getLDARStdGasId() {
        return LDARStdGasId;
    }

    public void setLDARStdGasId(double LDARStdGasId) {
        this.LDARStdGasId = LDARStdGasId;
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

    public double getCnctValue() {
        return CnctValue;
    }

    public void setCnctValue(double cnctValue) {
        CnctValue = cnctValue;
    }

    public Date getEffDate() {
        return EffDate;
    }

    public void setEffDate(Date effDate) {
        EffDate = effDate;
    }

    public double getExtendUncertainty() {
        return ExtendUncertainty;
    }

    public void setExtendUncertainty(double extendUncertainty) {
        ExtendUncertainty = extendUncertainty;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }

    @Override
    public String toString() {
        return "LDARStdGas{" +
                "LDARStdGasId=" + LDARStdGasId +
                ", CompanyId=" + CompanyId +
                ", CompanyName='" + CompanyName + '\'' +
                ", Num='" + Num + '\'' +
                ", Name='" + Name + '\'' +
                ", CnctValue=" + CnctValue +
                ", EffDate=" + EffDate +
                ", ExtendUncertainty=" + ExtendUncertainty +
                ", Des='" + Des + '\'' +
                '}';
    }
}
