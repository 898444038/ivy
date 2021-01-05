package com.ivy.admin.entity.ppsg;

public class GeneralAnalog {

    public static final int minLevel = 1;
    public static final int maxLevel = 120;
    private int currLevel;
    private boolean isSpecial;//是否特殊战器

    public GeneralAnalog() {
    }

    public int getCurrLevel() {
        return currLevel;
    }

    public void setCurrLevel(int currLevel) {
        this.currLevel = currLevel;
    }
}
