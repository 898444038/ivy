package com.ivy.admin.mapper.ivy;

import com.ivy.admin.vo.ivy.StatisticsVo;
import com.ivy.admin.entity.ivy.Statistics;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 统计
 * @author: Administrator
 * @date: 2020-08-12
 */
@Mapper
public interface StatisticsMapper {

    @TargetDataSource("dataSource1")
	int selectCount(StatisticsVo statisticsVo);

    @TargetDataSource("dataSource1")
	List<Statistics> selectPage(StatisticsVo statisticsVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @TargetDataSource("dataSource1")
    List<Statistics> selectList(StatisticsVo statisticsVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @TargetDataSource("dataSource1")
    Statistics selectOne(StatisticsVo statisticsVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @TargetDataSource("dataSource1")
    int insert(Statistics statistics);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @TargetDataSource("dataSource1")
    int update(Statistics statistics);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
