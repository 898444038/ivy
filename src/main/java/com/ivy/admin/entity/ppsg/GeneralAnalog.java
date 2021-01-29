package com.ivy.admin.entity.ppsg;

import com.ivy.admin.enums.ppsg.GeneralEnum;

public class GeneralAnalog {

    private String ids;//指定上阵武将
    private int type;//0:全部武将 2:部分包含 1:全包含
    private Integer size;//返回条数10-100
    public static final int minLevel = 1;
    public static final int maxLevel = 120;
    private int currLevel;
    private boolean isSpecial;//是否特殊战器
    private GeneralEnum.Embattle embattle = GeneralEnum.Embattle.long_fei;

    public GeneralAnalog() {
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
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
