package com.ivy.admin.service.ivy;

import com.ivy.admin.vo.ivy.UserVo;
import com.ivy.admin.entity.ivy.User;

import com.ivy.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表
 * @author: Administrator
 * @date: 2020-12-04
 */
public interface UserService {

	Pagination<User> selectPage(UserVo userVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    List<User> selectList(UserVo userVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    User selectOne(UserVo userVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    int insert(User user);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    int update(User user);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    int delete(Long id);

}
