package com.ivy.admin.utils.ppsg;

import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.entity.ppsg.GeneralAnalog;
import com.ivy.admin.entity.ppsg.GeneralArmsBook;
import com.ivy.admin.entity.ppsg.GeneralAssociation;
import com.ivy.admin.entity.ppsg.GeneralSkin;
import com.ivy.admin.entity.ppsg.GeneralThree;
import com.ivy.admin.entity.ppsg.GeneralWeapon;
import com.ivy.admin.enums.ppsg.GeneralEnum;
import com.ivy.admin.utils.ReadWriteExcel;
import com.ivy.admin.vo.ppsg.GeneralVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainService {

    public static List<General> getExcelData(){
        String path = "/excel/data_temp.xlsx";
        System.out.println("开始读取EXCEL："+path);
        long t1 = System.currentTimeMillis();
        ReadWriteExcel readWriteExcel = new ReadWriteExcel();
        readWriteExcel.setRow(1);
        List<List<String>> dataList = readWriteExcel.readRelativeExcel(path);
        List<Map<String, String>> lists = readWriteExcel.transformMap(dataList);
        long t2 = System.currentTimeMillis();
        System.out.println("获取数据耗时："+(t2-t1)+"ms");
        System.out.println("获取初始数据："+lists.size()+"条");

        List<General> generalList = new ArrayList<>();
        General general = null;
        for(Map<String, String> data : lists){
            if(data.get("usable") == null || "false".equalsIgnoreCase(data.get("usable"))){
                continue;
            }
            general = new General();
            general.setId(Double.valueOf(data.get("id")).longValue());
            general.setName(data.get("name"));
            general.setLevel(1);

            if(data.get("usable") == null || "false".equalsIgnoreCase(data.get("usable"))){
                general.setResonance(false);
            }else{
                general.setResonance(true);
            }

            //父级
            String generalsCode = data.get("generalsCode");
            String[] parentNames = generalsCode.split(",");
            List<String> ids = new ArrayList<>();
            List<String> names = new ArrayList<>();
            for(String parentName : parentNames){
                Integer parentId = GeneralEnum.getDicByLabel("General4",parentName);
                ids.add(parentId.toString());
                names.add(parentName);
            }
            general.setParentIds(String.join(",",ids));
            general.setParentNames(String.join(",",names));

            String genderName = data.get("gender");
            int genderCode = GeneralEnum.getDicByLabel("Gender",genderName);
            general.setGenderCode(genderCode);
            general.setGenderName(genderName);

            general.setForce(Double.valueOf(data.get("force")).intValue());
            general.setIntellect(Double.valueOf(data.get("intellect")).intValue());
            general.setTroops(Double.valueOf(data.get("troops")).intValue());

            if(data.get("force_x")!=null){
                general.setForcex(Double.valueOf(data.get("force_x")).intValue());
            }
            if(data.get("intellect_x")!=null) {
                general.setIntellectx(Double.valueOf(data.get("intellect_x")).intValue());
            }
            if(data.get("troops_x")!=null) {
                general.setTroopsx(Double.valueOf(data.get("troops_x")).intValue());
            }
            Integer forcex = general.getForcex();
            Integer intellectx = general.getIntellectx();
            Integer troopsx = general.getTroopsx();
            if (forcex != null && forcex != 0 && intellectx != null && intellectx != 0 && troopsx != null && troopsx != 0){
                general.setCardCode(GeneralEnum.CardType.yi_hua.value());
                general.setCardName(GeneralEnum.CardType.yi_hua.label());
            }else{
                general.setCardCode(GeneralEnum.CardType.pu_tong.value());
                general.setCardName(GeneralEnum.CardType.pu_tong.label());
            }

            String countryName = data.get("country");
            int countryCode = GeneralEnum.getDicByLabel("Country",countryName);
            general.setCountryCode(countryCode);
            general.setCountryName(countryName);

            general.setStarCode(GeneralEnum.Star.star5.value());
            general.setStarName(GeneralEnum.Star.star5.label());

            String armsName = data.get("arms");
            int armsCode = GeneralEnum.getDicByLabel("Arms",armsName);
            general.setArmsCode(armsCode);
            general.setArmsName(armsName);

            String typeName = data.get("generalsType");
            int typeCode = GeneralEnum.getDicByLabel("GeneralsType",typeName);
            general.setTypeCode(typeCode);
            general.setTypeName(typeName);

            String categoryName = data.get("category");
            int categoryCode = GeneralEnum.getDicByLabel("Category",categoryName);
            general.setTypeCode(categoryCode);
            general.setTypeName(categoryName);

            String destinyName = data.get("destiny");
            int destinyCode = GeneralEnum.getDicByLabel("DestinyType",destinyName);
            general.setDestinyCode(destinyCode);
            general.setDestinyName(destinyName);

            String[] entourages = data.get("entourage").split(",");
            List<GeneralAssociation> associationList = new ArrayList<>();
            GeneralAssociation association = null;
            for (String entourageName : entourages){
                association = new GeneralAssociation();
                long id = GeneralEnum.getDicByLabel("General4",entourageName);
                association.setParentId(id);
                association.setParentName(entourageName);
                association.setRate(0.25);
                associationList.add(association);
            }
            general.setAssociationList(associationList);

            List<GeneralWeapon> weaponList = new ArrayList<>();
            String war1 = data.get("war1");
            String warName1 = data.get("warName1");
            if(war1!=null && warName1!=null) {
                int id1 = GeneralEnum.getDicByLabel("Weapon", war1);
                GeneralWeapon weapon1 = new GeneralWeapon();
                weapon1.setWeaponCode(id1);
                weapon1.setWeaponName(war1);
                weapon1.setName(warName1);
                weaponList.add(weapon1);
            }
            String war2 = data.get("war2");
            String warName2 = data.get("warName2");
            if(war2!=null && warName2!=null){
                int id2 = GeneralEnum.getDicByLabel("Weapon",war2);
                GeneralWeapon weapon2 = new GeneralWeapon();
                weapon2.setWeaponCode(id2);
                weapon2.setWeaponName(war2);
                weapon2.setName(warName2);
                weaponList.add(weapon2);
            }
            general.setWeaponList(weaponList);

            GeneralArmsBook armsBook = new GeneralArmsBook();
            String position1 = data.get("book1");
            String position2 = data.get("book2");
            String position3 = data.get("book3");
            String position4 = data.get("book4");
            String position5 = data.get("book5");
            int code1 = GeneralEnum.getDicByLabel("ArmsPosition",position1);
            int code2 = GeneralEnum.getDicByLabel("ArmsPosition",position2);
            int code3 = GeneralEnum.getDicByLabel("ArmsPosition",position3);
            int code4 = GeneralEnum.getDicByLabel("ArmsPosition",position4);
            int code5 = GeneralEnum.getDicByLabel("ArmsPosition",position5);
            armsBook.setPositionCode1(code1);
            armsBook.setPositionCode2(code2);
            armsBook.setPositionCode3(code3);
            armsBook.setPositionCode4(code4);
            armsBook.setPositionCode5(code5);
            armsBook.setPositionName1(position1);
            armsBook.setPositionName2(position2);
            armsBook.setPositionName3(position3);
            armsBook.setPositionName4(position4);
            armsBook.setPositionName5(position5);
            general.setArmsBook(armsBook);
            GeneralSkin skin = new GeneralSkin();
            skin.setName(data.get("skin"));
            skin.setForce(30);
            skin.setIntellect(30);
            skin.setTroops(80);
            skin.setGeneralName(general.getName());
            skin.setGeneralId(general.getId());
            general.setGeneralSkin(skin);

            GeneralAnalog analog = new GeneralAnalog();
            List<GeneralThree> threeList = GeneralUtils.calculateThree(general,analog);
            general.setThreeList(threeList);
            generalList.add(general);
        }
        return generalList;
    }

}
