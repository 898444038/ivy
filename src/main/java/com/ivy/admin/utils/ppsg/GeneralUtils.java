package com.ivy.admin.utils.ppsg;

import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.entity.ppsg.GeneralThree;

import java.util.ArrayList;
import java.util.List;

public class GeneralUtils {

    public static void createGeneral(General general) {

    }

    /**
     * 计算基础三维
     * @param general
     * @return
     */
    public static List<GeneralThree> calculateThree(General general) {
        List<GeneralThree> threeList = new ArrayList<>();
        threeList.add(new GeneralThree());//基础三维
        threeList.add(new GeneralThree());//异化基础三维
        threeList.add(new GeneralThree());//满级基础三维
        threeList.add(new GeneralThree());//异化满级基础三维
        threeList.add(new GeneralThree());//科技三维
        threeList.add(new GeneralThree());//四圣石三维
        threeList.add(new GeneralThree());//战器三维
        threeList.add(new GeneralThree());//特殊战器三维
        threeList.add(new GeneralThree());//兵书三维
        threeList.add(new GeneralThree());//将魂三维
        threeList.add(new GeneralThree());//战阵三维
        threeList.add(new GeneralThree());//命格三维
        threeList.add(new GeneralThree());//幻化三维
        threeList.add(new GeneralThree());//阵法三维
        return threeList;
    }
}
