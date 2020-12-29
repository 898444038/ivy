package com.ivy.admin.enums.ppsg;

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
        ;
        ThreeCirclesType(Integer value, String label) {
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
        GeneralsType(Integer value, String label, Integer force, Integer intellect, Integer troops) {
            StaticDictPool.putDictItem(this, value, label);
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
            StaticDictPool.putDictItem(this, value, label);
        }
    }

    /**
     * 战器
     */
    enum Weapon implements IDictItem {
        knife(1,"刀","刀",133,106,160,224,178,494,1.0,1.0,1.0,288,288,288,458,458,1220),
        sword(2,"剑","剑",133,133,133,227,224,445,1.0,1.0,1.0,288,288,288,458,458,1220),
        gun(3,"枪","枪",160,106,133,273,178,445,1.0,1.0,1.0,288,288,288,458,458,1220),
        arch(4,"弓","弓",133,133,133,224,227,445,1.0,1.0,1.0,288,288,288,458,458,1220),
        fan(5,"扇","扇",133,160,106,224,273,399,1.0,1.0,1.0,288,288,288,458,458,1220),
        //异化战器
        knife2(6,"刀2","刀",133,106,160,224,178,494,1.0,1.0,1.0,288,288,288,458,458,1220),
        sword2(7,"剑2","特殊剑",133,106,160,227,224,445,1.0,1.0,1.0,288,288,288,458,458,1220),
        gun2(8,"枪2","特殊枪",133,133,133,273,178,445,1.0,1.0,1.0,288,288,288,458,458,1220),
        arch2(9,"弓2","特殊弓",160,106,133,224,227,445,1.0,1.0,1.0,288,288,288,458,458,1220),
        fan2(10,"扇2","特殊扇",133,133,133,224,273,399,1.0,1.0,1.0,288,288,288,458,458,1220),
        ;
        Weapon(Integer value, String label, String desc, Integer force, Integer intellect, Integer troops, Integer strengthenForce, Integer strengthenIntellect, Integer strengthenTroops, Double quenchingForceRate, Double quenchingIntellectRate, Double quenchingTroopsRate, Integer exclusiveForce, Integer exclusiveIntellect, Integer exclusiveTroops, Integer passive1, Integer passive2, Integer passive3) {
            StaticDictPool.putDictItem(this, value, label);
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
            StaticDictPool.putDictItem(this, value, label);
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
            StaticDictPool.putDictItem(this, value, label);
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
            StaticDictPool.putDictItem(this, value, label);
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
            StaticDictPool.putDictItem(this, value, label);
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
            StaticDictPool.putDictItem(this, value, label);
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
            StaticDictPool.putDictItem(this, value, label);
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
            StaticDictPool.putDictItem(this, value, label);
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
            StaticDictPool.putDictItem(this, value, label);
        }
    }
}
