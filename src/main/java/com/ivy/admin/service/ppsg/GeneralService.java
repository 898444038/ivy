package com.ivy.admin.service.ppsg;

import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.vo.ppsg.GeneralVo;

import com.ivy.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 武将
 * @author: Administrator
 * @date: 2020-12-30
 */
public interface GeneralService {

	Pagination<General> selectPage(GeneralVo generalVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    List<General> selectList(GeneralVo generalVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    General selectOne(GeneralVo generalVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int insert(General general);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int update(General general);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int delete(Long id);

}
