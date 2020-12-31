package com.ivy.admin.utils.ppsg;

import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.entity.ppsg.GeneralAnalog;
import com.ivy.admin.entity.ppsg.GeneralThree;
import com.ivy.admin.enums.ppsg.GeneralEnum;
import com.ivy.system.enums.IDictItem;
import com.sun.javafx.collections.MappingChange;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GeneralUtils {

    public static void createGeneral(General general) {

    }

    /**
     * 计算基础三维
     * @param general
     * @return
     */
    public static List<GeneralThree> calculateThree(General general, GeneralAnalog analog, Integer force, Integer intellect, Integer troops, Integer forcex, Integer intellectx, Integer troopsx) {
        List<GeneralThree> threeList = new ArrayList<>();
        general.setThreeList(threeList);

        GeneralEnum.ThreeCirclesType type_1 = GeneralEnum.ThreeCirclesType.type_1;
        GeneralEnum.ThreeCirclesType type_2 = GeneralEnum.ThreeCirclesType.type_2;
        //GeneralEnum.ThreeCirclesType type_3 = GeneralEnum.ThreeCirclesType.type_3;
//        GeneralEnum.ThreeCirclesType type_4 = GeneralEnum.ThreeCirclesType.type_4;
//        GeneralEnum.ThreeCirclesType type_5 = GeneralEnum.ThreeCirclesType.type_5;
//        GeneralEnum.ThreeCirclesType type_6 = GeneralEnum.ThreeCirclesType.type_6;
//        GeneralEnum.ThreeCirclesType type_7 = GeneralEnum.ThreeCirclesType.type_7;
//        GeneralEnum.ThreeCirclesType type_8 = GeneralEnum.ThreeCirclesType.type_8;
        GeneralEnum.ThreeCirclesType type_9 = GeneralEnum.ThreeCirclesType.type_9;
        GeneralEnum.ThreeCirclesType type_10 = GeneralEnum.ThreeCirclesType.type_10;
        GeneralEnum.ThreeCirclesType type_11 = GeneralEnum.ThreeCirclesType.type_11;
        GeneralEnum.ThreeCirclesType type_12 = GeneralEnum.ThreeCirclesType.type_12;
        GeneralEnum.ThreeCirclesType type_13 = GeneralEnum.ThreeCirclesType.type_13;
        GeneralEnum.ThreeCirclesType type_14 = GeneralEnum.ThreeCirclesType.type_14;
        GeneralEnum.ThreeCirclesType type_15 = GeneralEnum.ThreeCirclesType.type_15;

        //基础三维
        GeneralThree three1 = new GeneralThree(general.getId(),type_1.value(),type_1.label(),force,intellect,troops);
        general.getThreeList().add(three1);
        //异化基础三维
        GeneralThree three2 = new GeneralThree(general.getId(),type_2.value(),type_2.label(),forcex,intellectx,troopsx);
        general.getThreeList().add(three2);
        if (GeneralEnum.CardType.yi_hua.value().equals(general.getCardCode())){
            threeList.add(GeneralCalculate.calculateLevel(general,analog));//异化满级基础三维
        }else{
            threeList.add(GeneralCalculate.calculateLevel(general,analog));//满级基础三维
        }

        threeList.add(GeneralCalculate.calculateScience(general,analog));//科技三维
        threeList.add(GeneralCalculate.calculateHolyStone(general,analog));//四圣石三维
        threeList.add(GeneralCalculate.calculateWeapon(general,analog));//战器三维
        threeList.add(GeneralCalculate.calculateWeapon2(general,analog));//特殊战器三维

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
