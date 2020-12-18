package com.ivy.admin.mapper.ivy;

import com.ivy.admin.vo.ivy.UserVo;
import com.ivy.admin.entity.ivy.User;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 用户表
 * @author: Administrator
 * @date: 2020-12-04
 */
@Mapper
public interface UserMapper {

    @TargetDataSource("dataSource1")
	int selectCount(UserVo userVo);

    @TargetDataSource("dataSource1")
	List<User> selectPage(UserVo userVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    @TargetDataSource("dataSource1")
    List<User> selectList(UserVo userVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    @TargetDataSource("dataSource1")
    User selectOne(UserVo userVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    @TargetDataSource("dataSource1")
    int insert(User user);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    @TargetDataSource("dataSource1")
    int update(User user);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-04
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
