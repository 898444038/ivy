package com.ivy.admin.mapper.ppsg;

import com.ivy.admin.vo.ppsg.GeneralSkillPassiveVo;
import com.ivy.admin.entity.ppsg.GeneralSkillPassive;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 被动技能
 * @author: Administrator
 * @date: 2020-12-30
 */
@Mapper
public interface GeneralSkillPassiveMapper {

    @TargetDataSource("dataSource1")
	int selectCount(GeneralSkillPassiveVo generalSkillPassiveVo);

    @TargetDataSource("dataSource1")
	List<GeneralSkillPassive> selectPage(GeneralSkillPassiveVo generalSkillPassiveVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    List<GeneralSkillPassive> selectList(GeneralSkillPassiveVo generalSkillPassiveVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    GeneralSkillPassive selectOne(GeneralSkillPassiveVo generalSkillPassiveVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int insert(GeneralSkillPassive generalSkillPassive);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int update(GeneralSkillPassive generalSkillPassive);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
