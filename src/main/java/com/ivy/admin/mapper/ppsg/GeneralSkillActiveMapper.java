package com.ivy.admin.mapper.ppsg;

import com.ivy.admin.entity.ppsg.GeneralSkillActive;
import com.ivy.admin.vo.ppsg.GeneralSkillActiveVo;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 主动技能
 * @author: Administrator
 * @date: 2020-12-30
 */
@Mapper
public interface GeneralSkillActiveMapper {

    @TargetDataSource("dataSource1")
	int selectCount(GeneralSkillActiveVo generalSkillActiveVo);

    @TargetDataSource("dataSource1")
	List<GeneralSkillActive> selectPage(GeneralSkillActiveVo generalSkillActiveVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    List<GeneralSkillActive> selectList(GeneralSkillActiveVo generalSkillActiveVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    GeneralSkillActive selectOne(GeneralSkillActiveVo generalSkillActiveVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int insert(GeneralSkillActive generalSkillActive);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int update(GeneralSkillActive generalSkillActive);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
