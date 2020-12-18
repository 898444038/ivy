package com.ivy.admin.controller.ivy;

import com.ivy.admin.vo.ivy.MenuVo;
import com.ivy.admin.service.ivy.MenuService;
import com.ivy.admin.entity.ivy.Menu;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ivy.admin.aspect.log.Log;
import java.util.List;

/**
 * 菜单表
 * @author: Administrator
 * @date: 2020-12-17
 */
@RestController
@RequestMapping("/ivy/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Log("ivy.Menu")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(MenuVo menuVo){
        Pagination<Menu> pagination = menuService.selectPage(menuVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    @Log("ivy.Menu")
    @GetMapping("/selectList")
    public ResultMsg selectList(MenuVo menuVo){
        return ResultMsg.success(menuService.selectList(menuVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    @Log("ivy.Menu")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(MenuVo menuVo){
        return ResultMsg.success(menuService.selectOne(menuVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    @Log("ivy.Menu")
    @PostMapping("/insert")
    public ResultMsg insert(Menu menu){
        if(menu == null){
            return ResultMsg.failed();
        }
        int i = menuService.insert(menu);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    @Log("ivy.Menu")
    @PostMapping("/update")
    public ResultMsg update(Menu menu){
        if(menu == null || menu.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = menuService.update(menu);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-17
	 */
    @Log("ivy.Menu")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = menuService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
