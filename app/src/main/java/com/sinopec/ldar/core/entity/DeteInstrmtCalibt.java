package com.sinopec.ldar.core.entity;

public class DeteInstrmtCalibt {
    private String CompanyCode;
    private String CalibtUserId;
    private String CalibtUserName;
    private double LDARDeteInstrmtId;
    private double LDARStdGasId;
    private String InstrmtCalibtDate;
    private double ZeroGasCnctValue;
    private double ZeroGasCalibtValue;
    private double StdGasCalibtValue;
    private double StdGasCalibtCnctValue;
    private double DriftCalibtValue;

//    private double EpT;
//    private double WindSpeed;
//    private double Humidity;
//    private double Atmosphere;
//    private String WindDirection;

    public String getCompanyCode() {
        return CompanyCode;
    }

    public void setCompanyCode(String companyCode) {
        CompanyCode = companyCode;
    }

    public String getCalibtUserId() {
        return CalibtUserId;
    }

    public void setCalibtUserId(String calibtUserId) {
        CalibtUserId = calibtUserId;
    }

    public String getCalibtUserName() {
        return CalibtUserName;
    }

    public void setCalibtUserName(String calibtUserName) {
        CalibtUserName = calibtUserName;
    }

    public double getLDARDeteInstrmtId() {
        return LDARDeteInstrmtId;
    }

    public void setLDARDeteInstrmtId(double LDARDeteInstrmtId) {
        this.LDARDeteInstrmtId = LDARDeteInstrmtId;
    }

    public double getLDARStdGasId() {
        return LDARStdGasId;
    }

    public void setLDARStdGasId(double LDARStdGasId) {
        this.LDARStdGasId = LDARStdGasId;
    }

    public String getInstrmtCalibtDate() {
        return InstrmtCalibtDate;
    }

    public void setInstrmtCalibtDate(String instrmtCalibtDate) {
        InstrmtCalibtDate = instrmtCalibtDate;
    }

    public double getZeroGasCnctValue() {
        return ZeroGasCnctValue;
    }

    public void setZeroGasCnctValue(double zeroGasCnctValue) {
        ZeroGasCnctValue = zeroGasCnctValue;
    }

    public double getZeroGasCalibtValue() {
        return ZeroGasCalibtValue;
    }

    public void setZeroGasCalibtValue(double zeroGasCalibtValue) {
        ZeroGasCalibtValue = zeroGasCalibtValue;
    }

    public double getStdGasCalibtValue() {
        return StdGasCalibtValue;
    }

    public void setStdGasCalibtValue(double stdGasCalibtValue) {
        StdGasCalibtValue = stdGasCalibtValue;
    }

    public double getStdGasCalibtCnctValue() {
        return StdGasCalibtCnctValue;
    }

    public void setStdGasCalibtCnctValue(double stdGasCalibtCnctValue) {
        StdGasCalibtCnctValue = stdGasCalibtCnctValue;
    }

    public double getDriftCalibtValue() {
        return DriftCalibtValue;
    }

    public void setDriftCalibtValue(double driftCalibtValue) {
        DriftCalibtValue = driftCalibtValue;
    }

    @Override
    public String toString() {
        return "DeteInstrmtCalibt{" +
                "CompanyCode='" + CompanyCode + '\'' +
                ", CalibtUserId='" + CalibtUserId + '\'' +
                ", CalibtUserName='" + CalibtUserName + '\'' +
                ", LDARDeteInstrmtId=" + LDARDeteInstrmtId +
                ", LDARStdGasId=" + LDARStdGasId +
                ", InstrmtCalibtDate='" + InstrmtCalibtDate + '\'' +
                ", ZeroGasCnctValue=" + ZeroGasCnctValue +
                ", ZeroGasCalibtValue=" + ZeroGasCalibtValue +
                ", StdGasCalibtValue=" + StdGasCalibtValue +
                ", StdGasCalibtCnctValue=" + StdGasCalibtCnctValue +
                ", DriftCalibtValue=" + DriftCalibtValue +
                '}';
    }
}
