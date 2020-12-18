package com.ivy.admin.service.ivy;

import com.ivy.admin.vo.ivy.StatisticsItemVo;
import com.ivy.admin.entity.ivy.StatisticsItem;

import com.ivy.admin.utils.Pagination;

import java.util.List;

/**
 * 统计项
 * @author: Administrator
 * @date: 2020-08-12
 */
public interface StatisticsItemService {

	Pagination<StatisticsItem> selectPage(StatisticsItemVo statisticsItemVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    List<StatisticsItem> selectList(StatisticsItemVo statisticsItemVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    StatisticsItem selectOne(StatisticsItemVo statisticsItemVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    int insert(StatisticsItem statisticsItem);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    int update(StatisticsItem statisticsItem);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    int delete(Long id);

}
