package com.ivy.admin.service.impl.ppsg;

import com.github.benmanes.caffeine.cache.Cache;
import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.entity.ppsg.GeneralAnalog;
import com.ivy.admin.entity.ppsg.GeneralArmsBook;
import com.ivy.admin.entity.ppsg.GeneralAssociation;
import com.ivy.admin.entity.ppsg.GeneralResult;
import com.ivy.admin.entity.ppsg.GeneralSkin;
import com.ivy.admin.entity.ppsg.GeneralThree;
import com.ivy.admin.entity.ppsg.GeneralWeapon;
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
        //兵符、战意
        // 总战力 = 武将1战力 + 武将2战力 + 武将3战力 + 武将4战力 + 武将5战力 + 工坊战力（10152）
        // 武将战力 =（总武力+总智力+总兵力）*2+ 命格被动战力 + 战器被动战力 + 阵法被动
        for (General general : generalList){
            GeneralThree three = GeneralCalculate.getBaseMaxThree(general);//满级三维
            System.out.println(general.getName()+" "+three.getName()+" "+three.getForce()+" "+three.getIntellect()+" "+three.getTroops());
            System.out.println("------------------------------");
        }
        return result;
    }

    public Object getAllValue(String key){
        GeneralVo generalVo = new GeneralVo();
        generalVo.setDelFlag(false);
        return generalService.selectDetailList(generalVo);
    }
}
