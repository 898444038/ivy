package com.ivy.admin.mapper.ivy;

import com.ivy.admin.vo.ivy.SystemLogVo;
import com.ivy.admin.entity.ivy.SystemLog;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 日志
 * @author: Administrator
 * @date: 2020-08-12
 */
@Mapper
public interface SystemLogMapper {

    @TargetDataSource("dataSource1")
	int selectCount(SystemLogVo systemLogVo);

    @TargetDataSource("dataSource1")
	List<SystemLog> selectPage(SystemLogVo systemLogVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @TargetDataSource("dataSource1")
    List<SystemLog> selectList(SystemLogVo systemLogVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @TargetDataSource("dataSource1")
    SystemLog selectOne(SystemLogVo systemLogVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @TargetDataSource("dataSource1")
    int insert(SystemLog systemLog);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @TargetDataSource("dataSource1")
    int update(SystemLog systemLog);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
