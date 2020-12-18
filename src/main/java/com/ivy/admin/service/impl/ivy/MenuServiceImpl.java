package com.ivy.admin.service.impl.ivy;

import com.ivy.admin.vo.ivy.MenuVo;
import com.ivy.admin.service.ivy.MenuService;
import com.ivy.admin.entity.ivy.Menu;
import com.ivy.admin.mapper.ivy.MenuMapper;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单表
 * @author: Administrator
 * @date: 2020-12-17
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

	@Override
	public Pagination<Menu> selectPage(MenuVo menuVo) {
        Pagination<Menu> pagination = new Pagination<>();
        int count = menuMapper.selectCount(menuVo);
        List<Menu> list = menuMapper.selectPage(menuVo);
        pagination.setPageNo(menuVo.getPageNo());
        pagination.setPageSize(menuVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    @Override
    public List<Menu> selectList(MenuVo menuVo) {
        return menuMapper.selectList(menuVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    @Override
    public Menu selectOne(MenuVo menuVo) {
        return menuMapper.selectOne(menuVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    @Override
    public int insert(Menu menu) {
        return menuMapper.insert(menu);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    @Override
    public int update(Menu menu) {
        return menuMapper.update(menu);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    @Override
    public int delete(Long id) {
        return menuMapper.delete(id);
    }
}
