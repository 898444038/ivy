package com.ivy.admin.service.ppsg;

import com.ivy.admin.vo.ppsg.ActivityChartVo;
import com.ivy.admin.entity.ppsg.ActivityChart;

import com.ivy.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 活动图
 * @author: Administrator
 * @date: 2020-12-24
 */
public interface ActivityChartService {

	Pagination<ActivityChart> selectPage(ActivityChartVo activityChartVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    List<ActivityChart> selectList(ActivityChartVo activityChartVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    ActivityChart selectOne(ActivityChartVo activityChartVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    int insert(ActivityChart activityChart);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    int update(ActivityChart activityChart);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    int delete(Long id);

}
