package com.ivy.admin.utils.ppsg;

import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.entity.ppsg.GeneralSkin;
import com.ivy.admin.entity.ppsg.GeneralThree;
import com.ivy.admin.enums.ppsg.GeneralsEnum;

import java.util.ArrayList;
import java.util.List;

public class GeneralTest {

    public static void main(String[] args) {
        System.out.println();
        //createGeneral();
    }

    public static void createGeneral() {
        GeneralsEnum.Country country = GeneralsEnum.Country.wei;
        GeneralsEnum.Star star = GeneralsEnum.Star.star5;
        GeneralsEnum.Arms arms = GeneralsEnum.Arms.ride;
        GeneralsEnum.GeneralsType type = GeneralsEnum.GeneralsType.GeneralsType_7;


        General general = new General();
        general.setId(1l);
        general.setName("");//名称
        general.setLevel(1);//等级
        general.setCountryCode(country.getCode());//国家
        general.setCountryName(country.getName());//国家
        general.setStarCode(star.getCode());//星级
        general.setStarName(star.getName());//星级
        general.setArmsCode(arms.getCode());//兵种
        general.setArmsName(arms.getName());//兵种
        general.setTypeCode(type.getCode());//武将类型
        general.setTypeName(type.getName());//武将类型

        List<GeneralThree> threeList = new ArrayList<>();
//39921 6147
        general.setDelFlag(false);
        general.setEnableFlag(true);

        //名称、国家、星级、等级、兵种、武将类型
        //属性：武智兵
        //联协、战器、技能、被动、战意、将魂、四圣石、兵书、命格
        GeneralSkin generalSkin = new GeneralSkin();//幻化
    }
    
}
