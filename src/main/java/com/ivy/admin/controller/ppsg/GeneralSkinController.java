package com.ivy.admin.controller.ppsg;

import com.ivy.admin.entity.ppsg.GeneralSkin;
import com.ivy.admin.vo.ppsg.GeneralSkinVo;
import com.ivy.admin.service.ppsg.GeneralSkinService;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ivy.admin.aspect.log.Log;
import java.util.List;

/**
 * 幻化
 * @author: Administrator
 * @date: 2020-12-30
 */
@RestController
@RequestMapping("/ppsg/general/skin")
public class GeneralSkinController {

    @Autowired
    private GeneralSkinService generalSkinService;

    @Log("ppsg.GeneralSkin")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(GeneralSkinVo generalSkinVo){
        Pagination<GeneralSkin> pagination = generalSkinService.selectPage(generalSkinVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralSkin")
    @GetMapping("/selectList")
    public ResultMsg selectList(GeneralSkinVo generalSkinVo){
        return ResultMsg.success(generalSkinService.selectList(generalSkinVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralSkin")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(GeneralSkinVo generalSkinVo){
        return ResultMsg.success(generalSkinService.selectOne(generalSkinVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralSkin")
    @PostMapping("/insert")
    public ResultMsg insert(@RequestBody GeneralSkin generalSkin){
        if(generalSkin == null){
            return ResultMsg.failed();
        }
        int i = generalSkinService.insert(generalSkin);
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
    @Log("ppsg.GeneralSkin")
    @PostMapping("/update")
    public ResultMsg update(@RequestBody GeneralSkin generalSkin){
        if(generalSkin == null || generalSkin.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalSkinService.update(generalSkin);
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
    @Log("ppsg.GeneralSkin")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@RequestBody @PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalSkinService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
