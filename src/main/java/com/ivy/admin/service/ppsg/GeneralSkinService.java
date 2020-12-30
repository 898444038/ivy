package com.ivy.admin.service.ppsg;

import com.ivy.admin.entity.ppsg.GeneralSkin;
import com.ivy.admin.vo.ppsg.GeneralSkinVo;

import com.ivy.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 幻化
 * @author: Administrator
 * @date: 2020-12-30
 */
public interface GeneralSkinService {

	Pagination<GeneralSkin> selectPage(GeneralSkinVo generalSkinVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    List<GeneralSkin> selectList(GeneralSkinVo generalSkinVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    GeneralSkin selectOne(GeneralSkinVo generalSkinVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int insert(GeneralSkin generalSkin);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int update(GeneralSkin generalSkin);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int delete(Long id);

}
