package com.ivy.admin.utils.ppsg;

import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.entity.ppsg.GeneralThree;
import com.ivy.admin.entity.ppsg.GeneralWarpath;
import com.ivy.admin.enums.ppsg.GeneralEnum;

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
    public static List<GeneralThree> calculateThree(General general, Integer force, Integer intellect, Integer troops, Integer forcex, Integer intellectx, Integer troopsx) {
        List<GeneralThree> threeList = new ArrayList<>();

        GeneralEnum.ThreeCirclesType type_1 = GeneralEnum.ThreeCirclesType.type_1;
        GeneralEnum.ThreeCirclesType type_2 = GeneralEnum.ThreeCirclesType.type_2;
        GeneralEnum.ThreeCirclesType type_3 = GeneralEnum.ThreeCirclesType.type_3;
        GeneralEnum.ThreeCirclesType type_4 = GeneralEnum.ThreeCirclesType.type_4;
        GeneralEnum.ThreeCirclesType type_5 = GeneralEnum.ThreeCirclesType.type_5;
        GeneralEnum.ThreeCirclesType type_6 = GeneralEnum.ThreeCirclesType.type_6;
        GeneralEnum.ThreeCirclesType type_7 = GeneralEnum.ThreeCirclesType.type_7;
        GeneralEnum.ThreeCirclesType type_8 = GeneralEnum.ThreeCirclesType.type_8;
        GeneralEnum.ThreeCirclesType type_9 = GeneralEnum.ThreeCirclesType.type_9;
        GeneralEnum.ThreeCirclesType type_10 = GeneralEnum.ThreeCirclesType.type_10;
        GeneralEnum.ThreeCirclesType type_11 = GeneralEnum.ThreeCirclesType.type_11;
        GeneralEnum.ThreeCirclesType type_12 = GeneralEnum.ThreeCirclesType.type_12;
        GeneralEnum.ThreeCirclesType type_13 = GeneralEnum.ThreeCirclesType.type_13;
        GeneralEnum.ThreeCirclesType type_14 = GeneralEnum.ThreeCirclesType.type_14;
        GeneralEnum.ThreeCirclesType type_15 = GeneralEnum.ThreeCirclesType.type_15;

        threeList.add(new GeneralThree(general.getId(),type_1.value(),type_1.label(),force,intellect,troops));//基础三维
        threeList.add(new GeneralThree(general.getId(),type_2.value(),type_2.label(),forcex,intellectx,troopsx));//异化基础三维
        threeList.add(new GeneralThree(general.getId(),type_3.value(),type_3.label()));//满级基础三维
        threeList.add(new GeneralThree(general.getId(),type_4.value(),type_4.label()));//异化满级基础三维
        threeList.add(new GeneralThree(general.getId(),type_5.value(),type_5.label()));//科技三维
        threeList.add(new GeneralThree(general.getId(),type_6.value(),type_6.label()));//四圣石三维
        threeList.add(new GeneralThree(general.getId(),type_7.value(),type_7.label()));//战器三维
        threeList.add(new GeneralThree(general.getId(),type_8.value(),type_8.label()));//特殊战器三维
        threeList.add(new GeneralThree(general.getId(),type_9.value(),type_9.label()));//兵书三维
        threeList.add(new GeneralThree(general.getId(),type_10.value(),type_10.label()));//将魂三维
        threeList.add(new GeneralThree(general.getId(),type_11.value(),type_11.label()));//战阵三维
        threeList.add(new GeneralThree(general.getId(),type_12.value(),type_12.label()));//命格三维
        threeList.add(new GeneralThree(general.getId(),type_13.value(),type_13.label()));//幻化三维
        threeList.add(new GeneralThree(general.getId(),type_14.value(),type_14.label()));//阵法三维
        threeList.add(new GeneralThree(general.getId(),type_15.value(),type_15.label()));//战意三维
        general.setThreeList(threeList);
        return threeList;
    }
}
