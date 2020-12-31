package com.ivy.admin.entity.ppsg;

public class GeneralAnalog {

    public static final int minLevel = 1;
    public static final int maxLevel = 120;
    private int currLevel;


    public GeneralAnalog() {
    }

    public int getCurrLevel() {
        return currLevel;
    }

    public void setCurrLevel(int currLevel) {
        this.currLevel = currLevel;
    }
}
