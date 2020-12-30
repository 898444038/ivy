package com.ivy.admin.controller.ppsg;

import com.ivy.admin.service.ppsg.GeneralService;
import com.ivy.admin.vo.ppsg.GeneralVo;
import com.ivy.admin.entity.ppsg.General;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ivy.admin.aspect.log.Log;
import java.util.List;

/**
 * 武将
 * @author: Administrator
 * @date: 2020-12-30
 */
@RestController
@RequestMapping("/ppsg/general")
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    @Log("ppsg.General")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(GeneralVo generalVo){
        Pagination<General> pagination = generalService.selectPage(generalVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.General")
    @GetMapping("/selectList")
    public ResultMsg selectList(GeneralVo generalVo){
        return ResultMsg.success(generalService.selectList(generalVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.General")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(GeneralVo generalVo){
        return ResultMsg.success(generalService.selectOne(generalVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.General")
    @PostMapping("/insert")
    public ResultMsg insert(@RequestBody General general){
        if(general == null){
            return ResultMsg.failed();
        }
        int i = generalService.insert(general);
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
    @Log("ppsg.General")
    @PostMapping("/update")
    public ResultMsg update(@RequestBody General general){
        if(general == null || general.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalService.update(general);
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
    @Log("ppsg.General")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@RequestBody @PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
