package com.ivy.admin.mapper.monitor;

import com.ivy.admin.vo.monitor.MysqlStatusVo;
import com.ivy.admin.entity.monitor.MysqlStatus;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * MySQL状态配置表
 * @author: Administrator
 * @date: 2020-10-09
 */
@Mapper
public interface MysqlStatusMapper {

    @TargetDataSource("dataSource1")
	int selectCount(MysqlStatusVo mysqlStatusVo);

    @TargetDataSource("dataSource1")
	List<MysqlStatus> selectPage(MysqlStatusVo mysqlStatusVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    @TargetDataSource("dataSource1")
    List<MysqlStatus> selectList(MysqlStatusVo mysqlStatusVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    @TargetDataSource("dataSource1")
    MysqlStatus selectOne(MysqlStatusVo mysqlStatusVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    @TargetDataSource("dataSource1")
    int insert(MysqlStatus mysqlStatus);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    @TargetDataSource("dataSource1")
    int update(MysqlStatus mysqlStatus);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
