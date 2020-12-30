package com.ivy.admin.controller.ppsg;

import com.ivy.admin.vo.ppsg.GeneralThreeVo;
import com.ivy.admin.service.ppsg.GeneralThreeService;
import com.ivy.admin.entity.ppsg.GeneralThree;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ivy.admin.aspect.log.Log;
import java.util.List;

/**
 * 武将三维
 * @author: Administrator
 * @date: 2020-12-30
 */
@RestController
@RequestMapping("/ppsg/general/three")
public class GeneralThreeController {

    @Autowired
    private GeneralThreeService generalThreeService;

    @Log("ppsg.GeneralThree")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(GeneralThreeVo generalThreeVo){
        Pagination<GeneralThree> pagination = generalThreeService.selectPage(generalThreeVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralThree")
    @GetMapping("/selectList")
    public ResultMsg selectList(GeneralThreeVo generalThreeVo){
        return ResultMsg.success(generalThreeService.selectList(generalThreeVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralThree")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(GeneralThreeVo generalThreeVo){
        return ResultMsg.success(generalThreeService.selectOne(generalThreeVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralThree")
    @PostMapping("/insert")
    public ResultMsg insert(@RequestBody GeneralThree generalThree){
        if(generalThree == null){
            return ResultMsg.failed();
        }
        int i = generalThreeService.insert(generalThree);
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
    @Log("ppsg.GeneralThree")
    @PostMapping("/update")
    public ResultMsg update(@RequestBody GeneralThree generalThree){
        if(generalThree == null || generalThree.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalThreeService.update(generalThree);
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
    @Log("ppsg.GeneralThree")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@RequestBody @PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalThreeService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
