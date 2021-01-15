package com.ivy.admin.mapper.ppsg;

import com.ivy.admin.vo.ppsg.GeneralThreeVo;
import com.ivy.admin.entity.ppsg.GeneralThree;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 武将三维
 * @author: Administrator
 * @date: 2020-12-30
 */
@Mapper
public interface GeneralThreeMapper {

    @TargetDataSource("dataSource1")
	int selectCount(GeneralThreeVo generalThreeVo);

    @TargetDataSource("dataSource1")
	List<GeneralThree> selectPage(GeneralThreeVo generalThreeVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    List<GeneralThree> selectList(GeneralThreeVo generalThreeVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    GeneralThree selectOne(GeneralThreeVo generalThreeVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int insert(GeneralThree generalThree);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int update(GeneralThree generalThree);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

	@TargetDataSource("dataSource1")
    int deleteByGeneralId(Long id);
}
