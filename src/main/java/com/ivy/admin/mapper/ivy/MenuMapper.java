package com.ivy.admin.mapper.ivy;

import com.ivy.admin.vo.ivy.MenuVo;
import com.ivy.admin.entity.ivy.Menu;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 菜单表
 * @author: Administrator
 * @date: 2020-12-17
 */
@Mapper
public interface MenuMapper {

    @TargetDataSource("dataSource1")
	int selectCount(MenuVo menuVo);

    @TargetDataSource("dataSource1")
	List<Menu> selectPage(MenuVo menuVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    @TargetDataSource("dataSource1")
    List<Menu> selectList(MenuVo menuVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    @TargetDataSource("dataSource1")
    Menu selectOne(MenuVo menuVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    @TargetDataSource("dataSource1")
    int insert(Menu menu);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    @TargetDataSource("dataSource1")
    int update(Menu menu);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
