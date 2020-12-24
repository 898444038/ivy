package com.ivy.admin.controller.ppsg;

import com.ivy.admin.service.ppsg.CheckpointService;
import com.ivy.admin.utils.CacheUtil;
import com.ivy.admin.vo.ppsg.CheckpointVo;
import com.ivy.admin.entity.ppsg.Checkpoint;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ivy.admin.aspect.log.Log;
import java.util.List;

/**
 * 关卡表
 * @author: Administrator
 * @date: 2020-12-22
 */
@RestController
@RequestMapping("/ppsg/checkpoint")
public class CheckpointController {

    @Autowired
    private CheckpointService checkpointService;

    @Log("ppsg.Checkpoint")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(CheckpointVo checkpointVo){
        Pagination<Checkpoint> pagination = checkpointService.selectPage(checkpointVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    @Log("ppsg.Checkpoint")
    @GetMapping("/selectList")
    public ResultMsg selectList(CheckpointVo checkpointVo){
        List<Checkpoint> list = CacheUtil.get("Checkpoint_list");
        if(list == null){
            list = checkpointService.selectList(checkpointVo);
            CacheUtil.set("Checkpoint_list",list,24*60*60*1000);
        }
        return ResultMsg.success(list);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    @Log("ppsg.Checkpoint")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(CheckpointVo checkpointVo){
        return ResultMsg.success(checkpointService.selectOne(checkpointVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    @Log("ppsg.Checkpoint")
    @PostMapping("/insert")
    public ResultMsg insert(Checkpoint checkpoint){
        if(checkpoint == null){
            return ResultMsg.failed();
        }
        int i = checkpointService.insert(checkpoint);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    @Log("ppsg.Checkpoint")
    @PostMapping("/update")
    public ResultMsg update(Checkpoint checkpoint){
        if(checkpoint == null || checkpoint.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = checkpointService.update(checkpoint);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    @Log("ppsg.Checkpoint")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = checkpointService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
