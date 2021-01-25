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
            int force = 0;
            int intellect = 0;
            int troops = 0;
            int combat = 0;

            //满级三维
            GeneralThree three = GeneralCalculate.getBaseMaxThree(general);
            int f = three.getForce();
            int i = three.getIntellect();
            int t = three.getTroops();
            int c = (f+i+t)*2;
            item.setF(f);
            item.setI(i);
            item.setT(t);
            item.setC(c);
            force += f;
            intellect += i;
            troops += t;
            combat += c;
            print(general,three);

            //科技三维
            GeneralThree three5 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_5);
            int f5 = three5.getForce();
            int i5 = three5.getIntellect();
            int t5 = three5.getTroops();
            int c5 = (f5+i5+t5)*2;
            item.setF5(f5);
            item.setI5(i5);
            item.setT5(t5);
            item.setC5(c5);
            force += f5;
            intellect += i5;
            troops += t5;
            combat += c5;
            print(general,three5);

            //随从三维

            //四圣石三维
            GeneralThree three6 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_6);
            int f6 = three6.getForce();
            int i6 = three6.getIntellect();
            int t6 = three6.getTroops();
            int c6 = (f6+i6+t6)*2;
            item.setF6(f6);
            item.setI6(i6);
            item.setT6(t6);
            item.setC6(c6);
            force += f6;
            intellect += i6;
            troops += t6;
            combat += c6;
            print(general,three6);

            //战器三维
            GeneralThree three7 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_7);
            GeneralThree three8 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_8);
            if(three8.getCombat() > three7.getCombat()){
                int f8 = three8.getForce();
                int i8 = three8.getIntellect();
                int t8 = three8.getTroops();
                int c8 = (f8+i8+t8)*2;
                item.setF7(f8);
                item.setI7(i8);
                item.setT7(t8);
                item.setC7(c8);
                force += f8;
                intellect += i8;
                troops += t8;
                combat += c8;
                print(general,three8);
            }else{
                int f7 = three7.getForce();
                int i7 = three7.getIntellect();
                int t7 = three7.getTroops();
                int c7 = (f7+i7+t7)*2;
                item.setF7(f7);
                item.setI7(i7);
                item.setT7(t7);
                item.setC7(c7);
                force += f7;
                intellect += i7;
                troops += t7;
                combat += c7;
                print(general,three7);
            }

            //兵书三维
            GeneralThree three11 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_11);
            int f9 = three11.getForce();
            int i9 = three11.getIntellect();
            int t9 = three11.getTroops();
            //兵种三维
            GeneralThree three9 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_9);
            GeneralThree three10 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_10);
            if(three9.getCombat() >= three10.getCombat()){
                f9 += three9.getForce();
                i9 += three9.getIntellect();
                t9 += three9.getTroops();
            }else{
                f9 += three10.getForce();
                i9 += three10.getIntellect();
                t9 += three10.getTroops();
            }
            int c9 = (f9+i9+t9)*2;
            force += f9;
            intellect += i9;
            troops += t9;
            combat += c9;
            item.setF9(f9);
            item.setI9(i9);
            item.setT9(t9);
            item.setC9(c9);

            //将魂三维
            GeneralThree three15 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_15);
            int f15 = three15.getForce();
            int i15 = three15.getIntellect();
            int t15 = three15.getTroops();
            int c15 = (f15+i15+t15)*2;
            item.setF15(f15);
            item.setI15(i15);
            item.setT15(t15);
            item.setC15(c15);
            force += f15;
            intellect += i15;
            troops += t15;
            combat += c15;
            print(general,three15);

            //兵符三维

            //战阵三维
            GeneralThree three17 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_17);
            int f17 = three17.getForce();
            int i17 = three17.getIntellect();
            int t17 = three17.getTroops();
            int c17 = (f17+i17+t17)*2;
            item.setF17(f17);
            item.setI17(i17);
            item.setT17(t17);
            item.setC17(c17);
            force += f17;
            intellect += i17;
            troops += t17;
            combat += c17;
            print(general,three17);

            //战意三维

            //命格三维
            GeneralThree three18 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_18);
            int f18 = three18.getForce();
            int i18 = three18.getIntellect();
            int t18 = three18.getTroops();
            int c18 = (f18+i18+t18)*2;
            item.setF18(f18);
            item.setI18(i18);
            item.setT18(t18);
            item.setC18(c18);
            force += f18;
            intellect += i18;
            troops += t18;
            combat += c18;
            print(general,three18);

            //幻化三维
            GeneralThree three19 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_19);
            int f19 = three19.getForce();
            int i19 = three19.getIntellect();
            int t19 = three19.getTroops();
            int c19 = (f19+i19+t19)*2;
            item.setF19(f19);
            item.setI19(i19);
            item.setT19(t19);
            item.setC19(c19);
            force += f19;
            intellect += i19;
            troops += t19;
            combat += c19;
            print(general,three19);

            //阵法三维
            GeneralThree three20 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_20);
            int f20 = three20.getForce();
            int i20 = three20.getIntellect();
            int t20 = three20.getTroops();
            int c20 = (f20+i20+t20)*2;
            item.setF20(f20);
            item.setI20(i20);
            item.setT20(t20);
            item.setC20(c20);
            force += f20;
            intellect += i20;
            troops += t20;
            combat += c20;
            print(general,three20);

            //总计
            item.setForce(force);
            item.setIntellect(intellect);
            item.setTroops(troops);
            item.setCombat(combat);
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
