package com.ivy.admin.mapper.ivy;

import com.ivy.admin.vo.ivy.StatisticsItemVo;
import com.ivy.admin.entity.ivy.StatisticsItem;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 统计项
 * @author: Administrator
 * @date: 2020-08-12
 */
@Mapper
public interface StatisticsItemMapper {

    @TargetDataSource("dataSource1")
	int selectCount(StatisticsItemVo statisticsItemVo);

    @TargetDataSource("dataSource1")
	List<StatisticsItem> selectPage(StatisticsItemVo statisticsItemVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @TargetDataSource("dataSource1")
    List<StatisticsItem> selectList(StatisticsItemVo statisticsItemVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @TargetDataSource("dataSource1")
    StatisticsItem selectOne(StatisticsItemVo statisticsItemVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @TargetDataSource("dataSource1")
    int insert(StatisticsItem statisticsItem);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @TargetDataSource("dataSource1")
    int update(StatisticsItem statisticsItem);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
