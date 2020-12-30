package com.ivy.admin.controller.ppsg;

import com.ivy.admin.vo.ppsg.GeneralSkillPassiveVo;
import com.ivy.admin.service.ppsg.GeneralSkillPassiveService;
import com.ivy.admin.entity.ppsg.GeneralSkillPassive;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ivy.admin.aspect.log.Log;
import java.util.List;

/**
 * 被动技能
 * @author: Administrator
 * @date: 2020-12-30
 */
@RestController
@RequestMapping("/ppsg/general/skill/passive")
public class GeneralSkillPassiveController {

    @Autowired
    private GeneralSkillPassiveService generalSkillPassiveService;

    @Log("ppsg.GeneralSkillPassive")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(GeneralSkillPassiveVo generalSkillPassiveVo){
        Pagination<GeneralSkillPassive> pagination = generalSkillPassiveService.selectPage(generalSkillPassiveVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralSkillPassive")
    @GetMapping("/selectList")
    public ResultMsg selectList(GeneralSkillPassiveVo generalSkillPassiveVo){
        return ResultMsg.success(generalSkillPassiveService.selectList(generalSkillPassiveVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralSkillPassive")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(GeneralSkillPassiveVo generalSkillPassiveVo){
        return ResultMsg.success(generalSkillPassiveService.selectOne(generalSkillPassiveVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralSkillPassive")
    @PostMapping("/insert")
    public ResultMsg insert(@RequestBody GeneralSkillPassive generalSkillPassive){
        if(generalSkillPassive == null){
            return ResultMsg.failed();
        }
        int i = generalSkillPassiveService.insert(generalSkillPassive);
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
    @Log("ppsg.GeneralSkillPassive")
    @PostMapping("/update")
    public ResultMsg update(@RequestBody GeneralSkillPassive generalSkillPassive){
        if(generalSkillPassive == null || generalSkillPassive.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalSkillPassiveService.update(generalSkillPassive);
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
    @Log("ppsg.GeneralSkillPassive")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@RequestBody @PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalSkillPassiveService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
