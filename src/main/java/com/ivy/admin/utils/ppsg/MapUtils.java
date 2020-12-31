package com.ivy.admin.utils.ppsg;

import java.util.HashMap;
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

}
