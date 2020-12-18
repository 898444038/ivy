package com.ivy.admin.controller.ivy;

import com.ivy.admin.vo.ivy.UserVo;
import com.ivy.admin.entity.ivy.User;
import com.ivy.admin.service.ivy.UserService;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ivy.admin.aspect.log.Log;
import java.util.List;

/**
 * 用户表
 * @author: Administrator
 * @date: 2020-12-04
 */
@RestController
@RequestMapping("/ivy/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Log("ivy.User")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(UserVo userVo){
        Pagination<User> pagination = userService.selectPage(userVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    @Log("ivy.User")
    @GetMapping("/selectList")
    public ResultMsg selectList(UserVo userVo){
        return ResultMsg.success(userService.selectList(userVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    @Log("ivy.User")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(UserVo userVo){
        return ResultMsg.success(userService.selectOne(userVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    @Log("ivy.User")
    @PostMapping("/insert")
    public ResultMsg insert(User user){
        if(user == null){
            return ResultMsg.failed();
        }
        int i = userService.insert(user);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    @Log("ivy.User")
    @PostMapping("/update")
    public ResultMsg update(User user){
        if(user == null || user.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = userService.update(user);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    @Log("ivy.User")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = userService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
