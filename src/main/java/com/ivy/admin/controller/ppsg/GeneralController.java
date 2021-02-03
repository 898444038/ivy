package com.ivy.admin.controller.ppsg;

import com.github.benmanes.caffeine.cache.Cache;
import com.ivy.admin.entity.ppsg.GeneralAnalog;
import com.ivy.admin.entity.ppsg.GeneralArmsBook;
import com.ivy.admin.entity.ppsg.GeneralAssociation;
import com.ivy.admin.entity.ppsg.GeneralSkillActive;
import com.ivy.admin.entity.ppsg.GeneralSkillPassive;
import com.ivy.admin.entity.ppsg.GeneralSkin;
import com.ivy.admin.entity.ppsg.GeneralThree;
import com.ivy.admin.entity.ppsg.GeneralWeapon;
import com.ivy.admin.enums.ppsg.GeneralEnum;
import com.ivy.admin.service.ppsg.GeneralArmsBookService;
import com.ivy.admin.service.ppsg.GeneralAssociationService;
import com.ivy.admin.service.ppsg.GeneralService;
import com.ivy.admin.service.ppsg.GeneralSkinService;
import com.ivy.admin.service.ppsg.GeneralThreeService;
import com.ivy.admin.service.ppsg.GeneralWeaponService;
import com.ivy.admin.utils.ReadWriteExcel;
import com.ivy.admin.utils.ppsg.GeneralUtils;
import com.ivy.admin.vo.ppsg.GeneralVo;
import com.ivy.admin.entity.ppsg.General;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import com.ivy.system.config.CacheKeys;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ivy.admin.aspect.log.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 武将
 * @author: Administrator
 * @date: 2020-12-30
 */
@RestController
@RequestMapping("/ppsg/general")
public class GeneralController {
    @Autowired
    private Cache<String, Object> cache;
    @Autowired
    private GeneralService generalService;
    @Autowired
    private GeneralAssociationService generalAssociationService;
    @Autowired
    private GeneralWeaponService generalWeaponService;
    @Autowired
    private GeneralArmsBookService generalArmsBookService;
    @Autowired
    private GeneralSkinService generalSkinService;
    @Autowired
    private GeneralThreeService generalThreeService;

    @Log("ppsg.General")
    @PostMapping("/getDic")
    public ResultMsg getDic(@RequestBody GeneralVo generalVo){
        Map<String,List<Map<String,Object>>> map = GeneralEnum.getDic(generalVo.getDicName());
        return ResultMsg.success(map);
    }

    /**
     * 新增&保存
     */
    @Log("ppsg.General")
    @PostMapping("/save")
    public ResultMsg save(@RequestBody GeneralVo general){
        //联协
        List<GeneralAssociation> associationList = general.getAssociationList();
        List<GeneralWeapon> weaponList = general.getWeaponList();
        GeneralArmsBook armsBook = general.getArmsBook();
        GeneralSkin generalSkin = general.getGeneralSkin();

        if(general.getId() == null){
            String name = general.getName();
            Integer force = general.getForce();
            Integer intellect = general.getIntellect();
            Integer troops = general.getTroops();
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
            GeneralVo g = generalService.selectByName(name);
            if(g == null){
                general.setEnableFlag(true);
                general.setDelFlag(false);
                int i = generalService.insert(general);
            }else{
                general = g;
            }
            Long id = general.getId();

            GeneralAnalog analog = new GeneralAnalog();

            int a = generalAssociationService.deleteByGeneralId(id);
            int b = generalWeaponService.deleteByGeneralId(id);
            int c = generalArmsBookService.deleteByGeneralId(id);
            int d = generalSkinService.deleteByGeneralId(id);
            int e = generalThreeService.deleteByGeneralId(id);

            //联协
            general.setAssociationList(associationList);
            for (GeneralAssociation association : associationList) {
                association.setGeneralId(id);
                association.setGeneralName(name);
                generalAssociationService.insert(association);
            }

            //战器
            for (GeneralWeapon weapon : weaponList){
                weapon.setGeneralId(id);
                weapon.setGeneralName(name);
                generalWeaponService.insert(weapon);
            }
            general.setWeaponList(weaponList);

            //将魂、四圣石、兵符
            //主动技能active
//            List<GeneralSkillActive> skillActiveList = new ArrayList<>();
//            skillActiveList.add(new GeneralSkillActive(id,name,"落凤焚羽",3,""));
//            skillActiveList.add(new GeneralSkillActive(id,name,"逆·落凤焚羽",3,""));
//            general.setSkillActiveList(skillActiveList);
            //被动技能passive
//            List<GeneralSkillPassive> skillPassiveList = new ArrayList<>();
//            skillPassiveList.add(new GeneralSkillPassive());
//            general.setSkillPassiveList(skillPassiveList);
            //命格

            //兵书
            armsBook.setGeneralId(id);
            armsBook.setGeneralName(name);
            general.setArmsBook(armsBook);
            generalArmsBookService.insert(armsBook);
            //幻化
            if(StringUtils.isNotBlank(generalSkin.getName())){
                generalSkin.setGeneralId(id);
                generalSkin.setGeneralName(name);
                generalSkin.setForce(30);
                generalSkin.setIntellect(30);
                generalSkin.setTroops(80);
                general.setGeneralSkin(generalSkin);
                generalSkinService.insert(generalSkin);
            }

            //三维属性：武智兵
            List<GeneralThree> threeList = GeneralUtils.calculateThree(general,analog);
            generalThreeService.insertList(threeList);
            /*for(GeneralThree three : threeList){
                generalThreeService.insert(three);
            }*/
        }else{

        }
        //System.out.println(general);
        return ResultMsg.success();
    }

    /**
     * localhost:8088/ivy/ppsg/general/initGeneral
     * @return
     */
    @Log("ppsg.General")
    @RequestMapping("/initGeneral")
    public ResultMsg initGeneral(){
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

        List<GeneralVo> generalList = new ArrayList<>();
        GeneralVo general = null;
        for(Map<String, String> data : lists){
            if("false".equalsIgnoreCase(data.get("usable"))){
                continue;
            }
            general = new GeneralVo();
            general.setName(data.get("name"));
            general.setLevel(1);

            String parentName = data.get("generalsCode");
            long parentId = GeneralEnum.getDicByLabel("General4",parentName);
            general.setParentId(parentId);
            general.setParentName(parentName);

            String genderName = data.get("gender");
            int genderCode = GeneralEnum.getDicByLabel("Gender",genderName);
            general.setGenderCode(genderCode);
            general.setGenderName(genderName);

            general.setForce(Integer.valueOf(data.get("force")));
            general.setIntellect(Integer.valueOf(data.get("intellect")));
            general.setTroops(Integer.valueOf(data.get("troops")));

            general.setForcex(Integer.valueOf(data.get("force_x")));
            general.setIntellectx(Integer.valueOf(data.get("intellect_x")));
            general.setTroopsx(Integer.valueOf(data.get("troops_x")));

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

            String war1 = data.get("war1");
            String warName1 = data.get("warName1");
            String war2 = data.get("war2");
            String warName2 = data.get("warName2");
            int id1 = GeneralEnum.getDicByLabel("Weapon",war1);
            int id2 = GeneralEnum.getDicByLabel("Weapon",war2);
            List<GeneralWeapon> weaponList = new ArrayList<>();
            GeneralWeapon weapon1 = new GeneralWeapon();
            weapon1.setWeaponCode(id1);
            weapon1.setWeaponName(war1);
            weapon1.setName(warName1);
            GeneralWeapon weapon2 = new GeneralWeapon();
            weapon2.setWeaponCode(id2);
            weapon2.setWeaponName(war2);
            weapon2.setName(warName2);
            weaponList.add(weapon1);
            weaponList.add(weapon2);

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
            general.setGeneralSkin(skin);

            generalList.add(general);
        }
        return ResultMsg.success();
    }

    /**
     *
     */
    @Log("ppsg.General")
    @PostMapping("/updateAllThree")
    public ResultMsg updateAllThree(){
        try {
            //全部
            List<General> generalList = (List<General>) cache.get(CacheKeys.GENERALS_DETAIL_LIST, key -> getAllValue(key));
            GeneralAnalog analog = new GeneralAnalog();
            for (General general : generalList){
                int e = generalThreeService.deleteByGeneralId(general.getId());
                //三维属性：武智兵
                List<GeneralThree> threeList = GeneralUtils.calculateThree(general,analog);
                generalThreeService.insertList(threeList);
                /*for(GeneralThree three : threeList){
                    generalThreeService.insert(three);
                }*/
            }
            return ResultMsg.success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMsg.failed();
    }

    public Object getAllValue(String key){
        GeneralVo generalVo = new GeneralVo();
        generalVo.setDelFlag(false);
        return generalService.selectDetailList(generalVo);
    }

    @Log("ppsg.General")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(GeneralVo generalVo){
        Pagination<General> pagination = generalService.selectPage(generalVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.General")
    @GetMapping("/selectList")
    public ResultMsg selectList(GeneralVo generalVo){
        return ResultMsg.success(generalService.selectList(generalVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.General")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(GeneralVo generalVo){
        return ResultMsg.success(generalService.selectOne(generalVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.General")
    @PostMapping("/insert")
    public ResultMsg insert(@RequestBody General general){
        if(general == null){
            return ResultMsg.failed();
        }
        int i = generalService.insert(general);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.General")
    @PostMapping("/update")
    public ResultMsg update(@RequestBody General general){
        if(general == null || general.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalService.update(general);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.General")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@RequestBody @PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
