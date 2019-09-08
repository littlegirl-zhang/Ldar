package com.sinopec.ldar.core.entity;

import java.util.Date;

public class DeteTask {
    private double DeteTaskId;
    private int Status;
    private String StatusName;
    private double CompanyId;
    private double DeptId;
    private String DeptSname;
    private String TaskName;
    private int TaskType;
    private String TaskTypeName;
    private Date DeteBeginDate;
    private Date DeteEndDate;
    private Date DistTime;
    private String DistUserId;
    private String DistUserName;
    private String Remark;

    public double getDeteTaskId() {
        return DeteTaskId;
    }

    public void setDeteTaskId(double deteTaskId) {
        DeteTaskId = deteTaskId;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getStatusName() {
        return StatusName;
    }

    public void setStatusName(String statusName) {
        StatusName = statusName;
    }

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

    public String getDeptSname() {
        return DeptSname;
    }

    public void setDeptSname(String deptSname) {
        DeptSname = deptSname;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public int getTaskType() {
        return TaskType;
    }

    public void setTaskType(int taskType) {
        TaskType = taskType;
    }

    public String getTaskTypeName() {
        return TaskTypeName;
    }

    public void setTaskTypeName(String taskTypeName) {
        TaskTypeName = taskTypeName;
    }

    public Date getDeteBeginDate() {
        return DeteBeginDate;
    }

    public void setDeteBeginDate(Date deteBeginDate) {
        DeteBeginDate = deteBeginDate;
    }

    public Date getDeteEndDate() {
        return DeteEndDate;
    }

    public void setDeteEndDate(Date deteEndDate) {
        DeteEndDate = deteEndDate;
    }

    public Date getDistTime() {
        return DistTime;
    }

    public void setDistTime(Date distTime) {
        DistTime = distTime;
    }

    public String getDistUserId() {
        return DistUserId;
    }

    public void setDistUserId(String distUserId) {
        DistUserId = distUserId;
    }

    public String getDistUserName() {
        return DistUserName;
    }

    public void setDistUserName(String distUserName) {
        DistUserName = distUserName;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    @Override
    public String toString() {
        return "DeteTask{" +
                "DeteTaskId=" + DeteTaskId +
                ", Status=" + Status +
                ", StatusName='" + StatusName + '\'' +
                ", CompanyId=" + CompanyId +
                ", DeptId=" + DeptId +
                ", DeptSname='" + DeptSname + '\'' +
                ", TaskName='" + TaskName + '\'' +
                ", TaskType=" + TaskType +
                ", TaskTypeName='" + TaskTypeName + '\'' +
                ", DeteBeginDate=" + DeteBeginDate +
                ", DeteEndDate=" + DeteEndDate +
                ", DistTime=" + DistTime +
                ", DistUserId='" + DistUserId + '\'' +
                ", DistUserName='" + DistUserName + '\'' +
                ", Remark='" + Remark + '\'' +
                '}';
    }
}
