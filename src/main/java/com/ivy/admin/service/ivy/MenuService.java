package com.ivy.admin.service.ivy;

import com.ivy.admin.vo.ivy.MenuVo;
import com.ivy.admin.entity.ivy.Menu;

import com.ivy.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单表
 * @author: Administrator
 * @date: 2020-12-17
 */
public interface MenuService {

	Pagination<Menu> selectPage(MenuVo menuVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    List<Menu> selectList(MenuVo menuVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    Menu selectOne(MenuVo menuVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    int insert(Menu menu);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    int update(Menu menu);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    int delete(Long id);

}
