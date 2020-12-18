package com.ivy.admin.controller.monitor;

import com.ivy.admin.vo.monitor.MysqlStatusVo;
import com.ivy.admin.service.monitor.MysqlStatusService;
import com.ivy.admin.entity.monitor.MysqlStatus;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ivy.admin.aspect.log.Log;
import java.util.List;

/**
 * MySQL状态配置表
 * @author: Administrator
 * @date: 2020-10-09
 */
@RestController
@RequestMapping("/monitor/mysql/status")
public class MysqlStatusController {

    @Autowired
    private MysqlStatusService mysqlStatusService;

    @Log("monitor.MysqlStatus")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(MysqlStatusVo mysqlStatusVo){
        Pagination<MysqlStatus> pagination = mysqlStatusService.selectPage(mysqlStatusVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    @Log("monitor.MysqlStatus")
    @GetMapping("/selectList")
    public ResultMsg selectList(MysqlStatusVo mysqlStatusVo){
        return ResultMsg.success(mysqlStatusService.selectList(mysqlStatusVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    @Log("monitor.MysqlStatus")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(MysqlStatusVo mysqlStatusVo){
        return ResultMsg.success(mysqlStatusService.selectOne(mysqlStatusVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    @Log("monitor.MysqlStatus")
    @PostMapping("/insert")
    public ResultMsg insert(MysqlStatus mysqlStatus){
        if(mysqlStatus == null){
            return ResultMsg.failed();
        }
        int i = mysqlStatusService.insert(mysqlStatus);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    @Log("monitor.MysqlStatus")
    @PostMapping("/update")
    public ResultMsg update(MysqlStatus mysqlStatus){
        if(mysqlStatus == null || mysqlStatus.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = mysqlStatusService.update(mysqlStatus);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    @Log("monitor.MysqlStatus")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = mysqlStatusService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
