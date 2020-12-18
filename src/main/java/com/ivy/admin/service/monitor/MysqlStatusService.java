package com.ivy.admin.service.monitor;

import com.ivy.admin.vo.monitor.MysqlStatusVo;
import com.ivy.admin.entity.monitor.MysqlStatus;

import com.ivy.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MySQL状态配置表
 * @author: Administrator
 * @date: 2020-10-09
 */
public interface MysqlStatusService {

	Pagination<MysqlStatus> selectPage(MysqlStatusVo mysqlStatusVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    List<MysqlStatus> selectList(MysqlStatusVo mysqlStatusVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    MysqlStatus selectOne(MysqlStatusVo mysqlStatusVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    int insert(MysqlStatus mysqlStatus);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    int update(MysqlStatus mysqlStatus);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    int delete(Long id);

}
