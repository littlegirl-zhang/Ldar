package com.sinopec.ldar.mvp.model.entity;

public class InstrumentGroupDate extends InstrumentCheckItem{

    private long date;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "InstrumentGroupDate{" +
                "date=" + date +
                '}';
    }

    @Override
    public int getType() {
        return TYPE_GROUP;
    }
}
