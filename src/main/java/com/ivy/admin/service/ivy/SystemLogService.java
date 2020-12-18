package com.ivy.admin.service.ivy;

import com.ivy.admin.vo.ivy.SystemLogVo;
import com.ivy.admin.entity.ivy.SystemLog;

import com.ivy.admin.utils.Pagination;

import java.util.List;

/**
 * 日志
 * @author: Administrator
 * @date: 2020-08-12
 */
public interface SystemLogService {

	Pagination<SystemLog> selectPage(SystemLogVo systemLogVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    List<SystemLog> selectList(SystemLogVo systemLogVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    SystemLog selectOne(SystemLogVo systemLogVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    int insert(SystemLog systemLog);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    int update(SystemLog systemLog);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    int delete(Long id);

}
