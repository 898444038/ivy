package com.ivy.admin.utils.ppsg;

import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.entity.ppsg.GeneralSkin;
import com.ivy.admin.entity.ppsg.GeneralThree;
import com.ivy.admin.enums.ppsg.GeneralEnum;
import com.ivy.admin.enums.ppsg.GeneralsEnum;

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
        //联协、战器、技能、被动、将魂、四圣石、命格、兵书、战意
        GeneralSkin generalSkin = new GeneralSkin("星火燎原",general.getId(),general.getName(),30,30,80);//幻化
        //三维属性：武智兵
        List<GeneralThree> threeList = GeneralUtils.calculateThree(general);
        general.setDelFlag(false);
        general.setEnableFlag(true);
        System.out.println(general);
    }
    
}
