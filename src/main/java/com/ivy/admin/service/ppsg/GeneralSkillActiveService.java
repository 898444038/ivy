package com.ivy.admin.service.ppsg;

import com.ivy.admin.entity.ppsg.GeneralSkillActive;
import com.ivy.admin.vo.ppsg.GeneralSkillActiveVo;

import com.ivy.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 主动技能
 * @author: Administrator
 * @date: 2020-12-30
 */
public interface GeneralSkillActiveService {

	Pagination<GeneralSkillActive> selectPage(GeneralSkillActiveVo generalSkillActiveVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    List<GeneralSkillActive> selectList(GeneralSkillActiveVo generalSkillActiveVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    GeneralSkillActive selectOne(GeneralSkillActiveVo generalSkillActiveVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int insert(GeneralSkillActive generalSkillActive);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int update(GeneralSkillActive generalSkillActive);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int delete(Long id);

}
