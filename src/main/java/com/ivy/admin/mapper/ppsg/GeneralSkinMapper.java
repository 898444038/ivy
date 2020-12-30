package com.ivy.admin.mapper.ppsg;

import com.ivy.admin.entity.ppsg.GeneralSkin;
import com.ivy.admin.vo.ppsg.GeneralSkinVo;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 幻化
 * @author: Administrator
 * @date: 2020-12-30
 */
@Mapper
public interface GeneralSkinMapper {

    @TargetDataSource("dataSource1")
	int selectCount(GeneralSkinVo generalSkinVo);

    @TargetDataSource("dataSource1")
	List<GeneralSkin> selectPage(GeneralSkinVo generalSkinVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    List<GeneralSkin> selectList(GeneralSkinVo generalSkinVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    GeneralSkin selectOne(GeneralSkinVo generalSkinVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int insert(GeneralSkin generalSkin);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int update(GeneralSkin generalSkin);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
