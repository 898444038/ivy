package com.ivy.admin.controller.ppsg;

import com.ivy.admin.service.ppsg.GeneralWeaponService;
import com.ivy.admin.vo.ppsg.GeneralWeaponVo;
import com.ivy.admin.entity.ppsg.GeneralWeapon;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ivy.admin.aspect.log.Log;
import java.util.List;

/**
 * 战器
 * @author: Administrator
 * @date: 2020-12-30
 */
@RestController
@RequestMapping("/ppsg/general/weapon")
public class GeneralWeaponController {

    @Autowired
    private GeneralWeaponService generalWeaponService;

    @Log("ppsg.GeneralWeapon")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(GeneralWeaponVo generalWeaponVo){
        Pagination<GeneralWeapon> pagination = generalWeaponService.selectPage(generalWeaponVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralWeapon")
    @GetMapping("/selectList")
    public ResultMsg selectList(GeneralWeaponVo generalWeaponVo){
        return ResultMsg.success(generalWeaponService.selectList(generalWeaponVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralWeapon")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(GeneralWeaponVo generalWeaponVo){
        return ResultMsg.success(generalWeaponService.selectOne(generalWeaponVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralWeapon")
    @PostMapping("/insert")
    public ResultMsg insert(@RequestBody GeneralWeapon generalWeapon){
        if(generalWeapon == null){
            return ResultMsg.failed();
        }
        int i = generalWeaponService.insert(generalWeapon);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralWeapon")
    @PostMapping("/update")
    public ResultMsg update(@RequestBody GeneralWeapon generalWeapon){
        if(generalWeapon == null || generalWeapon.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalWeaponService.update(generalWeapon);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralWeapon")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@RequestBody @PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalWeaponService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
