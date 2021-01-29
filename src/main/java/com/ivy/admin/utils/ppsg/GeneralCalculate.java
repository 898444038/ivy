package com.ivy.admin.utils.ppsg;

import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.entity.ppsg.GeneralAnalog;
import com.ivy.admin.entity.ppsg.GeneralArmsBook;
import com.ivy.admin.entity.ppsg.GeneralSkin;
import com.ivy.admin.entity.ppsg.GeneralThree;
import com.ivy.admin.entity.ppsg.GeneralWeapon;
import com.ivy.admin.enums.ppsg.GeneralEnum;
import com.ivy.system.enums.IDictItem;
import org.apache.commons.lang.StringUtils;

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

    public static List<GeneralThree> getThreeList(General general,GeneralEnum.ThreeCirclesType type){
        List<GeneralThree> list = new ArrayList<>();
        List<GeneralThree> threeList = general.getThreeList();
        for (GeneralThree three : threeList){
            if(three.getCode().equals(type.value())){
                list.add(three);
            }
        }
        return list;
    }

    public static GeneralThree setCombat(GeneralThree three, int force, int intellect, int troops){
        int combat = (force + intellect + troops) * 2;
        three.setForce(force);
        three.setIntellect(intellect);
        three.setTroops(troops);
        three.setCombat(combat);
        return three;
    }

    public static GeneralThree setCombat(GeneralThree three, Double force, Double intellect, Double troops){
        three.setForce0(force);
        three.setIntellect0(intellect);
        three.setTroops0(troops);
        three.setCombat0((force + intellect + troops ) * 2);
        three.setForce(force.intValue());
        three.setIntellect(intellect.intValue());
        three.setTroops(troops.intValue());
        three.setCombat((three.getForce()+three.getIntellect()+three.getTroops()) * 2);
        return three;
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

        //int level = analog.getCurrLevel() > GeneralAnalog.maxLevel ? GeneralAnalog.maxLevel : analog.getCurrLevel() - GeneralAnalog.minLevel;
        int level = GeneralAnalog.maxLevel - GeneralAnalog.minLevel;
        int force = baseForce + growForce * level;
        int intellect = baseIntellect + growIntellect * level;
        int troops = baseTroops + growTroops * level;

        GeneralThree three = new GeneralThree();
        three.setGeneralId(general.getId());
        if (GeneralEnum.CardType.yi_hua.value().equals(general.getCardCode())) {
            three.setCode(GeneralEnum.ThreeCirclesType.type_4.value());
            three.setName(GeneralEnum.ThreeCirclesType.type_4.label());
        }else{
            three.setCode(GeneralEnum.ThreeCirclesType.type_3.value());
            three.setName(GeneralEnum.ThreeCirclesType.type_3.label());
        }
        setCombat(three,force,intellect,troops);
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

        GeneralEnum.ThreeCirclesType type = GeneralEnum.ThreeCirclesType.type_5;
        GeneralThree three = new GeneralThree(general.getId(),type.value(),type.label());

        setCombat(three,force,intellect,troops);
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
        setCombat(three,force,intellect,troops);
        return three;
    }

    /**
     * 战器三维
     * @param general
     * @param analog
     * @return
     */
    public static List<GeneralThree> calculateWeapon(General general, GeneralAnalog analog, GeneralEnum.ThreeCirclesType type) {
        List<GeneralWeapon> weaponList = general.getWeaponList();
        List<GeneralThree> threeList = new ArrayList<>();
        for (GeneralWeapon generalWeapon : weaponList){
            GeneralEnum.Weapon weapon = IDictItem.getByValue(GeneralEnum.Weapon.class, generalWeapon.getWeaponCode());
            Map<String,Object> params = weapon.params();
            //基础
            int baseForce = 0;
            int baseIntellect = 0;
            int baseTroops = 0;
            if(GeneralEnum.ThreeCirclesType.type_7.value().equals(type.value())){
                baseForce = MapUtils.get(MapKeys.force,params);
                baseIntellect = MapUtils.get(MapKeys.intellect,params);
                baseTroops = MapUtils.get(MapKeys.troops,params);
            }else{
                baseForce = MapUtils.get(MapKeys.forcex,params);
                baseIntellect = MapUtils.get(MapKeys.intellectx,params);
                baseTroops = MapUtils.get(MapKeys.troopsx,params);
            }
            //强化
            int strengthenForce = MapUtils.get(MapKeys.strengthenForce,params);
            int strengthenIntellect = MapUtils.get(MapKeys.strengthenIntellect,params);
            int strengthenTroops = MapUtils.get(MapKeys.strengthenTroops,params);
            //淬炼
            double quenchingForceRate = MapUtils.get(MapKeys.quenchingForceRate,params);
            double quenchingIntellectRate = MapUtils.get(MapKeys.quenchingIntellectRate,params);
            double quenchingTroopsRate = MapUtils.get(MapKeys.quenchingTroopsRate,params);
            //专属
            int exclusiveForce = MapUtils.get(MapKeys.exclusiveForce,params);
            int exclusiveIntellect = MapUtils.get(MapKeys.exclusiveIntellect,params);
            int exclusiveTroops = MapUtils.get(MapKeys.exclusiveTroops,params);

            int force = baseForce + strengthenForce;
            int intellect = baseIntellect + strengthenIntellect;
            int troops = baseTroops + strengthenTroops;

            int quenchingForce = 0;
            int quenchingIntellect = 0;
            int quenchingTroops = 0;

            String quenchingName = null;
            if(troops >= force && troops >= intellect){//troops
                Double d = troops * quenchingTroopsRate;
                quenchingTroops = d.intValue()*2;
                troops += quenchingTroops;
                quenchingName = "战器的兵力值提升"+(int)(quenchingTroopsRate*100)+"%";
            }else if(force >= intellect){//force
                Double d = force * quenchingForceRate;
                quenchingForce = d.intValue()*2;
                force += quenchingForce;
                quenchingName = "战器的武力值提升"+(int)(quenchingForceRate*100)+"%";
            }else{//intellect
                Double d= intellect * quenchingIntellectRate;
                quenchingIntellect = d.intValue()*2;
                intellect += quenchingIntellect;
                quenchingName = "战器的智力值提升"+(int)(quenchingIntellectRate*100)+"%";
            }
            //专属
            force += exclusiveForce;
            intellect += exclusiveIntellect;
            troops += exclusiveTroops;

            GeneralThree three = new GeneralThree(general.getId(),type.value(),type.label());
            setCombat(three,force,intellect,troops);
            three.setRemark1(generalWeapon.getName()+"("+generalWeapon.getWeaponName()+")");
            three.setRemark2(quenchingName);
            three.setRemark3(baseForce+"/"+baseIntellect+"/"+baseTroops);
            three.setRemark4(strengthenForce+"/"+strengthenIntellect+"/"+strengthenTroops);
            three.setRemark5(quenchingForce+"/"+quenchingIntellect+"/"+quenchingTroops);
            three.setRemark6(exclusiveForce+"/"+exclusiveIntellect+"/"+exclusiveTroops);
            threeList.add(three);
        }
        return threeList;
    }

    /**
     * 计算兵种
     * @param general
     * @param analog
     * @return
     */
    public static GeneralThree calculateArms(General general, GeneralAnalog analog, GeneralEnum.ThreeCirclesType type) {
        GeneralThree maxThree = getBaseMaxThree(general);
        GeneralEnum.ThreeCirclesType type9 = GeneralEnum.ThreeCirclesType.type_9;
        GeneralEnum.ThreeCirclesType type10 = GeneralEnum.ThreeCirclesType.type_10;
        GeneralEnum.Arms arms = IDictItem.getByValue(GeneralEnum.Arms.class, general.getArmsCode());
        Map<String,Object> params = arms.params();

        GeneralThree three = new GeneralThree();
        three.setGeneralId(general.getId());
        Double force = 0d;
        Double intellect = 0d;
        Double troops = 0d;
        String armsName = null;
        double armsForceRate = 0d;
        double armsIntellectRate = 0d;
        double armsTroopsRate = 0d;
        if(type9.value().equals(type.value())){
            armsName = MapUtils.get(MapKeys.arms1,params);
            armsForceRate = MapUtils.get(MapKeys.armsForceRate1,params);
            armsIntellectRate = MapUtils.get(MapKeys.armsIntellectRate1,params);
            armsTroopsRate = MapUtils.get(MapKeys.armsTroopsRate1,params);

            three.setCode(type9.value());
            three.setName(type9.label());
        }else if(type10.value().equals(type.value())) {
            armsName = MapUtils.get(MapKeys.arms2, params);
            armsForceRate = MapUtils.get(MapKeys.armsForceRate2, params);
            armsIntellectRate = MapUtils.get(MapKeys.armsIntellectRate2, params);
            armsTroopsRate = MapUtils.get(MapKeys.armsTroopsRate2, params);

            three.setCode(type10.value());
            three.setName(type10.label());
        }

        force = maxThree.getForce() * armsForceRate;
        intellect = maxThree.getIntellect() * armsIntellectRate;
        troops = maxThree.getTroops() * armsTroopsRate;

        three.setRemark1(armsName);
        setCombat(three,force,intellect,troops);
        return three;
    }

    /**
     * 计算兵书
     * @param general
     * @param analog
     * @return
     */
    public static GeneralThree calculateArmsBook(General general, GeneralAnalog analog, GeneralEnum.ThreeCirclesType type) {
        //GeneralThree maxThree = getBaseMaxThree(general);
        GeneralArmsBook generalArmsBook = general.getArmsBook();

        GeneralEnum.ArmsPosition position1 = IDictItem.getByValue(GeneralEnum.ArmsPosition.class, generalArmsBook.getPositionCode1());
        GeneralEnum.ArmsPosition position2 = IDictItem.getByValue(GeneralEnum.ArmsPosition.class, generalArmsBook.getPositionCode2());
        GeneralEnum.ArmsPosition position3 = IDictItem.getByValue(GeneralEnum.ArmsPosition.class, generalArmsBook.getPositionCode3());
        GeneralEnum.ArmsPosition position4 = IDictItem.getByValue(GeneralEnum.ArmsPosition.class, generalArmsBook.getPositionCode4());
        GeneralEnum.ArmsPosition position5 = IDictItem.getByValue(GeneralEnum.ArmsPosition.class, generalArmsBook.getPositionCode5());

        Map<String,Object> params1 = position1.params();
        Map<String,Object> params2 = position2.params();
        Map<String,Object> params3 = position3.params();
        Map<String,Object> params4 = position4.params();
        Map<String,Object> params5 = position5.params();

        String position1_0 = MapUtils.get(MapKeys.position1, params1);
        String position1_1 = MapUtils.get(MapKeys.position2, params1);
        String position2_0 = MapUtils.get(MapKeys.position1, params2);
        String position2_1 = MapUtils.get(MapKeys.position2, params2);
        String position3_0 = MapUtils.get(MapKeys.position1, params3);
        String position3_1 = MapUtils.get(MapKeys.position2, params3);
        String position4_0 = MapUtils.get(MapKeys.position1, params4);
        String position4_1 = MapUtils.get(MapKeys.position2, params4);
        String position5_0 = MapUtils.get(MapKeys.position1, params5);
        String position5_1 = MapUtils.get(MapKeys.position2, params5);

        GeneralEnum.ArmsBook armsBook1_0 = IDictItem.getByLabel(GeneralEnum.ArmsBook.class,position1_0);
        GeneralEnum.ArmsBook armsBook1_1 = IDictItem.getByLabel(GeneralEnum.ArmsBook.class,position1_1);
        GeneralEnum.ArmsBook armsBook2_0 = IDictItem.getByLabel(GeneralEnum.ArmsBook.class,position2_0);
        GeneralEnum.ArmsBook armsBook2_1 = IDictItem.getByLabel(GeneralEnum.ArmsBook.class,position2_1);
        GeneralEnum.ArmsBook armsBook3_0 = IDictItem.getByLabel(GeneralEnum.ArmsBook.class,position3_0);
        GeneralEnum.ArmsBook armsBook3_1 = IDictItem.getByLabel(GeneralEnum.ArmsBook.class,position3_1);
        GeneralEnum.ArmsBook armsBook4_0 = IDictItem.getByLabel(GeneralEnum.ArmsBook.class,position4_0);
        GeneralEnum.ArmsBook armsBook4_1 = IDictItem.getByLabel(GeneralEnum.ArmsBook.class,position4_1);
        GeneralEnum.ArmsBook armsBook5_0 = IDictItem.getByLabel(GeneralEnum.ArmsBook.class,position5_0);
        GeneralEnum.ArmsBook armsBook5_1 = IDictItem.getByLabel(GeneralEnum.ArmsBook.class,position5_1);

        int armsBook1_0_f = MapUtils.get(MapKeys.force, armsBook1_0.params());
        int armsBook1_0_i = MapUtils.get(MapKeys.intellect, armsBook1_0.params());
        int armsBook1_0_t = MapUtils.get(MapKeys.troops, armsBook1_0.params());
        int armsBook1_1_f = MapUtils.get(MapKeys.force, armsBook1_1.params());
        int armsBook1_1_i = MapUtils.get(MapKeys.intellect, armsBook1_1.params());
        int armsBook1_1_t = MapUtils.get(MapKeys.troops, armsBook1_1.params());

        int armsBook2_0_f = MapUtils.get(MapKeys.force, armsBook2_0.params());
        int armsBook2_0_i = MapUtils.get(MapKeys.intellect, armsBook2_0.params());
        int armsBook2_0_t = MapUtils.get(MapKeys.troops, armsBook2_0.params());
        int armsBook2_1_f = MapUtils.get(MapKeys.force, armsBook2_1.params());
        int armsBook2_1_i = MapUtils.get(MapKeys.intellect, armsBook2_1.params());
        int armsBook2_1_t = MapUtils.get(MapKeys.troops, armsBook2_1.params());

        int armsBook3_0_f = MapUtils.get(MapKeys.force, armsBook3_0.params());
        int armsBook3_0_i = MapUtils.get(MapKeys.intellect, armsBook3_0.params());
        int armsBook3_0_t = MapUtils.get(MapKeys.troops, armsBook3_0.params());
        int armsBook3_1_f = MapUtils.get(MapKeys.force, armsBook3_1.params());
        int armsBook3_1_i = MapUtils.get(MapKeys.intellect, armsBook3_1.params());
        int armsBook3_1_t = MapUtils.get(MapKeys.troops, armsBook3_1.params());

        int armsBook4_0_f = MapUtils.get(MapKeys.force, armsBook4_0.params());
        int armsBook4_0_i = MapUtils.get(MapKeys.intellect, armsBook4_0.params());
        int armsBook4_0_t = MapUtils.get(MapKeys.troops, armsBook4_0.params());
        int armsBook4_1_f = MapUtils.get(MapKeys.force, armsBook4_1.params());
        int armsBook4_1_i = MapUtils.get(MapKeys.intellect, armsBook4_1.params());
        int armsBook4_1_t = MapUtils.get(MapKeys.troops, armsBook4_1.params());

        int armsBook5_0_f = MapUtils.get(MapKeys.force, armsBook5_0.params());
        int armsBook5_0_i = MapUtils.get(MapKeys.intellect, armsBook5_0.params());
        int armsBook5_0_t = MapUtils.get(MapKeys.troops, armsBook5_0.params());
        int armsBook5_1_f = MapUtils.get(MapKeys.force, armsBook5_1.params());
        int armsBook5_1_i = MapUtils.get(MapKeys.intellect, armsBook5_1.params());
        int armsBook5_1_t = MapUtils.get(MapKeys.troops, armsBook5_1.params());

        int force = 0;
        int intellect = 0;
        int troops = 0;
        List<String> bookList = new ArrayList<>();
        if(GeneralEnum.ThreeCirclesType.type_11.value().equals(type.value())){//上阵
            force += armsBook1_0_f + armsBook2_0_f + armsBook3_0_f + armsBook4_0_f + armsBook5_0_f;
            intellect += armsBook1_0_i + armsBook2_0_i + armsBook3_0_i + armsBook4_0_i + armsBook5_0_i;
            troops += armsBook1_0_t + armsBook2_0_t + armsBook3_0_t + armsBook4_0_t + armsBook5_0_t;
            bookList.add(armsBook1_0.label());
            bookList.add(armsBook2_0.label());
            bookList.add(armsBook3_0.label());
            bookList.add(armsBook4_0.label());
            bookList.add(armsBook5_0.label());
        }else if(GeneralEnum.ThreeCirclesType.type_12.value().equals(type.value())){//武随
            if(armsBook1_0_f >= armsBook1_1_f){ force += armsBook1_0_f; intellect += armsBook1_0_i; troops += armsBook1_0_t;bookList.add(armsBook1_0.label()); }else{ force += armsBook1_1_f; intellect += armsBook1_1_i; troops += armsBook1_1_t;bookList.add(armsBook1_1.label()); }
            if(armsBook2_0_f >= armsBook2_1_f){ force += armsBook2_0_f; intellect += armsBook2_0_i; troops += armsBook2_0_t;bookList.add(armsBook2_0.label()); }else{ force += armsBook2_1_f; intellect += armsBook2_1_i; troops += armsBook2_1_t;bookList.add(armsBook2_1.label()); }
            if(armsBook3_0_f >= armsBook3_1_f){ force += armsBook3_0_f; intellect += armsBook3_0_i; troops += armsBook3_0_t;bookList.add(armsBook3_0.label()); }else{ force += armsBook3_1_f; intellect += armsBook3_1_i; troops += armsBook3_1_t;bookList.add(armsBook3_1.label()); }
            if(armsBook4_0_f >= armsBook4_1_f){ force += armsBook4_0_f; intellect += armsBook4_0_i; troops += armsBook4_0_t;bookList.add(armsBook4_0.label()); }else{ force += armsBook4_1_f; intellect += armsBook4_1_i; troops += armsBook4_1_t;bookList.add(armsBook4_1.label()); }
            if(armsBook5_0_f >= armsBook5_1_f){ force += armsBook5_0_f; intellect += armsBook5_0_i; troops += armsBook5_0_t;bookList.add(armsBook5_0.label()); }else{ force += armsBook5_1_f; intellect += armsBook5_1_i; troops += armsBook5_1_t;bookList.add(armsBook5_1.label()); }
        }else if(GeneralEnum.ThreeCirclesType.type_13.value().equals(type.value())){//智随
            if(armsBook1_0_i >= armsBook1_1_i){ force += armsBook1_0_f; intellect += armsBook1_0_i; troops += armsBook1_0_t;bookList.add(armsBook1_0.label()); }else{ force += armsBook1_1_f; intellect += armsBook1_1_i; troops += armsBook1_1_t;bookList.add(armsBook1_1.label()); }
            if(armsBook2_0_i >= armsBook2_1_i){ force += armsBook2_0_f; intellect += armsBook2_0_i; troops += armsBook2_0_t;bookList.add(armsBook2_0.label()); }else{ force += armsBook2_1_f; intellect += armsBook2_1_i; troops += armsBook2_1_t;bookList.add(armsBook2_1.label()); }
            if(armsBook3_0_i >= armsBook3_1_i){ force += armsBook3_0_f; intellect += armsBook3_0_i; troops += armsBook3_0_t;bookList.add(armsBook3_0.label()); }else{ force += armsBook3_1_f; intellect += armsBook3_1_i; troops += armsBook3_1_t;bookList.add(armsBook3_1.label()); }
            if(armsBook4_0_i >= armsBook4_1_i){ force += armsBook4_0_f; intellect += armsBook4_0_i; troops += armsBook4_0_t;bookList.add(armsBook4_0.label()); }else{ force += armsBook4_1_f; intellect += armsBook4_1_i; troops += armsBook4_1_t;bookList.add(armsBook4_1.label()); }
            if(armsBook5_0_i >= armsBook5_1_i){ force += armsBook5_0_f; intellect += armsBook5_0_i; troops += armsBook5_0_t;bookList.add(armsBook5_0.label()); }else{ force += armsBook5_1_f; intellect += armsBook5_1_i; troops += armsBook5_1_t;bookList.add(armsBook5_1.label()); }
        }else if(GeneralEnum.ThreeCirclesType.type_14.value().equals(type.value())){//兵随
            if(armsBook1_0_t >= armsBook1_1_t){ force += armsBook1_0_f; intellect += armsBook1_0_i; troops += armsBook1_0_t;bookList.add(armsBook1_0.label()); }else{ force += armsBook1_1_f; intellect += armsBook1_1_i; troops += armsBook1_1_t;bookList.add(armsBook1_1.label()); }
            if(armsBook2_0_t >= armsBook2_1_t){ force += armsBook2_0_f; intellect += armsBook2_0_i; troops += armsBook2_0_t;bookList.add(armsBook2_0.label()); }else{ force += armsBook2_1_f; intellect += armsBook2_1_i; troops += armsBook2_1_t;bookList.add(armsBook2_1.label()); }
            if(armsBook3_0_t >= armsBook3_1_t){ force += armsBook3_0_f; intellect += armsBook3_0_i; troops += armsBook3_0_t;bookList.add(armsBook3_0.label()); }else{ force += armsBook3_1_f; intellect += armsBook3_1_i; troops += armsBook3_1_t;bookList.add(armsBook3_1.label()); }
            if(armsBook4_0_t >= armsBook4_1_t){ force += armsBook4_0_f; intellect += armsBook4_0_i; troops += armsBook4_0_t;bookList.add(armsBook4_0.label()); }else{ force += armsBook4_1_f; intellect += armsBook4_1_i; troops += armsBook4_1_t;bookList.add(armsBook4_1.label()); }
            if(armsBook5_0_t >= armsBook5_1_t){ force += armsBook5_0_f; intellect += armsBook5_0_i; troops += armsBook5_0_t;bookList.add(armsBook5_0.label()); }else{ force += armsBook5_1_f; intellect += armsBook5_1_i; troops += armsBook5_1_t;bookList.add(armsBook5_1.label()); }
        }

        GeneralThree three = new GeneralThree(general.getId(),type.value(),type.label());
        three.setRemark1(StringUtils.join(bookList,"/"));
        setCombat(three,force,intellect,troops);
        return three;
    }

    public static GeneralThree calculateWillSoul(General general, GeneralAnalog analog, GeneralEnum.ThreeCirclesType type) {
        GeneralEnum.GeneralsType generalsType = IDictItem.getByValue(GeneralEnum.GeneralsType.class, general.getTypeCode());
        Map<String,Object> params = generalsType.params();
        int growForce = MapUtils.get(MapKeys.growForce,params);
        int growIntellect = MapUtils.get(MapKeys.growIntellect,params);
        int growTroops = MapUtils.get(MapKeys.growTroops,params);

        int force = growForce * 4 * 30;
        int intellect = growIntellect * 4 * 30;
        int troops = growTroops * 4 * 30;

        troops += 200;

        GeneralThree three = new GeneralThree(general.getId(),type.value(),type.label());
        setCombat(three,force,intellect,troops);
        return three;
    }

    public static GeneralThree calculateBattleArray(General general, GeneralAnalog analog) {
        GeneralEnum.ThreeCirclesType type = GeneralEnum.ThreeCirclesType.type_17;
        GeneralThree three = new GeneralThree(general.getId(),type.value(),type.label());
        GeneralThree maxThree = getBaseMaxThree(general);

        Double rate = 0.1;
        Double force = maxThree.getForce() * rate;
        Double intellect = maxThree.getIntellect() * rate;
        Double troops = maxThree.getTroops() * rate;
        setCombat(three,force,intellect,troops);
        return three;
    }

    public static GeneralThree calculateDestiny(General general, GeneralAnalog analog) {
        GeneralEnum.DestinyType destinyType = IDictItem.getByValue(GeneralEnum.DestinyType.class, general.getDestinyCode());
        Map<String,Object> params = destinyType.params();
        int force = MapUtils.get(MapKeys.force,params);
        int intellect = MapUtils.get(MapKeys.intellect,params);
        int troops = MapUtils.get(MapKeys.troops,params);
        GeneralEnum.ThreeCirclesType type = GeneralEnum.ThreeCirclesType.type_18;
        GeneralThree three = new GeneralThree(general.getId(),type.value(),type.label());
        setCombat(three,force,intellect,troops);
        return three;
    }

    public static GeneralThree calculateSkin(General general, GeneralAnalog analog) {
        GeneralSkin generalSkin = general.getGeneralSkin();
        int force = 0;
        int intellect = 0;
        int troops = 0;
        String skinName = null;
        if(generalSkin != null){
            force = generalSkin.getForce();
            intellect = generalSkin.getIntellect();
            troops = generalSkin.getTroops();
            skinName = generalSkin.getName();
        }
        GeneralEnum.ThreeCirclesType type = GeneralEnum.ThreeCirclesType.type_19;
        GeneralThree three = new GeneralThree(general.getId(),type.value(),type.label());
        three.setRemark1(skinName);
        setCombat(three,force,intellect,troops);
        return three;
    }

    public static GeneralThree calculateEmbattle(General general, GeneralAnalog analog) {
        GeneralEnum.Embattle embattle = IDictItem.getByValue(GeneralEnum.Embattle.class, analog.getEmbattle().value());
        Map<String,Object> params = embattle.params();
        int force = MapUtils.get(MapKeys.maxForce,params);
        int intellect = MapUtils.get(MapKeys.maxIntellect,params);
        int troops = MapUtils.get(MapKeys.maxTroops,params);

        GeneralEnum.ThreeCirclesType type = GeneralEnum.ThreeCirclesType.type_20;
        GeneralThree three = new GeneralThree(general.getId(),type.value(),type.label());
        setCombat(three,force,intellect,troops);
        return three;
    }

    public static GeneralThree calculateWarpath(General general, GeneralAnalog analog) {
        GeneralThree maxThree = getBaseMaxThree(general);

        Double rate = 0.1;
        Double force = maxThree.getForce() * rate;
        Double intellect = maxThree.getIntellect() * rate;
        Double troops = maxThree.getTroops() * rate;

        GeneralEnum.ThreeCirclesType type = GeneralEnum.ThreeCirclesType.type_21;
        GeneralThree three = new GeneralThree(general.getId(),type.value(),type.label());
        setCombat(three,force,intellect,troops);
        return three;
    }

    public static List<GeneralThree> calculateEntourage(General general, GeneralAnalog analog, GeneralEnum.ThreeCirclesType type) {
        int force = 0;
        int intellect = 0;
        int troops = 0;
        String bz = null;//兵种
        String bs = null;//兵书
        String hh = null;//幻化

        GeneralThree three0 = getBaseMaxThree(general);//满级三维
        GeneralThree three5 = getThree(general, GeneralEnum.ThreeCirclesType.type_5);//科技
        GeneralThree three6 = getThree(general, GeneralEnum.ThreeCirclesType.type_6);//四圣石
        GeneralThree three16 = getThree(general, GeneralEnum.ThreeCirclesType.type_15);//将魂
        GeneralThree three18 = getThree(general, GeneralEnum.ThreeCirclesType.type_18);//命格
        GeneralThree three19 = getThree(general, GeneralEnum.ThreeCirclesType.type_19);//幻化

        if(three19 != null){
            hh = three19.getRemark1();
        }

        force += three0.getForce()+three5.getForce()+three6.getForce()+three16.getForce()+three18.getForce()+three19.getForce();
        intellect += three0.getIntellect()+three5.getIntellect()+three6.getIntellect()+three16.getIntellect()+three18.getIntellect()+three19.getIntellect();
        troops += three0.getTroops()+three5.getTroops()+three6.getTroops()+three16.getTroops()+three18.getTroops()+three19.getTroops();

        GeneralThree three9 = getThree(general, GeneralEnum.ThreeCirclesType.type_9);//兵种1
        GeneralThree three10 = getThree(general, GeneralEnum.ThreeCirclesType.type_10);//兵种2
        GeneralThree three12 = getThree(general, GeneralEnum.ThreeCirclesType.type_12);//武随兵书
        GeneralThree three13 = getThree(general, GeneralEnum.ThreeCirclesType.type_13);//智随兵书
        GeneralThree three14 = getThree(general, GeneralEnum.ThreeCirclesType.type_14);//兵随兵书

        GeneralEnum.ThreeCirclesType type2 = null;
        if(GeneralEnum.ThreeCirclesType.type_22.value().equals(type.value())){//武随三维
            type2 = GeneralEnum.ThreeCirclesType.type_23;
            if(three9.getForce() >= three10.getForce()){
                force += three9.getForce();
                intellect += three9.getIntellect();
                troops += three9.getTroops();
                bz = three9.getRemark1();
            }else{
                force += three10.getForce();
                intellect += three10.getIntellect();
                troops += three10.getTroops();
                bz = three10.getRemark1();
            }
            force += three12.getForce();
            intellect += three12.getIntellect();
            troops += three12.getTroops();
            bs = three12.getRemark1();
        }else if(GeneralEnum.ThreeCirclesType.type_24.value().equals(type.value())){//智随三维
            type2 = GeneralEnum.ThreeCirclesType.type_25;
            if(three9.getIntellect() >= three10.getIntellect()){
                force += three9.getForce();
                intellect += three9.getIntellect();
                troops += three9.getTroops();
                bz = three9.getRemark1();
            }else{
                force += three10.getForce();
                intellect += three10.getIntellect();
                troops += three10.getTroops();
                bz = three10.getRemark1();
            }
            force += three13.getForce();
            intellect += three13.getIntellect();
            troops += three13.getTroops();
            bs = three13.getRemark1();
        }else if(GeneralEnum.ThreeCirclesType.type_26.value().equals(type.value())){//兵随三维
            type2 = GeneralEnum.ThreeCirclesType.type_27;
            if(three9.getTroops() >= three10.getTroops()){
                force += three9.getForce();
                intellect += three9.getIntellect();
                troops += three9.getTroops();
                bz = three9.getRemark1();
            }else{
                force += three10.getForce();
                intellect += three10.getIntellect();
                troops += three10.getTroops();
                bz = three10.getRemark1();
            }
            force += three14.getForce();
            intellect += three14.getIntellect();
            troops += three14.getTroops();
            bs = three14.getRemark1();
        }

        //非联协
        List<GeneralThree> threeList = new ArrayList<>();
        GeneralThree three2 = new GeneralThree(general.getId(),type2.value(),type2.label());
        force = force / 2 + 100;//满将魂+100属性
        intellect = intellect / 2 + 100;
        troops = troops / 2 + 100;
        three2.setRemark1(bz);
        three2.setRemark2(bs);
        three2.setRemark3(hh);
        setCombat(three2,force,intellect,troops);

        //联协
        GeneralThree three1 = new GeneralThree(general.getId(),type.value(),type.label());
        Double force0 = force * 1.25;
        Double intellect0 = intellect * 1.25;
        Double troops0 = troops * 1.25;
        three1.setRemark1(bz);
        three1.setRemark2(bs);
        three1.setRemark3(hh);
        setCombat(three1,force0.intValue(),intellect0.intValue(),troops0.intValue());

        threeList.add(three1);
        threeList.add(three2);
        return threeList;
    }
}
