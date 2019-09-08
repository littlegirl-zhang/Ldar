package com.sinopec.ldar.core.entity;

public class InstrumentChildValue extends InstrumentCheckItem{

    private String name;
    private int zeroValue;
    private int standardValue;
    private int driftValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZeroValue() {
        return zeroValue;
    }

    public void setZeroValue(int zeroValue) {
        this.zeroValue = zeroValue;
    }

    public int getStandardValue() {
        return standardValue;
    }

    public void setStandardValue(int standardValue) {
        this.standardValue = standardValue;
    }

    public int getDriftValue() {
        return driftValue;
    }

    public void setDriftValue(int driftValue) {
        this.driftValue = driftValue;
    }

    @Override
    public String toString() {
        return "InstrumentChildValue{" +
                "name='" + name + '\'' +
                ", zeroValue=" + zeroValue +
                ", standardValue=" + standardValue +
                ", driftValue=" + driftValue +
                '}';
    }

    @Override
    public int getType() {
        return TYPE_CHILD;
    }
}
