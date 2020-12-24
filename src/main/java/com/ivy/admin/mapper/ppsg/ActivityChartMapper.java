package com.ivy.admin.mapper.ppsg;

import com.ivy.admin.vo.ppsg.ActivityChartVo;
import com.ivy.admin.entity.ppsg.ActivityChart;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 活动图
 * @author: Administrator
 * @date: 2020-12-24
 */
@Mapper
public interface ActivityChartMapper {

    @TargetDataSource("dataSource1")
	int selectCount(ActivityChartVo activityChartVo);

    @TargetDataSource("dataSource1")
	List<ActivityChart> selectPage(ActivityChartVo activityChartVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    @TargetDataSource("dataSource1")
    List<ActivityChart> selectList(ActivityChartVo activityChartVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    @TargetDataSource("dataSource1")
    ActivityChart selectOne(ActivityChartVo activityChartVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    @TargetDataSource("dataSource1")
    int insert(ActivityChart activityChart);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    @TargetDataSource("dataSource1")
    int update(ActivityChart activityChart);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
