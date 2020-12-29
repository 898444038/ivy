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
    public static List<GeneralThree> calculateThree(General general,List<GeneralThree> threeList) {
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
        //threeList.add(new GeneralThree());//基础三维
        //threeList.add(new GeneralThree());//异化基础三维
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
        return threeList;
    }

    public static void calculateWarpathThree(General general, List<GeneralWarpath> warpathList) {
        GeneralEnum.Warpath country_force = GeneralEnum.Warpath.country_force;
        GeneralEnum.Warpath country_intellect = GeneralEnum.Warpath.country_intellect;
        GeneralEnum.Warpath country_troops = GeneralEnum.Warpath.country_troops;
        GeneralEnum.Warpath arms_force = GeneralEnum.Warpath.arms_force;
        GeneralEnum.Warpath arms_intellect = GeneralEnum.Warpath.arms_intellect;
        GeneralEnum.Warpath arms_troops = GeneralEnum.Warpath.arms_troops;
        warpathList.add(new GeneralWarpath(general.getId(),general.getName(),country_force.value(),country_force.label()));
        warpathList.add(new GeneralWarpath(general.getId(),general.getName(),country_intellect.value(),country_intellect.label()));
        warpathList.add(new GeneralWarpath(general.getId(),general.getName(),country_troops.value(),country_troops.label()));
        warpathList.add(new GeneralWarpath(general.getId(),general.getName(),arms_force.value(),arms_force.label()));
        warpathList.add(new GeneralWarpath(general.getId(),general.getName(),arms_intellect.value(),arms_intellect.label()));
        warpathList.add(new GeneralWarpath(general.getId(),general.getName(),arms_troops.value(),arms_troops.label()));

    }
}
