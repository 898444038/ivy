package com.ivy.admin.mapper.ppsg;

import com.ivy.admin.vo.ppsg.GeneralVo;
import com.ivy.admin.entity.ppsg.General;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 武将
 * @author: Administrator
 * @date: 2020-12-30
 */
@Mapper
public interface GeneralMapper {

    @TargetDataSource("dataSource1")
	int selectCount(GeneralVo generalVo);

    @TargetDataSource("dataSource1")
	List<General> selectPage(GeneralVo generalVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    List<General> selectList(GeneralVo generalVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    General selectOne(GeneralVo generalVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int insert(General general);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int update(General general);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
