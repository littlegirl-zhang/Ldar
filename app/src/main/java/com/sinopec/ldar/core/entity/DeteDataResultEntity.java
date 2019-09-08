package com.sinopec.ldar.core.entity;

public class DeteDataResultEntity  {
    private double CompanyId;
    private double DeptId;
    private double SealPointId;
    private double DeteTaskId;
    private double DetePlanId;
    private double LDARDeteInstrmtID;
    private String DeteTime;
    private double DeteValue;
    private double EBValue;
    private String LeakPlace;

    public double getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(double companyId) {
        CompanyId = companyId;
    }

    public double getDeptId() {
        return DeptId;
    }

    public void setDeptId(double deptId) {
        DeptId = deptId;
    }

    public double getSealPointId() {
        return SealPointId;
    }

    public void setSealPointId(double sealPointId) {
        SealPointId = sealPointId;
    }

    public double getDeteTaskId() {
        return DeteTaskId;
    }

    public void setDeteTaskId(double deteTaskId) {
        DeteTaskId = deteTaskId;
    }

    public double getDetePlanId() {
        return DetePlanId;
    }

    public void setDetePlanId(double detePlanId) {
        DetePlanId = detePlanId;
    }

    public double getLDARDeteInstrmtID() {
        return LDARDeteInstrmtID;
    }

    public void setLDARDeteInstrmtID(double LDARDeteInstrmtID) {
        this.LDARDeteInstrmtID = LDARDeteInstrmtID;
    }

    public String getDeteTime() {
        return DeteTime;
    }

    public void setDeteTime(String deteTime) {
        DeteTime = deteTime;
    }

    public double getDeteValue() {
        return DeteValue;
    }

    public void setDeteValue(double deteValue) {
        DeteValue = deteValue;
    }

    public double getEBValue() {
        return EBValue;
    }

    public void setEBValue(double EBValue) {
        this.EBValue = EBValue;
    }

    public String getLeakPlace() {
        return LeakPlace;
    }

    public void setLeakPlace(String leakPlace) {
        LeakPlace = leakPlace;
    }
}
