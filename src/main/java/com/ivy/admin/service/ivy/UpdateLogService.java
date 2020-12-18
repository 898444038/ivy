package com.ivy.admin.service.ivy;

import com.ivy.admin.vo.ivy.UpdateLogVo;
import com.ivy.admin.entity.ivy.UpdateLog;

import com.ivy.admin.utils.Pagination;

import java.util.List;

/**
 * 更新日志
 * @author: Administrator
 * @date: 2020-08-26
 */
public interface UpdateLogService {

	Pagination<UpdateLog> selectPage(UpdateLogVo updateLogVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    List<UpdateLog> selectList(UpdateLogVo updateLogVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    UpdateLog selectOne(UpdateLogVo updateLogVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    int insert(UpdateLog updateLog);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    int update(UpdateLog updateLog);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    int delete(Long id);

}
