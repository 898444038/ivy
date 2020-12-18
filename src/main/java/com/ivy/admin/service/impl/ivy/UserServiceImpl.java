package com.ivy.admin.service.impl.ivy;

import com.ivy.admin.vo.ivy.UserVo;
import com.ivy.admin.entity.ivy.User;
import com.ivy.admin.mapper.ivy.UserMapper;
import com.ivy.admin.service.ivy.UserService;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表
 * @author: Administrator
 * @date: 2020-12-04
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

	@Override
	public Pagination<User> selectPage(UserVo userVo) {
        Pagination<User> pagination = new Pagination<>();
        int count = userMapper.selectCount(userVo);
        List<User> list = userMapper.selectPage(userVo);
        pagination.setPageNo(userVo.getPageNo());
        pagination.setPageSize(userVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    @Override
    public List<User> selectList(UserVo userVo) {
        return userMapper.selectList(userVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    @Override
    public User selectOne(UserVo userVo) {
        return userMapper.selectOne(userVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    @Override
    public int delete(Long id) {
        return userMapper.delete(id);
    }
}
