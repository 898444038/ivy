package com.ivy.admin.vo.ppsg;

import com.ivy.admin.entity.ppsg.General;

/**
 * 武将
 * @author: Administrator
 * @date: 2020-12-30
 */
public class GeneralVo extends General {

    private Integer pageNo;

    private Integer pageSize;

    private Integer pageStart;

    private String pageSort;

    private String dicName;

    private Integer force;

    private Integer intellect;

    private Integer troops;

    private Integer forcex;

    private Integer intellectx;

    private Integer troopsx;

    public GeneralVo() {
        if (pageSize == null) {
            this.pageSize = 20;
        }
        if (pageNo == null) {
            this.pageNo = 1;
            this.pageStart = 0;
        }
    }

    public Integer getForce() {
        return force;
    }

    public void setForce(Integer force) {
        this.force = force;
    }

    public Integer getIntellect() {
        return intellect;
    }

    public void setIntellect(Integer intellect) {
        this.intellect = intellect;
    }

    public Integer getTroops() {
        return troops;
    }

    public void setTroops(Integer troops) {
        this.troops = troops;
    }

    public Integer getForcex() {
        return forcex;
    }

    public void setForcex(Integer forcex) {
        this.forcex = forcex;
    }

    public Integer getIntellectx() {
        return intellectx;
    }

    public void setIntellectx(Integer intellectx) {
        this.intellectx = intellectx;
    }

    public Integer getTroopsx() {
        return troopsx;
    }

    public void setTroopsx(Integer troopsx) {
        this.troopsx = troopsx;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageSize == null) {
            this.pageSize = 20;
        }
        if (pageNo != null && pageNo > 0) {
            this.pageNo = pageNo;
            this.pageStart = (pageNo - 1) * this.pageSize;
        } else {
            this.pageNo = 1;
            this.pageStart = 0;
        }
    }

    public String getPageSort() {
        return pageSort;
    }

    public void setPageSort(String pageSort) {
        this.pageSort = pageSort;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }
}

