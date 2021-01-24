package com.ivy.admin.entity.ppsg;


import java.util.List;

public class GeneralResult {

    private Integer totalCombat;//总战力
    private List<GeneralResultItem> itemList;//上阵武将

    public GeneralResult() {
    }

    public Integer getTotalCombat() {
        return totalCombat;
    }

    public void setTotalCombat(Integer totalCombat) {
        this.totalCombat = totalCombat;
    }

    public List<GeneralResultItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<GeneralResultItem> itemList) {
        this.itemList = itemList;
    }
}
