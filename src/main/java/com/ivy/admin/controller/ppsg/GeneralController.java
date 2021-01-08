package com.ivy.admin.controller.ppsg;

import com.ivy.admin.entity.ppsg.GeneralAnalog;
import com.ivy.admin.entity.ppsg.GeneralArmsBook;
import com.ivy.admin.entity.ppsg.GeneralAssociation;
import com.ivy.admin.entity.ppsg.GeneralSkillActive;
import com.ivy.admin.entity.ppsg.GeneralSkillPassive;
import com.ivy.admin.entity.ppsg.GeneralSkin;
import com.ivy.admin.entity.ppsg.GeneralWeapon;
import com.ivy.admin.enums.ppsg.GeneralEnum;
import com.ivy.admin.service.ppsg.GeneralService;
import com.ivy.admin.utils.ppsg.GeneralUtils;
import com.ivy.admin.vo.ppsg.GeneralVo;
import com.ivy.admin.entity.ppsg.General;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ivy.admin.aspect.log.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 武将
 * @author: Administrator
 * @date: 2020-12-30
 */
@RestController
@RequestMapping("/ppsg/general")
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    /**
     * 新增&保存
     */
    @Log("ppsg.General")
    @GetMapping("/save")
    public ResultMsg save(GeneralVo generalVo){
        GeneralAnalog analog = new GeneralAnalog();

        GeneralEnum.Gender gender = GeneralEnum.Gender.man;
        GeneralEnum.Country country = GeneralEnum.Country.shu;
        GeneralEnum.Star star = GeneralEnum.Star.star5;
        GeneralEnum.Arms arms = GeneralEnum.Arms.qi;
        GeneralEnum.GeneralsType type = GeneralEnum.GeneralsType.type8;
        GeneralEnum.Category category = GeneralEnum.Category.ni_ming;
        //GeneralEnum.DestinyType2 destinyType = GeneralEnum.DestinyType2.ni_ming_1;
        GeneralEnum.DestinyType destinyType = GeneralEnum.DestinyType.ni_ming_3;
        GeneralEnum.Weapon weapon1 = GeneralEnum.Weapon.gong;
        GeneralEnum.Weapon weapon2 = GeneralEnum.Weapon.shan;
//        GeneralEnum.ThreeCirclesType type_1 = GeneralEnum.ThreeCirclesType.type_1;
//        GeneralEnum.ThreeCirclesType type_2 = GeneralEnum.ThreeCirclesType.type_2;
//        GeneralEnum.EntourageType entourageType = GeneralEnum.EntourageType.none;

        GeneralEnum.General4 general4 = GeneralEnum.General4.shu_pangtong;
        GeneralEnum.General4 general_zhugeliang = GeneralEnum.General4.shu_zhugeliang;
        GeneralEnum.General4 general_liubei = GeneralEnum.General4.shu_liubei;
        GeneralEnum.General4 general_lusu = GeneralEnum.General4.wu_lusu;
        GeneralEnum.General4 general_huangyueying = GeneralEnum.General4.shu_huangyueying;
        GeneralEnum.General4 general_zhangfei = GeneralEnum.General4.shu_zhangfei;
        GeneralEnum.General4 general_fazheng = GeneralEnum.General4.shu_fazheng;
        Long id = 50001L;
        String name = "陨星庞统";
        Integer force = 460;
        Integer intellect = 712;
        Integer troops = 616;
        Integer forcex = 0;
        Integer intellectx = 0;
        Integer troopsx = 0;

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

        if (forcex != null && forcex != 0 && intellectx != null && intellectx != 0 && troopsx != null && troopsx != 0){
            general.setCardCode(GeneralEnum.CardType.yi_hua.value());
            general.setCardName(GeneralEnum.CardType.yi_hua.label());
        }else{
            general.setCardCode(GeneralEnum.CardType.pu_tong.value());
            general.setCardName(GeneralEnum.CardType.pu_tong.label());
        }

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
        weaponList.add(new GeneralWeapon("惊凰弓",weapon1.value(),weapon1.label(),id,name));
        weaponList.add(new GeneralWeapon("惊凰扇",weapon2.value(),weapon2.label(),id,name));
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
        GeneralUtils.calculateThree(general,analog,force,intellect,troops,forcex,intellectx,troopsx);

        general.setDelFlag(false);
        general.setEnableFlag(true);
        System.out.println(general);


        return ResultMsg.failed();
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
