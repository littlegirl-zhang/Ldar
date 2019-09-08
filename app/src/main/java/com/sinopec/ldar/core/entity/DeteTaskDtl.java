package com.sinopec.ldar.core.entity;

public class DeteTaskDtl {
    private double CompanyId;
    private double DeptId;
    private double SealPointId;
    private String LDARAreaName;
    private double ComponentId;
    private String ComLableCode;
    private String SealPointExtendNum;
    private String PIDCode;
    private String ComPlace;
    private String PathCode;
    private double SealPointTypeId;
    private String SealPointTypeName;
    private String SealPointDes;
    private String Floor;
    private String EquipPipeLineNum;
    private double DetePlanId;
    private String DetePlanName;
    private double DeteTaskId;
    private String DeteTaskName;
    private double RepairDataId;

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

    public String getLDARAreaName() {
        return LDARAreaName;
    }

    public void setLDARAreaName(String LDARAreaName) {
        this.LDARAreaName = LDARAreaName;
    }

    public double getComponentId() {
        return ComponentId;
    }

    public void setComponentId(double componentId) {
        ComponentId = componentId;
    }

    public String getComLableCode() {
        return ComLableCode;
    }

    public void setComLableCode(String comLableCode) {
        ComLableCode = comLableCode;
    }

    public String getSealPointExtendNum() {
        return SealPointExtendNum;
    }

    public void setSealPointExtendNum(String sealPointExtendNum) {
        SealPointExtendNum = sealPointExtendNum;
    }

    public String getPIDCode() {
        return PIDCode;
    }

    public void setPIDCode(String PIDCode) {
        this.PIDCode = PIDCode;
    }

    public String getComPlace() {
        return ComPlace;
    }

    public void setComPlace(String comPlace) {
        ComPlace = comPlace;
    }

    public String getPathCode() {
        return PathCode;
    }

    public void setPathCode(String pathCode) {
        PathCode = pathCode;
    }

    public double getSealPointTypeId() {
        return SealPointTypeId;
    }

    public void setSealPointTypeId(double sealPointTypeId) {
        SealPointTypeId = sealPointTypeId;
    }

    public String getSealPointTypeName() {
        return SealPointTypeName;
    }

    public void setSealPointTypeName(String sealPointTypeName) {
        SealPointTypeName = sealPointTypeName;
    }

    public String getSealPointDes() {
        return SealPointDes;
    }

    public void setSealPointDes(String sealPointDes) {
        SealPointDes = sealPointDes;
    }

    public String getFloor() {
        return Floor;
    }

    public void setFloor(String floor) {
        Floor = floor;
    }

    public String getEquipPipeLineNum() {
        return EquipPipeLineNum;
    }

    public void setEquipPipeLineNum(String equipPipeLineNum) {
        EquipPipeLineNum = equipPipeLineNum;
    }

    public double getDetePlanId() {
        return DetePlanId;
    }

    public void setDetePlanId(double detePlanId) {
        DetePlanId = detePlanId;
    }

    public String getDetePlanName() {
        return DetePlanName;
    }

    public void setDetePlanName(String detePlanName) {
        DetePlanName = detePlanName;
    }

    public double getDeteTaskId() {
        return DeteTaskId;
    }

    public void setDeteTaskId(double deteTaskId) {
        DeteTaskId = deteTaskId;
    }

    public String getDeteTaskName() {
        return DeteTaskName;
    }

    public void setDeteTaskName(String deteTaskName) {
        DeteTaskName = deteTaskName;
    }

    public double getRepairDataId() {
        return RepairDataId;
    }

    public void setRepairDataId(double repairDataId) {
        RepairDataId = repairDataId;
    }

    @Override
    public String toString() {
        return "DeteTaskDtl{" +
                "CompanyId=" + CompanyId +
                ", DeptId=" + DeptId +
                ", SealPointId=" + SealPointId +
                ", LDARAreaName='" + LDARAreaName + '\'' +
                ", ComponentId=" + ComponentId +
                ", ComLableCode='" + ComLableCode + '\'' +
                ", SealPointExtendNum='" + SealPointExtendNum + '\'' +
                ", PIDCode='" + PIDCode + '\'' +
                ", ComPlace='" + ComPlace + '\'' +
                ", PathCode='" + PathCode + '\'' +
                ", SealPointTypeId=" + SealPointTypeId +
                ", SealPointTypeName='" + SealPointTypeName + '\'' +
                ", SealPointDes='" + SealPointDes + '\'' +
                ", Floor='" + Floor + '\'' +
                ", EquipPipeLineNum='" + EquipPipeLineNum + '\'' +
                ", DetePlanId=" + DetePlanId +
                ", DetePlanName='" + DetePlanName + '\'' +
                ", DeteTaskId=" + DeteTaskId +
                ", DeteTaskName='" + DeteTaskName + '\'' +
                ", RepairDataId=" + RepairDataId +
                '}';
    }
}
