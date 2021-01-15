package com.ivy.admin.mapper.ppsg;

import com.ivy.admin.vo.ppsg.GeneralArmsBookVo;
import com.ivy.admin.entity.ppsg.GeneralArmsBook;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 兵书
 * @author: Administrator
 * @date: 2020-12-30
 */
@Mapper
public interface GeneralArmsBookMapper {

    @TargetDataSource("dataSource1")
	int selectCount(GeneralArmsBookVo generalArmsBookVo);

    @TargetDataSource("dataSource1")
	List<GeneralArmsBook> selectPage(GeneralArmsBookVo generalArmsBookVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    List<GeneralArmsBook> selectList(GeneralArmsBookVo generalArmsBookVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    GeneralArmsBook selectOne(GeneralArmsBookVo generalArmsBookVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int insert(GeneralArmsBook generalArmsBook);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int update(GeneralArmsBook generalArmsBook);

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
