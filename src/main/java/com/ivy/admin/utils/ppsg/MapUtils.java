package com.ivy.admin.utils.ppsg;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapUtils {

    public static void main(String[] args) {
        Map<String,Object> map = toMap("force", 1, "intellect", 2,"troops", 3);
    }

    public static <T> T get(String key,Map<String,Object> map){
        T t = (T)map.get(key);
        return t;
    }

    public static Map<String,Object> toMap(Object... params){
        Map<String,Object> map = new HashMap<>();
        for (int i=0;i<params.length;i++){
            if(i%2 == 0){
                map.put(params[i].toString(),params[i+1]);
            }
        }
        return map;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    /**
     * 获取LinkedHashMap中的头部元素（最早添加的元素）：时间复杂度O(1)
     */
    public static <K, V> Map.Entry<K, V> getHead(LinkedHashMap<K, V> map) {
        return map.entrySet().iterator().next();
    }

    /**
     * 获取LinkedHashMap中的末尾元素（最近添加的元素）：时间复杂度O(n)
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static  <K, V> Map.Entry<K, V> getLast(LinkedHashMap<K, V> map) {
        Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
        Map.Entry<K, V> tail = null;
        while (iterator.hasNext()) {
            tail = iterator.next();
        }
        return tail;
    }
}
