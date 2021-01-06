package com.ivy.admin.entity.ppsg;

import com.ivy.admin.enums.ppsg.GeneralEnum;

public class GeneralAnalog {

    public static final int minLevel = 1;
    public static final int maxLevel = 120;
    private int currLevel;
    private boolean isSpecial;//是否特殊战器
    private GeneralEnum.Embattle embattle = GeneralEnum.Embattle.long_fei;

    public GeneralAnalog() {
    }

    public static int getMinLevel() {
        return minLevel;
    }

    public static int getMaxLevel() {
        return maxLevel;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public GeneralEnum.Embattle getEmbattle() {
        return embattle;
    }

    public void setEmbattle(GeneralEnum.Embattle embattle) {
        this.embattle = embattle;
    }

    public int getCurrLevel() {
        return currLevel;
    }

    public void setCurrLevel(int currLevel) {
        this.currLevel = currLevel;
    }
}
