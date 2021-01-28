package com.ivy.admin.entity.ppsg;


import java.util.List;

public class GeneralResult {

    private Integer rank;//总排名
    private Integer totalCombat;//总战力
    private String title;//总战力
    private List<GeneralResultItem> itemList;//上阵武将

    public GeneralResult() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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
