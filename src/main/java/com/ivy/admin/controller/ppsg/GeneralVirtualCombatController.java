package com.ivy.admin.controller.ppsg;

import com.github.benmanes.caffeine.cache.Cache;
import com.ivy.admin.aspect.log.Log;
import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.entity.ppsg.GeneralAnalog;
import com.ivy.admin.enums.ppsg.GeneralEnum;
import com.ivy.admin.service.ppsg.GeneralArmsBookService;
import com.ivy.admin.service.ppsg.GeneralAssociationService;
import com.ivy.admin.service.ppsg.GeneralService;
import com.ivy.admin.service.ppsg.GeneralSkinService;
import com.ivy.admin.service.ppsg.GeneralThreeService;
import com.ivy.admin.service.ppsg.GeneralWeaponService;
import com.ivy.admin.utils.ResultMsg;
import com.ivy.admin.vo.ppsg.GeneralVo;
import com.ivy.system.config.CacheKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 武将
 * @author: Administrator
 * @date: 2020-12-30
 */
@RestController
@RequestMapping("/ppsg/general/virtualCombat")
public class GeneralVirtualCombatController {

    @Autowired
    private Cache<String, Object> cache;
    @Autowired
    private GeneralService generalService;
    @Autowired
    private GeneralAssociationService generalAssociationService;
    @Autowired
    private GeneralWeaponService generalWeaponService;
    @Autowired
    private GeneralArmsBookService generalArmsBookService;
    @Autowired
    private GeneralSkinService generalSkinService;
    @Autowired
    private GeneralThreeService generalThreeService;

    @Log("ppsg.General")
    @PostMapping("/list")
    public ResultMsg list(){
        Object data = cache.get(CacheKeys.GENERALS_LIST,key -> getValue(key));
        return ResultMsg.success(data);
    }

    public Object getValue(String key){
        GeneralVo generalVo = new GeneralVo();
        generalVo.setDelFlag(false);
        List<General> list = generalService.selectList(generalVo);
        Map<String,Object> map = null;
        List<Map<String,Object>> mapList = new ArrayList<>();
        for (General general : list){
            map = new HashMap<>();
            map.put("label",general.getName());
            map.put("value",general.getId());
            mapList.add(map);
        }
        return mapList;
    }

    @Log("ppsg.General")
    @PostMapping("/invalidate")
    public ResultMsg invalidate(){
        cache.invalidate(CacheKeys.GENERALS_LIST);
        return ResultMsg.success();
    }

    @Log("ppsg.General")
    @PostMapping("/query")
    public ResultMsg query(@RequestBody GeneralAnalog analog){
        return ResultMsg.success();
    }

    /**
     * localhost:8088/ivy/ppsg/general/virtualCombat/querys
     * @return
     */
    @Log("ppsg.General")
    @GetMapping("/querys")
    public ResultMsg querys(){
        GeneralAnalog analog = new GeneralAnalog();
        analog.setIds("2,3,4,5,6");
        String[] ids = analog.getIds().split(",");

        List<General> allList = (List<General>) cache.get(CacheKeys.GENERALS_ALL_LIST,key -> getAllValue(key));
        List<General> generalList = new ArrayList<>();
        for (General general : allList){
            for (String id : ids){
                if(general.getId().toString().equals(id)){
                    generalList.add(general);
                }
            }
        }

        return ResultMsg.success();
    }

    public Object getAllValue(String key){
        GeneralVo generalVo = new GeneralVo();
        generalVo.setDelFlag(false);
        return generalService.selectList(generalVo);
    }
}
