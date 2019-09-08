package com.sinopec.ldar.core.entity;

public abstract class InstrumentCheckItem {
    public static final int TYPE_GROUP = 0xa01;
    public static final int TYPE_CHILD = 0xa02;
    public abstract int getType();
}
