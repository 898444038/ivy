package com.ivy.admin.service.impl.ppsg;

import com.github.benmanes.caffeine.cache.Cache;
import com.ivy.admin.entity.ppsg.*;
import com.ivy.admin.enums.ppsg.GeneralEnum;
import com.ivy.admin.mapper.ppsg.GeneralArmsBookMapper;
import com.ivy.admin.mapper.ppsg.GeneralAssociationMapper;
import com.ivy.admin.mapper.ppsg.GeneralMapper;
import com.ivy.admin.mapper.ppsg.GeneralSkinMapper;
import com.ivy.admin.mapper.ppsg.GeneralThreeMapper;
import com.ivy.admin.mapper.ppsg.GeneralWeaponMapper;
import com.ivy.admin.service.ppsg.GeneralService;
import com.ivy.admin.service.ppsg.GeneralVirtualCombatService;
import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ppsg.GeneralCalculate;
import com.ivy.admin.vo.ppsg.GeneralArmsBookVo;
import com.ivy.admin.vo.ppsg.GeneralAssociationVo;
import com.ivy.admin.vo.ppsg.GeneralSkinVo;
import com.ivy.admin.vo.ppsg.GeneralThreeVo;
import com.ivy.admin.vo.ppsg.GeneralVo;
import com.ivy.admin.vo.ppsg.GeneralWeaponVo;
import com.ivy.system.config.CacheKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 武将
 * @author: Administrator
 * @date: 2020-12-30
 */
@Service
public class GeneralVirtualCombatServiceImpl implements GeneralVirtualCombatService {

    @Autowired
    private Cache<String, Object> cache;
    @Resource
    private GeneralService generalService;
    @Resource
    private GeneralArmsBookMapper generalArmsBookMapper;
    @Resource
    private GeneralAssociationMapper generalAssociationMapper;
    @Resource
    private GeneralSkinMapper generalSkinMapper;
    @Resource
    private GeneralThreeMapper generalThreeMapper;
    @Resource
    private GeneralWeaponMapper generalWeaponMapper;



    @Override
    public List<GeneralResult> calculate(GeneralAnalog analog) {
        //全部
        List<General> allList = (List<General>) cache.get(CacheKeys.GENERALS_DETAIL_LIST, key -> getAllValue(key));

        //上阵
        String[] ids = analog.getIds().split(",");
        List<General> generalList = new ArrayList<>();
        for (General general : allList){
            for (String id : ids){
                if(general.getId().toString().equals(id)){
                    generalList.add(general);
                }
            }
        }
        //计算结果
        List<GeneralResult> resultList = new ArrayList<>();

        GeneralResult result = calculateResult(generalList);
        if(result != null){
            resultList.add(result);
        }
        return resultList;
    }

    private GeneralResult calculateResult(List<General> generalList) {
        if(generalList == null || generalList.size() != 5){
            return null;
        }
        GeneralResult result = new GeneralResult();
        List<GeneralResultItem> itemList = new ArrayList<>();
        // 兵符、战意
        // 总战力 = 武将1战力 + 武将2战力 + 武将3战力 + 武将4战力 + 武将5战力 + 工坊战力（10152）
        // 武将战力 =（总武力+总智力+总兵力）*2+ 命格被动战力 + 战器被动战力 + 阵法被动
        for (General general : generalList){
            GeneralResultItem item = new GeneralResultItem();
            item.setGeneralName(general.getName());
            //满级三维
            GeneralThree three = GeneralCalculate.getBaseMaxThree(general);
            item.setF(three.getForce());
            item.setI(three.getIntellect());
            item.setT(three.getTroops());
            print(general,three);
            //科技三维
            GeneralThree three5 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_5);
            item.setF5(three5.getForce());
            item.setI5(three5.getIntellect());
            item.setT5(three5.getTroops());
            print(general,three5);
            //随从三维
            //四圣石三维
            GeneralThree three6 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_6);
            item.setF6(three6.getForce());
            item.setI6(three6.getIntellect());
            item.setT6(three6.getTroops());
            print(general,three6);
            //战器三维
            //兵种三维
            //将魂三维
            GeneralThree three15 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_15);
            item.setF15(three15.getForce());
            item.setI15(three15.getIntellect());
            item.setT15(three15.getTroops());
            print(general,three15);
            //兵符三维
            //战阵三维
            GeneralThree three17 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_17);
            item.setF17(three17.getForce());
            item.setI17(three17.getIntellect());
            item.setT17(three17.getTroops());
            print(general,three17);
            //战意三维
            //命格三维
            GeneralThree three18 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_18);
            item.setF18(three18.getForce());
            item.setI18(three18.getIntellect());
            item.setT18(three18.getTroops());
            print(general,three18);
            //幻化三维
            GeneralThree three19 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_19);
            item.setF19(three19.getForce());
            item.setI19(three19.getIntellect());
            item.setT19(three19.getTroops());
            print(general,three19);
            //阵法三维
            GeneralThree three20 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_20);
            item.setF20(three20.getForce());
            item.setI20(three20.getIntellect());
            item.setT20(three20.getTroops());
            print(general,three20);

            itemList.add(item);
            System.out.println("-----------------------");
        }

        result.setTotalCombat(null);
        result.setItemList(itemList);
        return result;
    }

    public static void print(General general,GeneralThree three){
        System.out.println(general.getName()+" "+three.getName()+" "+three.getForce()+" "+three.getIntellect()+" "+three.getTroops());
    }

    public Object getAllValue(String key){
        GeneralVo generalVo = new GeneralVo();
        generalVo.setDelFlag(false);
        return generalService.selectDetailList(generalVo);
    }
}
