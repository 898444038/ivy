package com.ivy.admin.utils.ppsg;

import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.entity.ppsg.GeneralArmsBook;
import com.ivy.admin.entity.ppsg.GeneralAssociation;
import com.ivy.admin.entity.ppsg.GeneralSkillActive;
import com.ivy.admin.entity.ppsg.GeneralSkillPassive;
import com.ivy.admin.entity.ppsg.GeneralSkin;
import com.ivy.admin.entity.ppsg.GeneralThree;
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

        GeneralEnum.General4 general4 = GeneralEnum.General4.shu_pangtong;
        GeneralEnum.General4 general_zhugeliang = GeneralEnum.General4.shu_zhugeliang;
        GeneralEnum.General4 general_liubei = GeneralEnum.General4.shu_liubei;
        GeneralEnum.General4 general_lusu = GeneralEnum.General4.wu_lusu;
        GeneralEnum.General4 general_huangyueying = GeneralEnum.General4.shu_huangyueying;
        GeneralEnum.General4 general_zhangfei = GeneralEnum.General4.shu_zhangfei;
        GeneralEnum.General4 general_fazheng = GeneralEnum.General4.shu_fazheng;
        Long id = 50001L;
        String name = "陨星庞统";

        General general = new General();
        general.setId(id);//编号
        general.setName(name);//名称
        general.setLevel(1);//等级
        general.setParentId(general4.value().longValue());
        general.setParentName(general4.label());
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
        associationList.add(new GeneralAssociation("旷世奇才",general_zhugeliang.value().longValue(),general_zhugeliang.label(),0.25));
        associationList.add(new GeneralAssociation("的卢误主",general_liubei.value().longValue(),general_liubei.label(),0.25));
        associationList.add(new GeneralAssociation("荐而不用",general_lusu.value().longValue(),general_lusu.label(),0.25));
        associationList.add(new GeneralAssociation("蜕羽成华",general_huangyueying.value().longValue(),general_huangyueying.label(),0.25));
        associationList.add(new GeneralAssociation("心服口服",general_zhangfei.value().longValue(),general_zhangfei.label(),0.25));
        associationList.add(new GeneralAssociation("意气相投",general_fazheng.value().longValue(),general_fazheng.label(),0.25));
        general.setAssociationList(associationList);
        //战器
        List<GeneralWeapon> weaponList = new ArrayList<>();
        weaponList.add(new GeneralWeapon("惊凰弓",weapon.value(),weapon.label(),id,name));
        general.setWeaponList(weaponList);
        //将魂、四圣石、兵符
        //主动技能active
        List<GeneralSkillActive> skillActiveList = new ArrayList<>();
        skillActiveList.add(new GeneralSkillActive(id,name,"落凤焚羽",3,""));
        skillActiveList.add(new GeneralSkillActive(id,name,"逆·落凤焚羽",3,""));
        general.setSkillActiveList(skillActiveList);
        //被动技能passive
        List<GeneralSkillPassive> skillPassiveList = new ArrayList<>();
        skillPassiveList.add(new GeneralSkillPassive());
        general.setSkillPassiveList(skillPassiveList);
        //命格

        //兵书
        GeneralEnum.ArmsPosition armsPosition1 = GeneralEnum.ArmsPosition.jiao_li;
        GeneralEnum.ArmsPosition armsPosition2 = GeneralEnum.ArmsPosition.zhan_lue;
        GeneralEnum.ArmsPosition armsPosition3 = GeneralEnum.ArmsPosition.zhan_lue;
        GeneralEnum.ArmsPosition armsPosition4 = GeneralEnum.ArmsPosition.fang_yu;
        GeneralEnum.ArmsPosition armsPosition5 = GeneralEnum.ArmsPosition.zhan_lue;
        GeneralArmsBook armsBook = new GeneralArmsBook(id,name,armsPosition1.value(),armsPosition1.label(),armsPosition2.value(),armsPosition2.label(),armsPosition3.value(),armsPosition3.label(),armsPosition4.value(),armsPosition4.label(),armsPosition5.value(),armsPosition5.label());
        general.setArmsBook(armsBook);
        //幻化
        GeneralSkin generalSkin = new GeneralSkin("星火燎原",id,name,30,30,80);
        general.setGeneralSkin(generalSkin);
        //三维属性：武智兵
        List<GeneralThree> threeList = new ArrayList<>();
        threeList.add(new GeneralThree(id,type_1.value(),type_1.label(),460,712,616));//基础三维
        threeList.add(new GeneralThree(id,type_2.value(),type_2.label()));//异化基础三维
        GeneralUtils.calculateThree(general,460,712,616,0,0,0);

        general.setDelFlag(false);
        general.setEnableFlag(true);
        System.out.println(general);

    }
    
}
