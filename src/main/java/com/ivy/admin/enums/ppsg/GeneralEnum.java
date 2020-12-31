package com.ivy.admin.enums.ppsg;

import com.ivy.admin.utils.ppsg.MapKeys;
import com.ivy.admin.utils.ppsg.MapUtils;
import com.ivy.system.enums.IDictItem;
import com.ivy.system.enums.StaticDictPool;

public interface GeneralEnum {

    public static void main(String[] args) {
        // 获取 Gender 表 性别 为 男性的 数据字典代码
        GeneralEnum.Gender.man.value();
        GeneralEnum.Gender.man.label();
        // 针对 Teacher 表 的 状态 字段,  通过 文本标签:"在职" 获取对应的 数据字典代码
        IDictItem.getValueByLabel(GeneralEnum.Gender.class, "男");
        // 针对 Teacher 表 的 状态 字段,  通过 数据字典代码 获取对应的 文本标签
        IDictItem.getLabelByValue(GeneralEnum.Gender.class, 1);
        // 针对 Teacher 表 的 状态 字段,  通过 文本标签 获取对应的 枚举项
        IDictItem.getByLabel(GeneralEnum.Gender.class, "男"); // 返回: GeneralEnum.Gender.man
        // 针对 Teacher 表 的 状态 字段,  通过 数据字典代码 获取对应的 枚举项
        IDictItem.getByValue(GeneralEnum.Gender.class, 1);// 返回: GeneralEnum.Gender.woman
    }

    /**
     * 性别
     */
    enum Gender implements IDictItem {
        man(1, "男"),
        woman(2, "女");
        Gender(Integer value, String label) {
            StaticDictPool.putDictItem(this, value, label);
        }
    }

    /**
     * 三维
     */
    enum ThreeCircles implements IDictItem {
        force(1, "武力"),
        intellect(2, "智力"),
        troops(2, "兵力"),
        ;
        ThreeCircles(Integer value, String label) {
            StaticDictPool.putDictItem(this, value, label);
        }
    }

    enum ThreeCirclesType implements IDictItem {
        type_1(1, "基础三维"),
        type_2(2, "异化基础三维"),
        type_3(3, "满级基础三维"),
        type_4(4, "异化满级基础三维"),
        type_5(5, "科技三维"),
        type_6(6, "四圣石三维"),
        type_7(7, "战器三维"),
        type_8(8, "特殊战器三维"),
        type_9(9, "兵书三维"),
        type_10(10, "将魂三维"),
        type_11(11, "战阵三维"),
        type_12(12, "命格三维"),
        type_13(13, "幻化三维"),
        type_14(14, "阵法三维"),
        type_15(15, "战意三维"),
        ;
        ThreeCirclesType(Integer value, String label) {
            StaticDictPool.putDictItem(this, value, label);
        }
    }

    enum PassiveType implements IDictItem {
        type_1(1, "基础被动"),
        type_2(2, "专属被动"),
        type_3(3, "战器小被动"),
        type_4(4, "战器大被动"),
        type_5(5, "逆命被动"),
        type_6(6, "逆命特性被动"),
        type_7(7, "阵法被动"),
        ;
        PassiveType(Integer value, String label) {
            StaticDictPool.putDictItem(this, value, label);
        }
    }

    /**
     * 分类
     */
    enum Category implements IDictItem {
        jue_xing(1, "觉醒"),
        duo_tian(2, "堕天"),
        ni_ming(3, "逆命"),
        ;
        Category(Integer value, String label) {
            StaticDictPool.putDictItem(this, value, label);
        }
    }

    enum CardType implements IDictItem {
        pu_tong(1, "普通卡"),
        yi_hua(2, "异化卡"),
        zhou_nian_qin(3, "周年庆卡"),
        ding_zhi(4, "定制卡"),
        ;
        CardType(Integer value, String label) {
            StaticDictPool.putDictItem(this, value, label);
        }
    }

    /**
     * 分类
     */
    enum DestinyType1 implements IDictItem {
        none(1, "无"),
        tu_po(2, "突破");
        DestinyType1(Integer value, String label) {
            StaticDictPool.putDictItem(this, value, label);
        }
    }
    enum DestinyType2 implements IDictItem {
        none(1, "无"),
        ni_ming_1(2, "一段逆命"),
        ni_ming_2(3, "二段逆命");
        DestinyType2(Integer value, String label) {
            StaticDictPool.putDictItem(this, value, label);
        }
    }

    /**
     * 武将类型
     */
    enum GeneralsType implements IDictItem {
        type1(1,"勇将型",3,1,2),
        type2(2,"将军型",2,1,3),
        type3(3,"智将型",2,2,2),
        type4(4,"策士型",1,3,2),
        type5(5,"强袭勇将型",4,2,3),
        type6(6,"统帅将军型",3,2,4),
        type7(7,"鬼才智将型",3,3,3),
        type8(8,"天命策士型",2,4,3);
        GeneralsType(Integer value, String label, Integer growForce, Integer growIntellect, Integer growTroops) {
            StaticDictPool.putDictItem(this, value, label, MapUtils.toMap(MapKeys.growForce, growForce, MapKeys.growIntellect, growIntellect,MapKeys.growTroops, growTroops));
        }
    }

    /**
     * 国家
     */
    enum Country implements IDictItem {
        wei(1,"魏"),
        shu(2,"蜀"),
        wu(3,"吴"),
        qun(4,"群");
        Country(Integer value, String label) {
            StaticDictPool.putDictItem(this, value, label);
        }
    }
    enum Countrys implements IDictItem {
        wei_country(1,"魏国国家队"),
        shu_country(2,"蜀国国家队"),
        wu_country(3,"吴国国家队"),
        qun_country(4,"群雄国家队"),
        nv_country(5,"女队国家队"),
        wei_mashup(6,"魏国混搭队"),
        shu_mashup(7,"蜀国混搭队"),
        wu_mashup(8,"吴国混搭队"),
        qun_mashup(9,"群雄混搭队"),
        nv_mashup(10,"女队混搭队"),
        ;
        Countrys(Integer value, String label) {
            StaticDictPool.putDictItem(this, value, label);
        }
    }

    /**
     * 星级
     */
    enum Star implements IDictItem {
        star1(1,"一星白卡","白卡"),
        star2(2,"二星黑卡","黑卡"),
        star3(3,"三星银卡","银卡"),
        star4(4,"四星金卡","金卡"),
        star5(5,"五星钻卡","钻卡");
        Star(Integer value, String label, String desc) {
            StaticDictPool.putDictItem(this, value, label);
        }
    }


    /**
     * 兵种
     */
    enum Arms implements IDictItem {
        qiang(1,"枪",0.6,0.4,0.8,"盾枪兵",0.07,0.03,0.10,"长戟兵",0.10,0.03,0.07),
        gong(2,"弓",0.6,0.8,0.4,"火矢兵",0.07,0.10,0.03,"连弩兵",0.10,0.07,0.03),
        qi(3,"骑",0.8,0.4,0.6,"重骑兵",0.07,0.03,0.10,"骠骑兵",0.10,0.03,0.07);
        Arms(Integer value, String label, Double forceRate, Double intellectRate, Double troopsRate, String arms1, Double armsForceRate1, Double armsIntellectRate1, Double armsTroopsRate1, String arms2, Double armsForceRate2, Double armsIntellectRate2, Double armsTroopsRate2) {
            StaticDictPool.putDictItem(this, value, label, MapUtils.toMap(MapKeys.forceRate,forceRate,MapKeys.intellectRate,intellectRate,MapKeys.troopsRate,troopsRate,"arms1",arms1,"armsForceRate1",armsForceRate1,"armsIntellectRate1",armsIntellectRate1,"armsTroopsRate1",armsTroopsRate1,"arms2",arms2,"armsForceRate2",armsForceRate2,"armsIntellectRate2",armsIntellectRate2,"armsTroopsRate2",armsTroopsRate2));
        }
    }

    /**
     * 战器
     */
    enum Weapon implements IDictItem {
        dao(1,"刀",6,"刀",133,106,160,133,106,160,224,178,494,1.0,1.0,1.0,288,288,288,458,458,1220),
        jian(2,"剑",7,"特殊剑",133,133,133,133,106,160,227,224,445,1.0,1.0,1.0,288,288,288,458,458,1220),
        qiang(3,"枪",8,"特殊枪",160,106,133,133,133,133,273,178,445,1.0,1.0,1.0,288,288,288,458,458,1220),
        gong(4,"弓",9,"特殊弓",133,133,133,160,106,133,224,227,445,1.0,1.0,1.0,288,288,288,458,458,1220),
        shan(5,"扇",10,"特殊扇",133,160,106,133,133,133,224,273,399,1.0,1.0,1.0,288,288,288,458,458,1220),
        ;
        Weapon(Integer value, String label,Integer value2, String label2, Integer force, Integer intellect, Integer troops,Integer forcex, Integer intellectx, Integer troopsx, Integer strengthenForce, Integer strengthenIntellect, Integer strengthenTroops, Double quenchingForceRate, Double quenchingIntellectRate, Double quenchingTroopsRate, Integer exclusiveForce, Integer exclusiveIntellect, Integer exclusiveTroops, Integer passive1, Integer passive2, Integer passive3) {
            StaticDictPool.putDictItem(this, value, label,MapUtils.toMap(MapKeys.value2,value2,MapKeys.label2,label2,MapKeys.force,force,MapKeys.intellect,intellect,MapKeys.troops,troops,MapKeys.forcex,forcex,MapKeys.intellectx,intellectx,MapKeys.troopsx,troopsx,MapKeys.strengthenForce,strengthenForce,MapKeys.strengthenIntellect,strengthenIntellect,MapKeys.strengthenTroops,strengthenTroops,MapKeys.quenchingForceRate,quenchingForceRate,MapKeys.quenchingIntellectRate,quenchingIntellectRate,MapKeys.quenchingTroopsRate,quenchingTroopsRate,MapKeys.exclusiveForce,exclusiveForce,MapKeys.exclusiveIntellect,exclusiveIntellect,MapKeys.exclusiveTroops,exclusiveTroops,MapKeys.passive1,passive1,MapKeys.passive2,passive2,MapKeys.passive3,passive3));
        }
    }

    /**
     * 兵书
     */
    enum ArmsPosition implements IDictItem {
        jiao_li(1,"角力","金鼓","武锋"),
        qi_shu(2,"骑术","金鼓","武锋"),
        gong_shu(3,"弓术","军略","三疑"),
        zhan_lue(4,"战略","军略","三疑"),
        fang_yu(5,"防御","文伐","兵道"),
        qiang_shu(6,"枪术","文伐","兵道"),
        jing_zhun(7,"精准","军略","文伐"),
        zhen_lie(8,"阵列","金鼓","文伐"),
        duan_bing(9,"短兵","金鼓","军略"),
        ;
        ArmsPosition(Integer value, String label, String position1, String position2) {
            StaticDictPool.putDictItem(this, value, label,MapUtils.toMap("position1",position1,"position2",position2));
        }
    }

    /**
     * 兵书属性
     */
    enum ArmsBook implements IDictItem {
        wu_feng(1,"武锋","蓝色",160,0,0),
        san_yi(2,"三疑","红色",0,160,0),
        bing_dao(3,"兵道","黄色",0,0,160),
        jun_lue(4,"军略","紫色",80,80,0),
        jin_gu(5,"金鼓","绿色",40,0,120),
        wen_fa(6,"文伐","橙色",0,40,120),
        ;
        ArmsBook(Integer value, String label, String color, Integer force, Integer intellect, Integer troops) {
            StaticDictPool.putDictItem(this, value, label,MapUtils.toMap("color",color,"force",force,"intellect",intellect,"troops",troops));
        }
    }

    /**
     * 战意
     */
    enum Warpath implements IDictItem {
        country_force(1,"同国家上阵武将武力加成10%",0.1),
        country_intellect(2,"同国家上阵武将智力加成10%",0.1),
        country_troops(3,"同国家上阵武将兵力加成10%",0.1),
        arms_force(4,"同兵种上阵武将武力加成10%",0.1),
        arms_intellect(5,"同兵种上阵武将智力加成10%",0.1),
        arms_troops(6,"同兵种上阵武将兵力加成10%",0.1);
        ;
        Warpath(Integer value, String label, Double rate) {
            StaticDictPool.putDictItem(this, value, label,MapUtils.toMap("rate",rate));
        }
    }

    /**
     * 兵符位置
     */
    enum SymbolsPosition implements IDictItem {
        number1(1,"1号位",360,0,0,0d,0d,0d,0d),
        number2(2,"2号位",0,0,0,0.211,0.211,0.318,0.106),
        number3(3,"3号位",0,360,0,0d,0d,0d,0d),
        number4(4,"4号位",0,0,0,0.232,0.232,0.35,0.116),
        number5(5,"5号位",0,0,551,0d,0d,0d,0d),
        number6(6,"6号位",0,0,0,0.253,0.253,0.382,0.126);
        ;
        //武力增加、智力增加、兵力增加、武力加成百分比、智力加成百分比、兵力加成百分比、全属性加成百分比
        SymbolsPosition(Integer value, String label, Integer force, Integer intellect, Integer troops, Double addForceRate, Double addIntellectRate, Double addTroopsRate, Double allRate) {
            StaticDictPool.putDictItem(this, value, label,MapUtils.toMap("force",force,"intellect",intellect,"troops",troops,"addForceRate",addForceRate,"addIntellectRate",addIntellectRate,"addTroopsRate",addTroopsRate,"allRate",allRate));
        }
    }

    /**
     * 兵符主属性
     */
    enum SymbolsMainAttr implements IDictItem {
        force(1 , "武力增加360" , 360 , 0d),//1号位
        intellect(2 , "智力增加360" , 360 , 0d),//3号位
        troops(3 , "兵力增加551" , 551 , 0d),//5号位

        forceRate1(4 , "武力加成21.1%" , 0 , 0.211),//2号位
        forceRate2(5 , "武力加成23.2%" , 0 , 0.232),//4号位
        forceRate3(6 , "武力加成25.3%" , 0 , 0.253),//6号位

        intellectRate1(7 , "智力加成21.1%" , 0 , 0.211),//2号位
        intellectRate2(8 , "智力加成23.2%" , 0 , 0.232),//4号位
        intellectRate3(9 , "智力加成25.3%" , 0 , 0.253),//6号位

        troopsRate1(10 , "兵力加成31.8%" , 0 , 0.318),//2号位
        troopsRate2(11 , "兵力加成35.0%" , 0 , 0.350),//4号位
        troopsRate3(12 , "兵力加成38.2%" , 0 , 0.382),//6号位

        allRate1(13 , "全属性加成10.6%" , 0 , 0.106),//2号位
        allRate2(14 , "全属性加成11.6%" , 0 , 0.116),//4号位
        allRate3(15 , "全属性加成12.6%" , 0 , 0.126),//6号位
        ;
        //
        SymbolsMainAttr(Integer value, String label,Integer val, Double rate) {
            StaticDictPool.putDictItem(this, value, label,MapUtils.toMap("val",val,"rate",rate));
        }
    }


    /**
     * 兵符副属性
     */
    enum SymbolsSecondAttr implements IDictItem {
        force(1,"武力增加64",64,0d),
        forceRate(2,"武力加成10.6%",0,0.106),

        intellect(3,"智力增加64",64,0d),
        intellectRate(4,"智力加成10.6%",0,0.106),

        troops(5,"兵力增加105",105,0d),
        troopsRate(6,"兵力加成15.9%",0,0.159),

        wuAll(7,"吴国全属性52",52,0d),
        wuAllRate(8,"吴国全属性加成7.5%",0,0.075),

        shuAll(9,"蜀国全属性52",52,0d),
        shuAllRate(10,"蜀国全属性加成7.5%",0,0.075),

        weiAll(11,"魏国全属性52",52,0d),
        weiAllRate(12,"魏国全属性加成7.5%",0,0.075),

        qunAll(13,"群雄全属性52",52,0d),
        qunAllRate(14,"群雄全属性加成7.5%",0,0.075),
        ;
        //
        SymbolsSecondAttr(Integer value, String label,Integer val, Double rate) {
            StaticDictPool.putDictItem(this, value, label,MapUtils.toMap("val",val,"rate",rate));
        }
    }

    /**
     * 兵符位置
     */
    enum SymbolsType implements IDictItem {
        cang_long(1,"苍龙","蜀国全属性加10%",0.1),
        meng_hu(2,"猛虎","吴国全属性加10%",0.1),
        huo_feng(3,"火凤","魏国全属性加10%",0.1),
        tian_lang(4,"天狼","群雄全属性加10%",0.1),

        xian_gui(5,"玄龟","枪兵全属性加10%",0.1),
        xiang_ying(6,"翔鹰","弓兵全属性加10%",0.1),
        qi_lin(7,"麒麟","骑兵全属性加10%",0.1),
        qing_luan(8,"青鸾","女性全属性加10%",0.1),

        bai_ze(9,"白泽","全体智力加24%",0.24),
        hun_dun(10,"混沌","全体全属性加8%",0.08),
        qiong_qi(11,"穷奇","全体武力加24%",0.24),
        ya_zi(12,"睚眦","全体兵力加24%",0.24),

        pí_xiū(13,"貔貅","骑兵全属性加12%",0.12),
        zhēng(14,"狰","枪兵全属性加12%",0.12),
        gǔ_diāo(15,"蛊雕","弓兵全属性加12%",0.12),
        ;
        //
        SymbolsType(Integer value, String label,String desc,Double rate) {
            StaticDictPool.putDictItem(this, value, label,MapUtils.toMap("desc",desc,"rate",rate));
        }
    }


    /**
     * 命格材料
     * 普通命石、精良命石、无暇命石
     * 紫薇之御
     * 普通天机之钥、普通天相之圭、普通太阴之精、普通太阳之焰、普通贪狼之爪、普通廉贞之锋、普通七杀之气、普通破军之血
     * 精良天机之钥、精良天相之圭、精良太阴之精、精良太阳之焰、精良贪狼之爪、精良廉贞之锋、精良七杀之气、精良破军之血
     * 无暇天机之钥、无暇天相之圭、无暇太阴之精、无暇太阳之焰、无暇贪狼之爪、无暇廉贞之锋、无暇七杀之气、无暇破军之血
     */
    enum DestinyMaterial implements IDictItem {
        ming_shi_pt(101,"普通命石"),
        ming_shi_jl(102,"精良命石"),
        ming_shi_wx(103,"无暇命石"),
        ming_shi_zz(104,"至臻命石"),

        tian_ji_pt(201,"普通天机之钥"),
        tian_ji_jl(202,"精良天机之钥"),
        tian_ji_wx(203,"无暇天机之钥"),

        tian_xiang_pt(301,"普通天相之圭"),
        tian_xiang_jl(302,"精良天相之圭"),
        tian_xiang_wx(303,"无暇天相之圭"),

        tai_yin_pt(401,"普通太阴之精"),
        tai_yin_jl(402,"精良太阴之精"),
        tai_yin_wx(403,"无暇太阴之精"),

        tai_yang_pt(501,"普通太阳之焰"),
        tai_yang_jl(502,"精良太阳之焰"),
        tai_yang_wx(503,"无暇太阳之焰"),

        tan_lang_pt(601,"普通贪狼之爪"),
        tan_lang_jl(602,"精良贪狼之爪"),
        tan_lang_wx(603,"无暇贪狼之爪"),

        lian_zhen_pt(701,"普通廉贞之锋"),
        lian_zhen_jl(702,"精良廉贞之锋"),
        lian_zhen_wx(703,"无暇廉贞之锋"),

        qi_sha_pt(801,"普通七杀之气"),
        qi_sha_jl(802,"精良七杀之气"),
        qi_sha_wx(803,"无暇七杀之气"),

        po_jun_pt(901,"普通破军之血"),
        po_jun_jl(902,"精良破军之血"),
        po_jun_wx(903,"无暇破军之血");

        DestinyMaterial(Integer value, String label) {
            StaticDictPool.putDictItem(this, value, label);
        }
    }


    /**
     * 阵法
     */
    enum Embattle implements IDictItem {
        long_fei(1,"龙飞",2,1,9,390,195,1755),
        //hu_yi(2,"",3,1,6),
        //niao_xiang(3,""),
        //she_pan(4,""),
        //huo_niu(5,""),
        //he_yi(6,""),
        ;

        Embattle(Integer value, String label, Integer growForce, Integer growIntellect, Integer growTroops, Integer maxForce, Integer maxIntellect, Integer maxTroops) {
            StaticDictPool.putDictItem(this, value, label,MapUtils.toMap(MapKeys.growForce,growForce,MapKeys.growIntellect,growIntellect,MapKeys.growTroops,growTroops,"maxForce",maxForce,"maxIntellect",maxIntellect,"maxTroops",maxTroops));
        }
    }

    /**
     * 四星武将
     */
    enum General4 implements IDictItem {
        wei_caocao(1001,"曹操"),
        wei_simayi(1002,"司马懿"),
        wei_zhangliao(1003,"张辽"),
        wei_xiahoudun(1004,"夏侯惇"),
        wei_dianwei(1005,"典韦"),
        wei_caopi(1006,"曹丕"),
        wei_guojia(1007,"郭嘉"),
        wei_xunyu(1008,"荀彧"),
        wei_xiahouyuan(1009,"夏侯渊"),
        wei_zhanghe(1010,"张郃"),
        wei_xiahoushi(1011,"夏侯氏"),
        wei_wangyuanji(1012,"王元姬"),
        wei_xuhuang(1013,"徐晃"),
        wei_zhangchunhua(1014,"张春华"),
        wei_beimihu(1015,"卑弥呼"),
        wei_shaonianzhangliao(1016,"少年张辽"),
        wei_caoren(1017,"曹仁"),
        wei_bianfuren(1018,"卞夫人"),
        wei_jiaxu(1019,"贾诩"),
        wei_zhenji(1020,"甄姬"),
        wei_xuchu(1021,"许褚"),

        shu_guanyu(2001,"关羽"),
        shu_zhugeliang(2002,"诸葛亮"),
        shu_zhaoyun(2003,"赵云"),
        shu_jiangwei(2004,"姜维"),
        shu_machao(2005,"马超"),
        shu_zhugeguo(2006,"诸葛果"),
        shu_liubei(2007,"刘备"),
        shu_weiyan(2008,"魏延"),
        shu_sunshangxiang(2009,"孙尚香"),
        shu_shaonianguanyu(2010,"少年关羽"),
        shu_shaonianzhaoyun(2011,"少年赵云"),
        shu_zhangfei(2012,"张飞"),
        shu_pangtong(2013,"庞统"),
        shu_huangzhong(2014,"黄忠"),
        shu_liushan(2015,"刘禅"),
        shu_huangwudie(2016,"黄舞蝶"),
        shu_mayunlu(2017,"马云禄"),
        shu_huangyueying(2018,"黄月英"),
        shu_fazheng(2019,"法正"),
        shu_zhangxingcai(2020,"张星彩"),
        shu_guanping(2021,"关平"),

        wu_lvmeng(3001,"吕蒙"),
        wu_zhouyu(3002,"周瑜"),
        wu_sunquan(3003,"孙权"),
        wu_taishici(3004,"太史慈"),
        wu_sunce(3005,"孙策"),
        wu_luxun(3006,"陆逊"),
        wu_sunjian(3007,"孙坚"),
        wu_ganning(3008,"甘宁"),
        wu_bulianshi(3009,"步练师"),
        wu_zhoutai(3010,"周泰"),
        wu_sunliang(3011,"孙亮"),
        wu_shaonianzhouyu(3012,"少年周瑜"),
        wu_sunxiaohu(3013,"孙小虎"),
        wu_huanggai(3014,"黄盖"),
        wu_sundahu(3015,"孙大虎"),
        wu_lingtong(3016,"凌统"),
        wu_lusu(3017,"鲁肃"),
        wu_xiaoqiao(3018,"小乔"),
        wu_wufuren(3019,"吴夫人"),
        wu_daqiao(3020,"大乔"),
        wu_zhuran(3021,"朱然"),

        qun_lvji(4001,"吕姬"),
        qun_tongyuan(4002,"童渊"),
        qun_dongbai(4003,"董白"),
        qun_yanliang(4004,"颜良"),
        qun_hetaihou(4005,"何太后"),
        qun_caiwenji(4006,"蔡文姬"),
        qun_wenchou(4007,"文丑"),
        qun_lvbu(4008,"吕布"),
        qun_huatuo(4009,"华佗"),
        qun_shaonianlvbu(4010,"少年吕布"),
        qun_yuji(4011,"于吉"),
        qun_dongzhuo(4012,"董卓"),
        qun_tianfeng(4013,"田丰"),
        qun_menghuo(4014,"孟获"),
        qun_yuanshao(4015,"袁绍"),
        qun_zhangjiao(4016,"张角"),
        qun_gaoshun(4017,"高顺"),
        qun_diaochan(4018,"貂蝉"),
        qun_lvlingqi(4019,"吕玲绮"),
        qun_zoushi(4020,"邹氏"),
        qun_tianzihanxiandi(4021,"天子汉献帝"),
        qun_zhurongfuren(4022,"祝融夫人"),
        qun_gongsunzan(4023,"公孙瓒"),
        qun_huaxiong(4024,"华雄"),
        ;

        General4(Integer value, String label) {
            StaticDictPool.putDictItem(this, value, label);
        }
    }
}
