package com.ivy.admin.controller.ppsg;

import com.ivy.admin.service.ppsg.ActivityChartService;
import com.ivy.admin.vo.ppsg.ActivityChartVo;
import com.ivy.admin.entity.ppsg.ActivityChart;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ivy.admin.aspect.log.Log;

import java.util.Date;
import java.util.List;

/**
 * 活动图
 * @author: Administrator
 * @date: 2020-12-24
 */
@RestController
@RequestMapping("/ppsg/activity/chart")
public class ActivityChartController {

    @Autowired
    private ActivityChartService activityChartService;

    @Log("ppsg.ActivityChart")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(ActivityChartVo activityChartVo){
        Pagination<ActivityChart> pagination = activityChartService.selectPage(activityChartVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    @Log("ppsg.ActivityChart")
    @GetMapping("/selectList")
    public ResultMsg selectList(ActivityChartVo activityChartVo){
        return ResultMsg.success(activityChartService.selectList(activityChartVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    @Log("ppsg.ActivityChart")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(ActivityChartVo activityChartVo){
        return ResultMsg.success(activityChartService.selectOne(activityChartVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    @Log("ppsg.ActivityChart")
    @PostMapping("/insert")
    public ResultMsg insert(@RequestBody ActivityChart activityChart){
        if(activityChart == null || StringUtils.isBlank(activityChart.getUrl())){
            return ResultMsg.failed();
        }
        activityChart.setTitle("活动图"+ DateFormatUtils.format(new Date(),"yyyyMMdd"));
        activityChart.setCreateTime(new Date());
        activityChart.setDelFlag(true);
        int i = activityChartService.insert(activityChart);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    @Log("ppsg.ActivityChart")
    @PostMapping("/update")
    public ResultMsg update(ActivityChart activityChart){
        if(activityChart == null || activityChart.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = activityChartService.update(activityChart);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    @Log("ppsg.ActivityChart")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = activityChartService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
