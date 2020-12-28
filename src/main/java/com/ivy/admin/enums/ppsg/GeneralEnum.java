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
}
