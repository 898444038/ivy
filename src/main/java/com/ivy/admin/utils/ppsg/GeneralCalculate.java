package com.ivy.admin.utils.ppsg;

import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.entity.ppsg.GeneralAnalog;
import com.ivy.admin.entity.ppsg.GeneralThree;
import com.ivy.admin.entity.ppsg.GeneralWeapon;
import com.ivy.admin.enums.ppsg.GeneralEnum;
import com.ivy.system.enums.IDictItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GeneralCalculate {

    public static GeneralThree getBaseThree(General general){
        List<GeneralThree> threeList = general.getThreeList();
        GeneralEnum.ThreeCirclesType type = null;
        if (GeneralEnum.CardType.yi_hua.value().equals(general.getCardCode())) {
            type = GeneralEnum.ThreeCirclesType.type_2;
        }else{
            type = GeneralEnum.ThreeCirclesType.type_1;
        }
        for (GeneralThree three : threeList){
            if(three.getCode().equals(type.value())){
                return three;
            }
        }
        return null;
    }

    public static GeneralThree getBaseMaxThree(General general){
        List<GeneralThree> threeList = general.getThreeList();
        GeneralEnum.ThreeCirclesType type = null;
        if (GeneralEnum.CardType.yi_hua.value().equals(general.getCardCode())) {
            type = GeneralEnum.ThreeCirclesType.type_4;
        }else{
            type = GeneralEnum.ThreeCirclesType.type_3;
        }
        for (GeneralThree three : threeList){
            if(three.getCode().equals(type.value())){
                return three;
            }
        }
        return null;
    }

    public static GeneralThree getThree(General general,GeneralEnum.ThreeCirclesType type){
        List<GeneralThree> threeList = general.getThreeList();
        for (GeneralThree three : threeList){
            if(three.getCode().equals(type.value())){
                return three;
            }
        }
        return null;
    }

    /**
     * 计算等级三维
     * @param general
     * @param analog
     * @return
     */
    public static GeneralThree calculateLevel(General general, GeneralAnalog analog) {
        GeneralEnum.GeneralsType generalsType = IDictItem.getByValue(GeneralEnum.GeneralsType.class, general.getTypeCode());
        Map<String,Object> params = generalsType.params();
        int growForce = MapUtils.get(MapKeys.growForce,params);
        int growIntellect = MapUtils.get(MapKeys.growIntellect,params);
        int growTroops = MapUtils.get(MapKeys.growTroops,params);

        GeneralThree baseThree = getBaseThree(general);
        int baseForce = baseThree.getForce();
        int baseIntellect = baseThree.getIntellect();
        int baseTroops = baseThree.getTroops();

        int level = analog.getCurrLevel() > GeneralAnalog.maxLevel ? GeneralAnalog.maxLevel : analog.getCurrLevel() - GeneralAnalog.minLevel;
        int force = baseForce + growForce * level;
        int intellect = baseIntellect + growIntellect * level;
        int troops = baseTroops + growTroops * level;
        int combat = (force + intellect + troops) * 2;

        GeneralThree three = new GeneralThree();
        three.setGeneralId(general.getId());
        if (GeneralEnum.CardType.yi_hua.value().equals(general.getCardCode())) {
            three.setCode(GeneralEnum.ThreeCirclesType.type_4.value());
            three.setName(GeneralEnum.ThreeCirclesType.type_4.label());
        }else{
            three.setCode(GeneralEnum.ThreeCirclesType.type_3.value());
            three.setName(GeneralEnum.ThreeCirclesType.type_3.label());
        }
        three.setForce(force);
        three.setIntellect(intellect);
        three.setTroops(troops);
        three.setCombat(combat);
        return three;
    }

    /**
     * 科技
     * @param general
     * @param analog
     * @return
     */
    public static GeneralThree calculateScience(General general, GeneralAnalog analog) {
        GeneralEnum.Arms arms = IDictItem.getByValue(GeneralEnum.Arms.class, general.getArmsCode());
        Map<String,Object> params = arms.params();
        double forceRate = MapUtils.get(MapKeys.forceRate,params);
        double intellectRate = MapUtils.get(MapKeys.intellectRate,params);
        double troopsRate = MapUtils.get(MapKeys.troopsRate,params);

        GeneralThree maxThree = getBaseMaxThree(general);

        Double force = maxThree.getForce() * forceRate;
        Double intellect = maxThree.getIntellect() * intellectRate;
        Double troops = maxThree.getTroops() * troopsRate;
        Double combat = (force + intellect + troops ) * 2;

        GeneralEnum.ThreeCirclesType type = GeneralEnum.ThreeCirclesType.type_5;
        GeneralThree three = new GeneralThree(general.getId(),type.value(),type.label());
        three.setForce(force.intValue());
        three.setIntellect(intellect.intValue());
        three.setTroops(troops.intValue());
        three.setCombat(combat.intValue());
        three.setForce0(force);
        three.setIntellect0(intellect);
        three.setTroops0(troops);
        three.setCombat0(combat);
        return three;
    }

    /**
     * 四圣石
     * @param general
     * @param analog
     * @return
     */
    public static GeneralThree calculateHolyStone(General general, GeneralAnalog analog) {
        GeneralEnum.ThreeCirclesType type = GeneralEnum.ThreeCirclesType.type_6;
        GeneralThree three = new GeneralThree(general.getId(),type.value(),type.label());
        int force = 1077;
        int intellect = 1077;
        int troops = 2291;
        three.setForce(force);
        three.setIntellect(intellect);
        three.setTroops(troops);
        three.setCombat((force+intellect+troops)*2);
        return three;
    }

    /**
     * 战器三维
     * @param general
     * @param analog
     * @return
     */
    public static GeneralThree calculateWeapon(General general, GeneralAnalog analog) {
        List<GeneralWeapon> weaponList = general.getWeaponList();
        List<GeneralThree> threeList = new ArrayList<>();
        for (GeneralWeapon generalWeapon : weaponList){
            GeneralEnum.Weapon weapon = IDictItem.getByValue(GeneralEnum.Weapon.class, generalWeapon.getWeaponCode());
            Map<String,Object> params = weapon.params();
            //基础
            int baseForce = MapUtils.get(MapKeys.force,params);
            int baseIntellect = MapUtils.get(MapKeys.intellect,params);
            int baseTroops = MapUtils.get(MapKeys.troops,params);
            //强化
            int strengthenForce = MapUtils.get(MapKeys.strengthenForce,params);
            int strengthenIntellect = MapUtils.get(MapKeys.strengthenIntellect,params);
            int strengthenTroops = MapUtils.get(MapKeys.strengthenTroops,params);
            //淬炼
            double quenchingForceRate = MapUtils.get(MapKeys.quenchingForceRate,params);
            double quenchingIntellectRate = MapUtils.get(MapKeys.quenchingIntellectRate,params);
            double quenchingTroopsRate = MapUtils.get(MapKeys.quenchingTroopsRate,params);

            int force = baseForce + strengthenForce;
            int intellect = baseIntellect + strengthenIntellect;
            int troops = baseTroops + strengthenTroops;

//            if(troops >= force && troops >= intellect){//troops
//                Double d = troops * quenchingForceRate;
//                troops += d.intValue()*2;
//                quenchingName2 = quenchingName1 = "战器的兵力值提升"+(int)(warDevice.getQuenchingTroopsRate()*100)+"%";
//            }else if(force >= intellect && force >= troops){//force
//                Double d= force * warDevice.getQuenchingForceRate();
//                deviceQuenching.setForce(d.intValue()*2);
//                force += d.intValue()*2;
//                quenchingName2 = quenchingName1 = "战器的武力值提升"+(int)(warDevice.getQuenchingForceRate()*100)+"%";
//            }else{//intellect
//                Double d= intellect * warDevice.getQuenchingIntellectRate();
//                deviceQuenching.setIntellect(d.intValue()*2);
//                quenchingName2 = quenchingName1 = "战器的智力值提升"+(int)(warDevice.getQuenchingIntellectRate()*100)+"%";
//                intellect += d.intValue()*2;
//            }
//            //专属
//            force += warDevice.getExclusiveForce();
//            intellect += warDevice.getExclusiveIntellect();
//            troops += warDevice.getExclusiveTroops();

//            deviceExclusive = new ThreeDimensional(warDevice.getExclusiveForce(),warDevice.getExclusiveIntellect(),warDevice.getExclusiveTroops());

            GeneralEnum.ThreeCirclesType type = GeneralEnum.ThreeCirclesType.type_7;
            GeneralThree three = new GeneralThree(general.getId(),type.value(),type.label());
//            int force = 1077;
//            int intellect = 1077;
//            int troops = 2291;
            three.setForce(force);
            three.setIntellect(intellect);
            three.setTroops(troops);
            three.setCombat((force+intellect+troops)*2);

            threeList.add(three);
        }

        return threeList.get(0);
    }

    /**
     * 异化战器三维
     * @param general
     * @param analog
     * @return
     */
    public static GeneralThree calculateWeapon2(General general, GeneralAnalog analog) {
        GeneralEnum.ThreeCirclesType type = GeneralEnum.ThreeCirclesType.type_8;
        GeneralThree three = new GeneralThree(general.getId(),type.value(),type.label());
        int force = 1077;
        int intellect = 1077;
        int troops = 2291;
        three.setForce(force);
        three.setIntellect(intellect);
        three.setTroops(troops);
        three.setCombat((force+intellect+troops)*2);
        return three;
    }
}
