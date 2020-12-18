package com.ivy.admin.service.ivy;

import com.ivy.admin.vo.ivy.StatisticsVo;
import com.ivy.admin.entity.ivy.Statistics;

import com.ivy.admin.utils.Pagination;

import java.util.List;

/**
 * 统计
 * @author: Administrator
 * @date: 2020-08-12
 */
public interface StatisticsService {

	Pagination<Statistics> selectPage(StatisticsVo statisticsVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    List<Statistics> selectList(StatisticsVo statisticsVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    Statistics selectOne(StatisticsVo statisticsVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    int insert(Statistics statistics);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    int update(Statistics statistics);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    int delete(Long id);

}
