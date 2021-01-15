package com.ivy.admin.utils.ppsg;

import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.entity.ppsg.GeneralAnalog;
import com.ivy.admin.entity.ppsg.GeneralThree;
import com.ivy.admin.enums.ppsg.GeneralEnum;

import java.util.ArrayList;
import java.util.List;

public class GeneralUtils {

    public static void createGeneral(General general) {

    }

    /**
     * 计算三维
     * @param general
     * @return
     */
    public static List<GeneralThree> calculateThree(General general, GeneralAnalog analog, Integer force, Integer intellect, Integer troops, Integer forcex, Integer intellectx, Integer troopsx) {
        List<GeneralThree> threeList = new ArrayList<>();
        general.setThreeList(threeList);

        //基础三维
        GeneralEnum.ThreeCirclesType type_1 = GeneralEnum.ThreeCirclesType.type_1;
        GeneralThree three1 = new GeneralThree(general.getId(),type_1.value(),type_1.label(),force,intellect,troops);
        general.getThreeList().add(three1);

        //异化基础三维
        if (GeneralEnum.CardType.yi_hua.value().equals(general.getCardCode())){
            GeneralEnum.ThreeCirclesType type_2 = GeneralEnum.ThreeCirclesType.type_2;
            GeneralThree three2 = new GeneralThree(general.getId(),type_2.value(),type_2.label(),forcex,intellectx,troopsx);
            general.getThreeList().add(three2);
            //异化满级基础三维
            threeList.add(GeneralCalculate.calculateLevel(general,analog));
        }else{
            //满级基础三维
            threeList.add(GeneralCalculate.calculateLevel(general,analog));
        }

        //科技三维
        threeList.add(GeneralCalculate.calculateScience(general,analog));
        //四圣石三维
        threeList.add(GeneralCalculate.calculateHolyStone(general,analog));

        //战器三维
        threeList.addAll(GeneralCalculate.calculateWeapon(general,analog,GeneralEnum.ThreeCirclesType.type_7));
        //特殊战器三维
        threeList.addAll(GeneralCalculate.calculateWeapon(general,analog,GeneralEnum.ThreeCirclesType.type_8));

        //兵种1三维
        threeList.add(GeneralCalculate.calculateArms(general,analog,GeneralEnum.ThreeCirclesType.type_9));
        //兵种2三维
        threeList.add(GeneralCalculate.calculateArms(general,analog,GeneralEnum.ThreeCirclesType.type_10));

        //上阵兵书三维
        threeList.add(GeneralCalculate.calculateArmsBook(general,analog,GeneralEnum.ThreeCirclesType.type_11));
        //武随兵书三维
        threeList.add(GeneralCalculate.calculateArmsBook(general,analog,GeneralEnum.ThreeCirclesType.type_12));
        //智随兵书三维
        threeList.add(GeneralCalculate.calculateArmsBook(general,analog,GeneralEnum.ThreeCirclesType.type_13));
        //兵随兵书三维
        threeList.add(GeneralCalculate.calculateArmsBook(general,analog,GeneralEnum.ThreeCirclesType.type_14));

        //上阵将魂三维
        threeList.add(GeneralCalculate.calculateWillSoul(general,analog,GeneralEnum.ThreeCirclesType.type_15));
        //随从将魂三维
        //threeList.add(GeneralCalculate.calculateWillSoul(general,analog,GeneralEnum.ThreeCirclesType.type_16));

        //战阵三维
        threeList.add(GeneralCalculate.calculateBattleArray(general,analog));
        //幻化三维
        threeList.add(GeneralCalculate.calculateSkin(general,analog));
        //阵法三维
        threeList.add(GeneralCalculate.calculateEmbattle(general,analog));

        //命格三维
        threeList.add(GeneralCalculate.calculateDestiny(general,analog));
        //随从三维
        threeList.addAll(GeneralCalculate.calculateEntourage(general,analog,GeneralEnum.ThreeCirclesType.type_22));
        threeList.addAll(GeneralCalculate.calculateEntourage(general,analog,GeneralEnum.ThreeCirclesType.type_24));
        threeList.addAll(GeneralCalculate.calculateEntourage(general,analog,GeneralEnum.ThreeCirclesType.type_26));

        //战意三维
        //threeList.add(GeneralCalculate.calculateWarpath(general,analog));
        //兵符三维

        general.setThreeList(threeList);
        return threeList;
    }

}
