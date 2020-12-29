package com.ivy.admin.utils.ppsg;

import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.entity.ppsg.GeneralArmsBook;
import com.ivy.admin.entity.ppsg.GeneralAssociation;
import com.ivy.admin.entity.ppsg.GeneralSkillActive;
import com.ivy.admin.entity.ppsg.GeneralSkillPassive;
import com.ivy.admin.entity.ppsg.GeneralSkin;
import com.ivy.admin.entity.ppsg.GeneralThree;
import com.ivy.admin.entity.ppsg.GeneralWarpath;
import com.ivy.admin.entity.ppsg.GeneralWeapon;
import com.ivy.admin.enums.ppsg.GeneralEnum;

import java.util.ArrayList;
import java.util.List;

public class GeneralTest {

    public static void main(String[] args) {
        createGeneral();
    }

    public static void createGeneral() {
        GeneralEnum.Gender gender = GeneralEnum.Gender.man;
        GeneralEnum.Country country = GeneralEnum.Country.shu;
        GeneralEnum.Star star = GeneralEnum.Star.star5;
        GeneralEnum.Arms arms = GeneralEnum.Arms.qi;
        GeneralEnum.GeneralsType type = GeneralEnum.GeneralsType.type8;
        GeneralEnum.Category category = GeneralEnum.Category.ni_ming;
        GeneralEnum.DestinyType2 destinyType = GeneralEnum.DestinyType2.ni_ming_1;
        GeneralEnum.Weapon weapon = GeneralEnum.Weapon.arch;
        GeneralEnum.ThreeCirclesType type_1 = GeneralEnum.ThreeCirclesType.type_1;
        GeneralEnum.ThreeCirclesType type_2 = GeneralEnum.ThreeCirclesType.type_2;

        General general = new General();
        general.setId(1l);//编号
        general.setName("陨星庞统");//名称
        general.setLevel(1);//等级
        general.setGenderCode(gender.value());//性别
        general.setGenderName(gender.label());//性别
        general.setCountryCode(country.value());//国家
        general.setCountryName(country.label());//国家
        general.setStarCode(star.value());//星级
        general.setStarName(star.label());//星级
        general.setArmsCode(arms.value());//兵种
        general.setArmsName(arms.label());//兵种
        general.setTypeCode(type.value());//武将类型
        general.setTypeName(type.label());//武将类型
        general.setCategoryCode(category.value());//进阶
        general.setCategoryName(category.label());//进阶
        general.setDestinyCode(destinyType.value());//命格类型
        general.setDestinyName(destinyType.label());//命格类型
        //联协
        List<GeneralAssociation> associationList = new ArrayList<>();
        associationList.add(new GeneralAssociation("旷世奇才",11l,"诸葛亮",0.25));
        //战器
        List<GeneralWeapon> weaponList = new ArrayList<>();
        weaponList.add(new GeneralWeapon("惊凰弓",weapon.value(),weapon.label(),general.getId(),general.getName()));
        //将魂、四圣石、兵符
        //主动技能active、被动技能passive
        List<GeneralSkillActive> skillActiveList = new ArrayList<>();
        List<GeneralSkillPassive> skillPassiveList = new ArrayList<>();
        //命格
        //兵书
        GeneralEnum.ArmsPosition armsPosition1 = GeneralEnum.ArmsPosition.jiao_li;
        GeneralEnum.ArmsPosition armsPosition2 = GeneralEnum.ArmsPosition.zhan_lue;
        GeneralEnum.ArmsPosition armsPosition3 = GeneralEnum.ArmsPosition.zhan_lue;
        GeneralEnum.ArmsPosition armsPosition4 = GeneralEnum.ArmsPosition.fang_yu;
        GeneralEnum.ArmsPosition armsPosition5 = GeneralEnum.ArmsPosition.zhan_lue;
        GeneralArmsBook armsBook = new GeneralArmsBook(general.getId(),general.getName(),armsPosition1.value(),armsPosition1.label(),armsPosition2.value(),armsPosition2.label(),armsPosition3.value(),armsPosition3.label(),armsPosition4.value(),armsPosition4.label(),armsPosition5.value(),armsPosition5.label());
        //战意
        List<GeneralWarpath> warpathList = new ArrayList<>();
        GeneralUtils.calculateWarpathThree(general,warpathList);
        //幻化
        GeneralSkin generalSkin = new GeneralSkin("星火燎原",general.getId(),general.getName(),30,30,80);
        //三维属性：武智兵
        List<GeneralThree> threeList = new ArrayList<>();
        threeList.add(new GeneralThree(general.getId(),type_1.value(),type_1.label(),460,712,616));//基础三维
        threeList.add(new GeneralThree(general.getId(),type_2.value(),type_2.label()));//异化基础三维
        GeneralUtils.calculateThree(general,threeList);

        general.setDelFlag(false);
        general.setEnableFlag(true);
        System.out.println(general);
    }
    
}
