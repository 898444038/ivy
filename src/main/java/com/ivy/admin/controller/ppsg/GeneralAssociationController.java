package com.ivy.admin.controller.ppsg;

import com.ivy.admin.entity.ppsg.GeneralAssociation;
import com.ivy.admin.service.ppsg.GeneralAssociationService;
import com.ivy.admin.vo.ppsg.GeneralAssociationVo;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ivy.admin.aspect.log.Log;
import java.util.List;

/**
 * 联协
 * @author: Administrator
 * @date: 2020-12-30
 */
@RestController
@RequestMapping("/ppsg/general/association")
public class GeneralAssociationController {

    @Autowired
    private GeneralAssociationService generalAssociationService;

    @Log("ppsg.GeneralAssociation")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(GeneralAssociationVo generalAssociationVo){
        Pagination<GeneralAssociation> pagination = generalAssociationService.selectPage(generalAssociationVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralAssociation")
    @GetMapping("/selectList")
    public ResultMsg selectList(GeneralAssociationVo generalAssociationVo){
        return ResultMsg.success(generalAssociationService.selectList(generalAssociationVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralAssociation")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(GeneralAssociationVo generalAssociationVo){
        return ResultMsg.success(generalAssociationService.selectOne(generalAssociationVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralAssociation")
    @PostMapping("/insert")
    public ResultMsg insert(@RequestBody GeneralAssociation generalAssociation){
        if(generalAssociation == null){
            return ResultMsg.failed();
        }
        int i = generalAssociationService.insert(generalAssociation);
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
    @Log("ppsg.GeneralAssociation")
    @PostMapping("/update")
    public ResultMsg update(@RequestBody GeneralAssociation generalAssociation){
        if(generalAssociation == null || generalAssociation.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalAssociationService.update(generalAssociation);
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
    @Log("ppsg.GeneralAssociation")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@RequestBody @PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalAssociationService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
