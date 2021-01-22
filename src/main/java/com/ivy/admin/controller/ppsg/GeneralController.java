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
import com.ivy.admin.utils.ppsg.GeneralUtils;
import com.ivy.admin.vo.ppsg.GeneralVo;
import com.ivy.admin.entity.ppsg.General;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import com.ivy.system.config.CacheKeys;
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
            generalSkin.setGeneralId(id);
            generalSkin.setGeneralName(name);
            generalSkin.setForce(30);
            generalSkin.setIntellect(30);
            generalSkin.setTroops(80);
            general.setGeneralSkin(generalSkin);
            generalSkinService.insert(generalSkin);
            //三维属性：武智兵
            List<GeneralThree> threeList = GeneralUtils.calculateThree(general,analog);
            for(GeneralThree three : threeList){
                generalThreeService.insert(three);
            }
        }else{

        }
        //System.out.println(general);
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
                for(GeneralThree three : threeList){
                    generalThreeService.insert(three);
                }
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
