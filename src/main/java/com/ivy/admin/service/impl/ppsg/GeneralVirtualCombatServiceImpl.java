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

        if(result != null){
            resultList.add(result);
        }
        return resultList;
    }

    private void calculateWarpath(GeneralResult result, List<General> generalList) {
        Map<General,GeneralEnum.Warpath> map = new HashMap<>();
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
            data = MapUtils.sortByValue(data);
            Iterator<Map.Entry<String, Integer>> iterator = data.entrySet().iterator();
            Map.Entry<String, Integer> tail = null;
            while (iterator.hasNext()) {
                tail = iterator.next();
            }
            if(tail.getKey().equals("f_c")){
                map.put(general,GeneralEnum.Warpath.country_force);
            }else if(tail.getKey().equals("i_c")){
                map.put(general,GeneralEnum.Warpath.country_intellect);
            }else if(tail.getKey().equals("t_c")){
                map.put(general,GeneralEnum.Warpath.country_troops);
            }else if(tail.getKey().equals("f_a")){
                map.put(general,GeneralEnum.Warpath.arms_force);
            }else if(tail.getKey().equals("i_a")){
                map.put(general,GeneralEnum.Warpath.arms_intellect);
            }else if(tail.getKey().equals("t_a")){
                map.put(general,GeneralEnum.Warpath.arms_troops);
            }
            System.out.println();
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
