package com.ivy.admin.service.ppsg;

import com.ivy.admin.vo.ppsg.GeneralSkillPassiveVo;
import com.ivy.admin.entity.ppsg.GeneralSkillPassive;

import com.ivy.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 被动技能
 * @author: Administrator
 * @date: 2020-12-30
 */
public interface GeneralSkillPassiveService {

	Pagination<GeneralSkillPassive> selectPage(GeneralSkillPassiveVo generalSkillPassiveVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    List<GeneralSkillPassive> selectList(GeneralSkillPassiveVo generalSkillPassiveVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    GeneralSkillPassive selectOne(GeneralSkillPassiveVo generalSkillPassiveVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int insert(GeneralSkillPassive generalSkillPassive);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int update(GeneralSkillPassive generalSkillPassive);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int delete(Long id);

}
