package com.ivy.admin.controller.ppsg;

import com.ivy.admin.service.ppsg.GeneralSkillActiveService;
import com.ivy.admin.entity.ppsg.GeneralSkillActive;
import com.ivy.admin.vo.ppsg.GeneralSkillActiveVo;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ivy.admin.aspect.log.Log;
import java.util.List;

/**
 * 主动技能
 * @author: Administrator
 * @date: 2020-12-30
 */
@RestController
@RequestMapping("/ppsg/general/skill/active")
public class GeneralSkillActiveController {

    @Autowired
    private GeneralSkillActiveService generalSkillActiveService;

    @Log("ppsg.GeneralSkillActive")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(GeneralSkillActiveVo generalSkillActiveVo){
        Pagination<GeneralSkillActive> pagination = generalSkillActiveService.selectPage(generalSkillActiveVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralSkillActive")
    @GetMapping("/selectList")
    public ResultMsg selectList(GeneralSkillActiveVo generalSkillActiveVo){
        return ResultMsg.success(generalSkillActiveService.selectList(generalSkillActiveVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralSkillActive")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(GeneralSkillActiveVo generalSkillActiveVo){
        return ResultMsg.success(generalSkillActiveService.selectOne(generalSkillActiveVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralSkillActive")
    @PostMapping("/insert")
    public ResultMsg insert(@RequestBody GeneralSkillActive generalSkillActive){
        if(generalSkillActive == null){
            return ResultMsg.failed();
        }
        int i = generalSkillActiveService.insert(generalSkillActive);
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
    @Log("ppsg.GeneralSkillActive")
    @PostMapping("/update")
    public ResultMsg update(@RequestBody GeneralSkillActive generalSkillActive){
        if(generalSkillActive == null || generalSkillActive.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalSkillActiveService.update(generalSkillActive);
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
    @Log("ppsg.GeneralSkillActive")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@RequestBody @PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalSkillActiveService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
