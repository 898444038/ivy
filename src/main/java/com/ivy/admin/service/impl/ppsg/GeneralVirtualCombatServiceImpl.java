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
import com.ivy.admin.utils.ppsg.MapUtils;
import com.ivy.admin.vo.ppsg.GeneralArmsBookVo;
import com.ivy.admin.vo.ppsg.GeneralAssociationVo;
import com.ivy.admin.vo.ppsg.GeneralSkinVo;
import com.ivy.admin.vo.ppsg.GeneralThreeVo;
import com.ivy.admin.vo.ppsg.GeneralVo;
import com.ivy.admin.vo.ppsg.GeneralWeaponVo;
import com.ivy.system.config.CacheKeys;
import jdk.internal.org.objectweb.asm.Handle;
import org.checkerframework.checker.units.qual.K;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
        //计算三维
        GeneralResult result = calculateResult(generalList,allList);
        //计算战意
        calculateWarpath(result,generalList);
        //计算兵符
        calculateSymbolsType(result);
        calculateSymbolsMain(result);
        calculateSymbolsSecond(result);

        addWarpathSymbols(result);

        //吕布战器、吕姬有问题
        if(result != null){
            resultList.add(result);
        }
        return resultList;
    }

    private void addWarpathSymbols(GeneralResult result) {
        List<GeneralResultItem> itemList = result.getItemList();
        for (GeneralResultItem item : itemList){
            int f = ((Double)(item.getF29() + item.getF30() + item.getF31())).intValue();
            int i = ((Double)(item.getI29() + item.getI30() + item.getI31())).intValue();
            int t = ((Double)(item.getT29() + item.getT30() + item.getT31())).intValue();
            item.setF28(f);
            item.setI28(i);
            item.setT28(t);
            item.setC28((f+i+t)*2);

            item.setForce(item.getForce() + item.getF21() + f);
            item.setIntellect(item.getIntellect() + item.getI21() + i);
            item.setTroops(item.getTroops() + item.getT21() + t);
            item.setCombat((item.getForce()+item.getIntellect()+item.getTroops())*2);
        }
    }

    private void calculateSymbolsSecond(GeneralResult result) {
        List<GeneralResultItem> itemList = result.getItemList();
        List<Map<String,Object>> mapList = new ArrayList<>();
        for (GeneralEnum.SymbolsSecondAttr second : GeneralEnum.SymbolsSecondAttr.values()){
            Map<String,Object> map = new HashMap<>();
            int value = second.value();
            int val = second.getVal();
            double rate = second.getRate();
            double f = 0; double i = 0; double t = 0;
            if(value == 1){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    f0 += val * 6;
                    f += f0;
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
            }else if(value == 3){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    i0 += val * 6;
                    i += i0;
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
            }else if(value == 5){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    t0 += val * 6;
                    t += t0;
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
            }else if(value == 7){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    if(GeneralEnum.Country.wu.label().equals(item.getCountryName())){
                        f0 += val * 6; i0 += val * 6; t0 += val * 6;
                        f += f0; i += i0; t += t0;
                    }
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
            }else if(value == 9){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    if(GeneralEnum.Country.shu.label().equals(item.getCountryName())){
                        f0 += val * 6; i0 += val * 6; t0 += val * 6;
                        f += f0; i += i0; t += t0;
                    }
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
            }else if(value == 11){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    if(GeneralEnum.Country.wei.label().equals(item.getCountryName())){
                        f0 += val * 6; i0 += val * 6; t0 += val * 6;
                        f += f0; i += i0; t += t0;
                    }
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
            }else if(value == 13){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    if(GeneralEnum.Country.qun.label().equals(item.getCountryName())){
                        f0 += val * 6; i0 += val * 6; t0 += val * 6;
                        f += f0; i += i0; t += t0;
                    }
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
            }

            if(value == 2){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    f0 += item.getF() * rate * 6;
                    f += f0;
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
            }else if(value == 4){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    i0 += item.getI() * rate * 6;
                    i += i0;
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
            }else if(value == 6){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    t0 += item.getT() * rate * 6;
                    t += t0;
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
            }else if(value == 8){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    if(GeneralEnum.Country.wu.label().equals(item.getCountryName())){
                        f0 += item.getF() * rate * 6;
                        i0 += item.getI() * rate * 6;
                        t0 += item.getT() * rate * 6;
                        f += f0; i += i0; t += t0;
                    }
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
            }else if(value == 10){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    if(GeneralEnum.Country.shu.label().equals(item.getCountryName())){
                        f0 += item.getF() * rate * 6;
                        i0 += item.getI() * rate * 6;
                        t0 += item.getT() * rate * 6;
                        f += f0; i += i0; t += t0;
                    }
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
            }else if(value == 12){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    if(GeneralEnum.Country.wei.label().equals(item.getCountryName())){
                        f0 += item.getF() * rate * 6;
                        i0 += item.getI() * rate * 6;
                        t0 += item.getT() * rate * 6;
                        f += f0; i += i0; t += t0;
                    }
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
            }else if(value == 14){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    if(GeneralEnum.Country.qun.label().equals(item.getCountryName())){
                        f0 += item.getF() * rate * 6;
                        i0 += item.getI() * rate * 6;
                        t0 += item.getT() * rate * 6;
                        f += f0; i += i0; t += t0;
                    }
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
            }
            map.put("second",second);
            map.put("f",f);
            map.put("i",i);
            map.put("t",t);
            map.put("value",f+i+t);
            mapList.add(map);
        }
        Collections.sort(mapList, new MapComparatorDoubleDesc());
        for (GeneralResultItem item : itemList){
            String name = item.getGeneralName();
            double f = 0;
            double i = 0;
            double t = 0;
            Map<String,Object> map1 = mapList.get(0);
            f += (double) map1.get(name+"_f");
            i += (double) map1.get(name+"_i");
            t += (double) map1.get(name+"_t");
            Map<String,Object> map2 = mapList.get(1);
            f += (double) map2.get(name+"_f");
            i += (double) map2.get(name+"_i");
            t += (double) map2.get(name+"_t");
            Map<String,Object> map3 = mapList.get(2);
            f += (double) map3.get(name+"_f");
            i += (double) map3.get(name+"_i");
            t += (double) map3.get(name+"_t");
            Map<String,Object> map4 = mapList.get(3);
            f += (double) map4.get(name+"_f");
            i += (double) map4.get(name+"_i");
            t += (double) map4.get(name+"_t");
            item.setF31(f);
            item.setI31(i);
            item.setT31(t);
            item.setC31((f+i+t)*2);
        }
    }

    private void calculateSymbolsMain(GeneralResult result) {
        List<GeneralResultItem> itemList = result.getItemList();
        int f1 = 0; int i1 = 0; int t1 = 0;
        int f3 = 0; int i3 = 0; int t3 = 0;
        int f5 = 0; int i5 = 0; int t5 = 0;
        List<Map<String,Object>> mapList2 = new ArrayList<>();
        List<Map<String,Object>> mapList4 = new ArrayList<>();
        List<Map<String,Object>> mapList6 = new ArrayList<>();
        for (GeneralEnum.SymbolsMainAttr main : GeneralEnum.SymbolsMainAttr.values()){
            int val = main.value();
            double rate = main.getRate();
            Map<String,Object> map = new HashMap<>();
            double f = 0; double i = 0; double t = 0;
            if(val == 1){
                f1 = GeneralEnum.SymbolsMainAttr.force.getVal();
            }else if(val == 2){
                i3 = GeneralEnum.SymbolsMainAttr.intellect.getVal();
            }else if(val == 3){
                t5 = GeneralEnum.SymbolsMainAttr.troops.getVal();
            }else if(val == 4 || val == 7 || val == 10 || val == 13){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    if(val == 4 || val == 13){ f0 += item.getF() * rate; f += f0; }
                    if(val == 7 || val == 13){ i0 += item.getI() * rate; i += i0; }
                    if(val == 10|| val == 13){ t0 += item.getT() * rate; t += t0; }
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
                map.put("main",main);
                map.put("f",f);
                map.put("i",i);
                map.put("t",t);
                map.put("value",f+i+t);
                mapList2.add(map);
            }else if(val == 5 || val == 8 || val == 11 || val == 14){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    if(val == 5 || val == 14){ f0 += item.getF() * rate; f += f0; }
                    if(val == 8 || val == 14){ i0 += item.getI() * rate; i += i0; }
                    if(val == 11|| val == 14){ t0 += item.getT() * rate; t += t0; }
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
                map.put("main",main);
                map.put("f",f);
                map.put("i",i);
                map.put("t",t);
                map.put("value",f+i+t);
                mapList4.add(map);
            }else if(val == 6 || val == 9 || val == 12 || val == 15){
                for (GeneralResultItem item : itemList){
                    double f0 = 0; double i0 = 0; double t0 = 0;
                    if(val == 6 || val == 15){ f0 += item.getF() * rate;f += f0; }
                    if(val == 9 || val == 15){ i0 += item.getI() * rate;i += i0; }
                    if(val == 12|| val == 15){ t0 += item.getT() * rate;t += t0; }
                    map.put(item.getGeneralName()+"_f",f0);
                    map.put(item.getGeneralName()+"_i",i0);
                    map.put(item.getGeneralName()+"_t",t0);
                }
                map.put("main",main);
                map.put("f",f);
                map.put("i",i);
                map.put("t",t);
                map.put("value",f+i+t);
                mapList6.add(map);
            }

        }
        Collections.sort(mapList2, new MapComparatorDoubleDesc());
        Collections.sort(mapList4, new MapComparatorDoubleDesc());
        Collections.sort(mapList6, new MapComparatorDoubleDesc());
        for (GeneralResultItem item : itemList){
            double f = 0;
            double i = 0;
            double t = 0;
            f += f1; i += i1; t += t1;
            f += f3; i += i3; t += t3;
            f += f5; i += i5; t += t5;
            Map<String,Object> map2 = mapList2.get(0);
            f += (double) map2.get(item.getGeneralName()+"_f");
            i += (double) map2.get(item.getGeneralName()+"_i");
            t += (double) map2.get(item.getGeneralName()+"_t");
            Map<String,Object> map4 = mapList4.get(0);
            f += (double) map4.get(item.getGeneralName()+"_f");
            i += (double) map4.get(item.getGeneralName()+"_i");
            t += (double) map4.get(item.getGeneralName()+"_t");
            Map<String,Object> map6 = mapList6.get(0);
            f += (double) map6.get(item.getGeneralName()+"_f");
            i += (double) map6.get(item.getGeneralName()+"_i");
            t += (double) map6.get(item.getGeneralName()+"_t");
            item.setF30(f);
            item.setI30(i);
            item.setT30(t);
            item.setC30((f+i+t)*2);
        }
    }

    /**
     * 计算兵符类型
     * @param result
     */
    private void calculateSymbolsType(GeneralResult result) {
        List<GeneralResultItem> itemList = result.getItemList();
        List<Map<String,Object>> dataList = new ArrayList<>();
        //Map<GeneralEnum.SymbolsType,Integer> map = new HashMap<>();

        GeneralEnum.SymbolsType cang_long = GeneralEnum.SymbolsType.cang_long;
        GeneralEnum.SymbolsType meng_hu = GeneralEnum.SymbolsType.meng_hu;
        GeneralEnum.SymbolsType huo_feng = GeneralEnum.SymbolsType.huo_feng;
        GeneralEnum.SymbolsType tian_lang = GeneralEnum.SymbolsType.tian_lang;
        GeneralEnum.SymbolsType xuan_gui = GeneralEnum.SymbolsType.xuan_gui;
        GeneralEnum.SymbolsType xiang_ying = GeneralEnum.SymbolsType.xiang_ying;
        GeneralEnum.SymbolsType qi_lin = GeneralEnum.SymbolsType.qi_lin;
        GeneralEnum.SymbolsType qing_luan = GeneralEnum.SymbolsType.qing_luan;
        GeneralEnum.SymbolsType bai_ze = GeneralEnum.SymbolsType.bai_ze;
        GeneralEnum.SymbolsType hun_dun = GeneralEnum.SymbolsType.hun_dun;
        GeneralEnum.SymbolsType qiong_qi = GeneralEnum.SymbolsType.qiong_qi;
        GeneralEnum.SymbolsType ya_zi = GeneralEnum.SymbolsType.ya_zi;
        GeneralEnum.SymbolsType pí_xiū = GeneralEnum.SymbolsType.pí_xiū;
        GeneralEnum.SymbolsType zhēng = GeneralEnum.SymbolsType.zhēng;
        GeneralEnum.SymbolsType gǔ_diāo = GeneralEnum.SymbolsType.gǔ_diāo;
        GeneralEnum.Country shu = GeneralEnum.Country.shu;
        GeneralEnum.Country wu = GeneralEnum.Country.wu;
        GeneralEnum.Country wei = GeneralEnum.Country.wei;
        GeneralEnum.Country qun = GeneralEnum.Country.qun;
        GeneralEnum.Arms qiang = GeneralEnum.Arms.qiang;
        GeneralEnum.Arms qi = GeneralEnum.Arms.qi;
        GeneralEnum.Arms gong = GeneralEnum.Arms.gong;
        GeneralEnum.Gender woman = GeneralEnum.Gender.woman;

        for (GeneralEnum.SymbolsType symbolsType : GeneralEnum.SymbolsType.values()){
            double rate = symbolsType.getRate();
            int code = symbolsType.value();
            Map<String,Object> map = new HashMap<>();
            double f = 0; double i = 0; double t = 0;
            if(code == cang_long.value()){
                for (GeneralResultItem item : itemList){
                    double f1 = 0; double i1 = 0; double t1 = 0;
                    if(shu.label().equals(item.getCountryName())){
                        f1 = item.getF() * rate;
                        i1 = item.getI() * rate;
                        t1 = item.getT() * rate;
                        f += f1; i += i1; t += t1;
                    }
                    map.put(item.getGeneralName()+"_f",f1);
                    map.put(item.getGeneralName()+"_i",i1);
                    map.put(item.getGeneralName()+"_t",t1);
                }
            }else if(code == meng_hu.value()){
                for (GeneralResultItem item : itemList){
                    double f1 = 0; double i1 = 0; double t1 = 0;
                    if(wu.label().equals(item.getCountryName())){
                        f1 = item.getF() * rate;
                        i1 = item.getI() * rate;
                        t1 = item.getT() * rate;
                        f += f1; i += i1; t += t1;
                    }
                    map.put(item.getGeneralName()+"_f",f1);
                    map.put(item.getGeneralName()+"_i",i1);
                    map.put(item.getGeneralName()+"_t",t1);
                }
            }else if(code == huo_feng.value()){
                for (GeneralResultItem item : itemList){
                    double f1 = 0; double i1 = 0; double t1 = 0;
                    if(wei.label().equals(item.getCountryName())){
                        f1 = item.getF() * rate;
                        i1 = item.getI() * rate;
                        t1 = item.getT() * rate;
                        f += f1; i += i1; t += t1;
                    }
                    map.put(item.getGeneralName()+"_f",f1);
                    map.put(item.getGeneralName()+"_i",i1);
                    map.put(item.getGeneralName()+"_t",t1);
                }
            }else if(code == tian_lang.value()){
                for (GeneralResultItem item : itemList){
                    double f1 = 0; double i1 = 0; double t1 = 0;
                    if(qun.label().equals(item.getCountryName())){
                        f1 = item.getF() * rate;
                        i1 = item.getI() * rate;
                        t1 = item.getT() * rate;
                        f += f1; i += i1; t += t1;
                    }
                    map.put(item.getGeneralName()+"_f",f1);
                    map.put(item.getGeneralName()+"_i",i1);
                    map.put(item.getGeneralName()+"_t",t1);
                }
            }else if(code == xuan_gui.value()){
                for (GeneralResultItem item : itemList){
                    double f1 = 0; double i1 = 0; double t1 = 0;
                    if(qiang.label().equals(item.getArmsName())){
                        f1 = item.getF() * rate;
                        i1 = item.getI() * rate;
                        t1 = item.getT() * rate;
                        f += f1; i += i1; t += t1;
                    }
                    map.put(item.getGeneralName()+"_f",f1);
                    map.put(item.getGeneralName()+"_i",i1);
                    map.put(item.getGeneralName()+"_t",t1);
                }
            }else if(code == xiang_ying.value()){
                for (GeneralResultItem item : itemList){
                    double f1 = 0; double i1 = 0; double t1 = 0;
                    if(gong.label().equals(item.getArmsName())){
                        f1 = item.getF() * rate;
                        i1 = item.getI() * rate;
                        t1 = item.getT() * rate;
                        f += f1; i += i1; t += t1;
                    }
                    map.put(item.getGeneralName()+"_f",f1);
                    map.put(item.getGeneralName()+"_i",i1);
                    map.put(item.getGeneralName()+"_t",t1);
                }
            }else if(code == qi_lin.value()){
                for (GeneralResultItem item : itemList){
                    double f1 = 0; double i1 = 0; double t1 = 0;
                    if(qi.label().equals(item.getArmsName())){
                        f1 = item.getF() * rate;
                        i1 = item.getI() * rate;
                        t1 = item.getT() * rate;
                        f += f1; i += i1; t += t1;
                    }
                    map.put(item.getGeneralName()+"_f",f1);
                    map.put(item.getGeneralName()+"_i",i1);
                    map.put(item.getGeneralName()+"_t",t1);
                }
            }else if(code == qing_luan.value()){
                for (GeneralResultItem item : itemList){
                    double f1 = 0; double i1 = 0; double t1 = 0;
                    if(woman.label().equals(item.getGenderName())){
                        f1 = item.getF() * rate;
                        i1 = item.getI() * rate;
                        t1 = item.getT() * rate;
                        f += f1; i += i1; t += t1;
                    }
                    map.put(item.getGeneralName()+"_f",f1);
                    map.put(item.getGeneralName()+"_i",i1);
                    map.put(item.getGeneralName()+"_t",t1);
                }
            }else if(code == bai_ze.value()){
                for (GeneralResultItem item : itemList){
                    double f1 = 0; double i1 = 0; double t1 = 0;
                    i1 = item.getI() * rate;
                    i += i1;
                    map.put(item.getGeneralName()+"_f",f1);
                    map.put(item.getGeneralName()+"_i",i1);
                    map.put(item.getGeneralName()+"_t",t1);
                }
            }else if(code == hun_dun.value()){
                for (GeneralResultItem item : itemList){
                    double f1 = 0; double i1 = 0; double t1 = 0;
                    f1 = item.getF() * rate;
                    i1 = item.getI() * rate;
                    t1 = item.getT() * rate;
                    f += f1; i += i1; t += t1;
                    map.put(item.getGeneralName()+"_f",f1);
                    map.put(item.getGeneralName()+"_i",i1);
                    map.put(item.getGeneralName()+"_t",t1);
                }
            }else if(code == qiong_qi.value()){
                for (GeneralResultItem item : itemList){
                    double f1 = 0; double i1 = 0; double t1 = 0;
                    f1 = item.getF() * rate;
                    f += f1;
                    map.put(item.getGeneralName()+"_f",f1);
                    map.put(item.getGeneralName()+"_i",i1);
                    map.put(item.getGeneralName()+"_t",t1);
                }
            }else if(code == ya_zi.value()){
                for (GeneralResultItem item : itemList){
                    double f1 = 0; double i1 = 0; double t1 = 0;
                    t1 = item.getT() * rate;
                    t += t1;
                    map.put(item.getGeneralName()+"_f",f1);
                    map.put(item.getGeneralName()+"_i",i1);
                    map.put(item.getGeneralName()+"_t",t1);
                }
            }else if(code == pí_xiū.value()){
                for (GeneralResultItem item : itemList){
                    double f1 = 0; double i1 = 0; double t1 = 0;
                    if(qi.label().equals(item.getArmsName())){
                        f1 = item.getF() * rate;
                        i1 = item.getI() * rate;
                        t1 = item.getT() * rate;
                        f += f1; i += i1; t += t1;
                    }
                    map.put(item.getGeneralName()+"_f",f1);
                    map.put(item.getGeneralName()+"_i",i1);
                    map.put(item.getGeneralName()+"_t",t1);
                }
            }else if(code == zhēng.value()){
                for (GeneralResultItem item : itemList){
                    double f1 = 0; double i1 = 0; double t1 = 0;
                    if(qiang.label().equals(item.getArmsName())){
                        f1 = item.getF() * rate;
                        i1 = item.getI() * rate;
                        t1 = item.getT() * rate;
                        f += f1; i += i1; t += t1;
                    }
                    map.put(item.getGeneralName()+"_f",f1);
                    map.put(item.getGeneralName()+"_i",i1);
                    map.put(item.getGeneralName()+"_t",t1);
                }
            }else if(code == gǔ_diāo.value()){
                for (GeneralResultItem item : itemList){
                    double f1 = 0; double i1 = 0; double t1 = 0;
                    if(gong.label().equals(item.getArmsName())){
                        f1 = item.getF() * rate;
                        i1 = item.getI() * rate;
                        t1 = item.getT() * rate;
                        f += f1; i += i1; t += t1;
                    }
                    map.put(item.getGeneralName()+"_f",f1);
                    map.put(item.getGeneralName()+"_i",i1);
                    map.put(item.getGeneralName()+"_t",t1);
                }
            }
            map.put("type",symbolsType);
            map.put("f",f);
            map.put("i",i);
            map.put("t",t);
            map.put("value",f+i+t);
            dataList.add(map);
        }
        Collections.sort(dataList, new MapComparatorDoubleDesc());
        List<Map<String,Object>> subList = dataList.subList(0,3);

        for (GeneralResultItem resultItem : itemList){
            double f = 0;
            double i = 0;
            double t = 0;
            for (Map<String,Object> item : subList){
                f += (double)item.get(resultItem.getGeneralName()+"_f");
                i += (double)item.get(resultItem.getGeneralName()+"_i");
                t += (double)item.get(resultItem.getGeneralName()+"_t");
            }
            resultItem.setF29(f);
            resultItem.setI29(i);
            resultItem.setT29(t);
            resultItem.setC29((f+i+t)*2);
        }
        dataList = null;
    }

    /**
     * 计算战意
     * @param result
     * @param generalList
     */
    private void calculateWarpath(GeneralResult result, List<General> generalList) {
        Map<General,Integer> map = new HashMap<>();
        for (General general : generalList){
            GeneralThree three21 = GeneralCalculate.getThree(general, GeneralEnum.ThreeCirclesType.type_17);
            int f_c = three21.getForce();
            int i_c = three21.getIntellect();
            int t_c = three21.getTroops();
            int f_a = three21.getForce();
            int i_a = three21.getIntellect();
            int t_a = three21.getTroops();
            for (General general2 : generalList){
                if(general.getId().equals(general2.getId())){
                    continue;
                }
                GeneralThree three21_2 = GeneralCalculate.getThree(general2, GeneralEnum.ThreeCirclesType.type_17);
                if(general.getCountryCode().equals(general2.getCountryCode())){
                    f_c += three21_2.getForce();
                    i_c += three21_2.getIntellect();
                    t_c += three21_2.getTroops();
                }
                if(general.getArmsCode().equals(general2.getArmsCode())){
                    f_a += three21_2.getForce();
                    i_a += three21_2.getIntellect();
                    t_a += three21_2.getTroops();
                }
            }
            Map<String,Integer> data = new HashMap<>();
            data.put("f_c",f_c);
            data.put("i_c",i_c);
            data.put("t_c",t_c);
            data.put("f_a",f_a);
            data.put("i_a",i_a);
            data.put("t_a",t_a);
            data = MapUtils.sortByValueDesc(data);
            Map.Entry<String, Integer> tail = data.entrySet().iterator().next();
            if(tail.getKey().equals("f_c")){
                map.put(general,GeneralEnum.Warpath.country_force.value());
            }else if(tail.getKey().equals("i_c")){
                map.put(general,GeneralEnum.Warpath.country_intellect.value());
            }else if(tail.getKey().equals("t_c")){
                map.put(general,GeneralEnum.Warpath.country_troops.value());
            }else if(tail.getKey().equals("f_a")){
                map.put(general,GeneralEnum.Warpath.arms_force.value());
            }else if(tail.getKey().equals("i_a")){
                map.put(general,GeneralEnum.Warpath.arms_intellect.value());
            }else if(tail.getKey().equals("t_a")){
                map.put(general,GeneralEnum.Warpath.arms_troops.value());
            }
        }
        List<GeneralResultItem> itemList = result.getItemList();
        for (GeneralResultItem item : itemList){
            Double f = 0d;
            Double i = 0d;
            Double t = 0d;
            double rate = 0.1;
            for (Map.Entry<General,Integer> entry : map.entrySet()){
                if(entry.getValue().equals(GeneralEnum.Warpath.country_force.value()) && item.getCountryName().equals(entry.getKey().getCountryName())){
                    f += item.getF() * rate;
                }else if(entry.getValue().equals(GeneralEnum.Warpath.country_intellect.value()) && item.getCountryName().equals(entry.getKey().getCountryName())){
                    i += item.getI() * rate;
                }else if(entry.getValue().equals(GeneralEnum.Warpath.country_troops.value()) && item.getCountryName().equals(entry.getKey().getCountryName())){
                    t += item.getT() * rate;
                }else if(entry.getValue().equals(GeneralEnum.Warpath.arms_force.value()) && item.getArmsName().equals(entry.getKey().getArmsName())){
                    f += item.getF() * rate;
                }else if(entry.getValue().equals(GeneralEnum.Warpath.arms_intellect.value()) && item.getArmsName().equals(entry.getKey().getArmsName())){
                    i += item.getI() * rate;
                }else if(entry.getValue().equals(GeneralEnum.Warpath.arms_troops.value()) && item.getArmsName().equals(entry.getKey().getArmsName())){
                    t += item.getT() * rate;
                }
            }
            item.setF21(f.intValue());
            item.setI21(i.intValue());
            item.setT21(t.intValue());
            item.setC21((item.getF21()+item.getI21()+item.getT21())*2);
        }
    }

    private GeneralThree calculateEntourage(General general, List<General> allList) {
        List<Map<String,Object>> general_f = new ArrayList<>();
        List<Map<String,Object>> general_i = new ArrayList<>();
        List<Map<String,Object>> general_t = new ArrayList<>();
        List<GeneralAssociation> associationList = general.getAssociationList();
        GeneralThree three = new GeneralThree();
        int force = 0;
        int intellect = 0;
        int troops = 0;
        for (General all : allList){
            if(all.getParentId().equals(general.getParentId())){
                continue;
            }
            boolean flag = false;//是否联协
            for (GeneralAssociation association : associationList){
                if(association.getParentId().equals(all.getParentId())){
                    flag = true;
                    continue;
                }
            }
            //联协
            if(flag){
                GeneralThree three22 = GeneralCalculate.getThree(all, GeneralEnum.ThreeCirclesType.type_22);
                GeneralThree three24 = GeneralCalculate.getThree(all, GeneralEnum.ThreeCirclesType.type_24);
                GeneralThree three26 = GeneralCalculate.getThree(all, GeneralEnum.ThreeCirclesType.type_26);

                Map<String,Object> data_f = new HashMap<>();
                data_f.put("name",all.getName());
                data_f.put("value",three22.getForce());
                data_f.put("pid",all.getParentId());
                general_f.add(data_f);

                Map<String,Object> data_i = new HashMap<>();
                data_i.put("name",all.getName());
                data_i.put("value",three24.getIntellect());
                data_i.put("pid",all.getParentId());
                general_i.add(data_i);

                Map<String,Object> data_t = new HashMap<>();
                data_t.put("name",all.getName());
                data_t.put("value",three26.getTroops());
                data_t.put("pid",all.getParentId());
                general_t.add(data_t);
            }else{
                GeneralThree three23 = GeneralCalculate.getThree(all, GeneralEnum.ThreeCirclesType.type_23);
                GeneralThree three25 = GeneralCalculate.getThree(all, GeneralEnum.ThreeCirclesType.type_25);
                GeneralThree three27 = GeneralCalculate.getThree(all, GeneralEnum.ThreeCirclesType.type_27);

                Map<String,Object> data_f = new HashMap<>();
                data_f.put("name",all.getName());
                data_f.put("value",three23.getForce());
                data_f.put("pid",all.getParentId());
                general_f.add(data_f);

                Map<String,Object> data_i = new HashMap<>();
                data_i.put("name",all.getName());
                data_i.put("value",three25.getIntellect());
                data_i.put("pid",all.getParentId());
                general_i.add(data_i);

                Map<String,Object> data_t = new HashMap<>();
                data_t.put("name",all.getName());
                data_t.put("value",three27.getTroops());
                data_t.put("pid",all.getParentId());
                general_t.add(data_t);
            }

        }
        Collections.sort(general_f, new MapComparatorDesc());
        Collections.sort(general_i, new MapComparatorDesc());
        Collections.sort(general_t, new MapComparatorDesc());

        general_f = general_f.subList(0,7);
        general_i = general_i.subList(0,7);
        general_t = general_t.subList(0,7);

        Map<String,Object> top_f = general_f.get(0);
        Map<String,Object> top_i = general_i.get(0);
        Map<String,Object> top_t = general_t.get(0);

        Set<String> set = new LinkedHashSet<>();
        set.add(top_f.get("name").toString());
        set.add(top_i.get("name").toString());
        set.add(top_t.get("name").toString());

        if(set.size() == 3){
            System.out.println(general.getName());
            System.out.println("武随："+top_f.get("name").toString()+"("+top_f.get("value").toString()+")");
            System.out.println("智随："+top_i.get("name").toString()+"("+top_i.get("value").toString()+")");
            System.out.println("兵随："+top_t.get("name").toString()+"("+top_t.get("value").toString()+")");
            force = Integer.valueOf(top_f.get("value").toString());
            intellect = Integer.valueOf(top_i.get("value").toString());
            troops = Integer.valueOf(top_t.get("value").toString());
        }else if(set.size() == 2){
            System.out.println(general.getName());
            if(top_f.get("name").toString().equals(top_i.get("name").toString())){
                System.out.println("武随、智随相同");
                List<Map<String,Object>> data = new ArrayList<>();
                for(Map<String,Object> f : general_f){
                    for(Map<String,Object> i : general_i){
                        if(f.get("pid").equals(i.get("pid"))){
                            continue;
                        }
                        Map<String,Object> item = new HashMap<>();
                        item.put("name_f",f.get("name"));
                        item.put("value_f",f.get("value"));
                        item.put("name_i",i.get("name"));
                        item.put("value_i",i.get("value"));
                        item.put("value",Integer.valueOf(f.get("value").toString())+Integer.valueOf(i.get("value").toString()));
                        data.add(item);
                    }
                }
                Collections.sort(data, new MapComparatorDesc());
                Map<String,Object> map = data.get(0);
                System.out.println("武随："+map.get("name_f").toString()+"("+map.get("value_f").toString()+")");
                System.out.println("智随："+map.get("name_i").toString()+"("+map.get("value_i").toString()+")");
                System.out.println("兵随："+top_t.get("name").toString()+"("+top_t.get("value").toString()+")");
                force = Integer.valueOf(map.get("value_f").toString());
                intellect = Integer.valueOf(map.get("value_i").toString());
                troops = Integer.valueOf(top_t.get("value").toString());
                data = null;
            }else if(top_i.get("name").toString().equals(top_t.get("name").toString())){
                System.out.println("智随、兵随相同");
                List<Map<String,Object>> data = new ArrayList<>();
                for(Map<String,Object> i : general_i){
                    for(Map<String,Object> t : general_t){
                        if(i.get("pid").equals(t.get("pid"))){
                            continue;
                        }
                        Map<String,Object> item = new HashMap<>();
                        item.put("name_i",i.get("name"));
                        item.put("value_i",i.get("value"));
                        item.put("name_t",t.get("name"));
                        item.put("value_t",t.get("value"));
                        item.put("value",Integer.valueOf(i.get("value").toString())+Integer.valueOf(t.get("value").toString()));
                        data.add(item);
                    }
                }
                Collections.sort(data, new MapComparatorDesc());
                Map<String,Object> map = data.get(0);
                System.out.println("武随："+top_f.get("name").toString()+"("+top_f.get("value").toString()+")");
                System.out.println("智随："+map.get("name_i").toString()+"("+map.get("value_i").toString()+")");
                System.out.println("兵随："+map.get("name_t").toString()+"("+map.get("value_t").toString()+")");
                force = Integer.valueOf(top_f.get("value").toString());
                intellect = Integer.valueOf(map.get("value_i").toString());
                troops = Integer.valueOf(map.get("value_t").toString());
                data = null;
            }else if(top_f.get("name").toString().equals(top_t.get("name").toString())){
                System.out.println("武随、兵随相同");
                List<Map<String,Object>> data = new ArrayList<>();
                for(Map<String,Object> f : general_f){
                    for(Map<String,Object> t : general_t){
                        if(f.get("pid").equals(t.get("pid"))){
                            continue;
                        }
                        Map<String,Object> item = new HashMap<>();
                        item.put("name_f",f.get("name"));
                        item.put("value_f",f.get("value"));
                        item.put("name_t",t.get("name"));
                        item.put("value_t",t.get("value"));
                        item.put("value",Integer.valueOf(f.get("value").toString())+Integer.valueOf(t.get("value").toString()));
                        data.add(item);
                    }
                }
                Collections.sort(data, new MapComparatorDesc());
                Map<String,Object> map = data.get(0);
                System.out.println("武随："+map.get("name_f").toString()+"("+map.get("value_f").toString()+")");
                System.out.println("智随："+top_i.get("name").toString()+"("+top_i.get("value").toString()+")");
                System.out.println("兵随："+map.get("name_t").toString()+"("+map.get("value_t").toString()+")");
                force = Integer.valueOf(map.get("value_f").toString());
                intellect = Integer.valueOf(top_i.get("value").toString());
                troops = Integer.valueOf(map.get("value_t").toString());
                data = null;
            }
        }else if(set.size() == 1){
            System.out.println("武随、智随、兵随相同");
            List<Map<String,Object>> data = new ArrayList<>();
            for(Map<String,Object> f : general_f){
                for(Map<String,Object> i : general_i){
                    if(f.get("pid").equals(i.get("pid"))){
                        continue;
                    }
                    for(Map<String,Object> t : general_t){
                        if(t.get("pid").equals(i.get("pid"))){
                            continue;
                        }
                        Map<String,Object> item = new HashMap<>();
                        item.put("name_f",f.get("name"));
                        item.put("value_f",f.get("value"));
                        item.put("name_i",i.get("name"));
                        item.put("value_i",i.get("value"));
                        item.put("name_t",t.get("name"));
                        item.put("value_t",t.get("value"));
                        item.put("value",Integer.valueOf(f.get("value").toString())+Integer.valueOf(i.get("value").toString())+Integer.valueOf(t.get("value").toString()));
                        data.add(item);
                    }
                }
            }
            Collections.sort(data, new MapComparatorDesc());
            Map<String,Object> map = data.get(0);
            System.out.println("武随："+map.get("name_f").toString()+"("+map.get("value_f").toString()+")");
            System.out.println("智随："+map.get("name_i").toString()+"("+map.get("value_i").toString()+")");
            System.out.println("兵随："+map.get("name_t").toString()+"("+map.get("value_t").toString()+")");
            force = Integer.valueOf(map.get("value_f").toString());
            intellect = Integer.valueOf(map.get("value_i").toString());
            troops = Integer.valueOf(map.get("value_t").toString());
            data = null;
        }
        three.setForce(force);
        three.setIntellect(intellect);
        three.setTroops(troops);
        three.setCombat((force+intellect+troops)*2);
        return three;
    }

    /**
     * listmap降序
     */
    static class MapComparatorDesc implements Comparator<Map<String, Object>> {
        @Override
        public int compare(Map<String, Object> m1, Map<String, Object> m2) {
            Integer v1 = Integer.valueOf(m1.get("value").toString());
            Integer v2 = Integer.valueOf(m2.get("value").toString());
            if (v2 != null) {
                return v2.compareTo(v1);
            }
            return 0;
        }

    }

    static class MapComparatorDoubleDesc implements Comparator<Map<String, Object>> {
        @Override
        public int compare(Map<String, Object> m1, Map<String, Object> m2) {
            Double v1 = Double.valueOf(m1.get("value").toString());
            Double v2 = Double.valueOf(m2.get("value").toString());
            if (v2 != null) {
                return v2.compareTo(v1);
            }
            return 0;
        }

    }

    /**
     * listmap升序
     */
    static class MapComparatorAsc implements Comparator<Map<String, Object>> {
        @Override
        public int compare(Map<String, Object> m1, Map<String, Object> m2) {
            Integer v1 = Integer.valueOf(m1.get("value").toString());
            Integer v2 = Integer.valueOf(m2.get("value").toString());
            if(v1 != null){
                return v1.compareTo(v2);
            }
            return 0;
        }

    }

    private GeneralResult calculateResult(List<General> generalList,List<General> allList) {
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
            item.setCountryName(general.getCountryName());
            item.setArmsName(general.getArmsName());
            item.setGenderName(general.getGenderName());
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
            GeneralThree three22 = calculateEntourage(general,allList);//计算随从
            int f22 = three22.getForce();
            int i22 = three22.getIntellect();
            int t22 = three22.getTroops();
            int c22 = (f22+i22+t22)*2;
            item.setF22(f22);
            item.setI22(i22);
            item.setT22(t22);
            item.setC22(c22);
            force += f22;
            intellect += i22;
            troops += t22;
            combat += c22;
            print(general,three22);

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
