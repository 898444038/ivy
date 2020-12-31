package com.ivy.system.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StaticDictPool {

    private StaticDictPool() {}

    /**
     * 用于存储字典数据
     */
    private static final Map<IDictItem, DictItemBean> dictItemMap = new ConcurrentHashMap<>();

    /**
     * 往 map 中添加代码项
     */
    public static void putDictItem(IDictItem iCodeItem, Integer value, String label) {
        dictItemMap.put(iCodeItem, DictItemBean.of(value, label, new HashMap<>()));
    }
    public static void putDictItem(IDictItem iCodeItem, Integer value, String label, Map<String,Object> params ) {
        dictItemMap.put(iCodeItem, DictItemBean.of(value, label, params));
    }

    /**
     * 获取静态数据
     */
    static DictItemBean getDictItem(IDictItem iCodeItem) {
        return dictItemMap.get(iCodeItem);
    }
}
