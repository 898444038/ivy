package com.ivy.admin.mapper.ivy;

import com.ivy.admin.vo.ivy.ConfigVo;
import com.ivy.admin.entity.ivy.Config;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 配置表
 * @author: Administrator
 * @date: 2020-08-25
 */
@Mapper
public interface ConfigMapper {

    @TargetDataSource("dataSource1")
	int selectCount(ConfigVo configVo);

    @TargetDataSource("dataSource1")
	List<Config> selectPage(ConfigVo configVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @TargetDataSource("dataSource1")
    List<Config> selectList(ConfigVo configVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @TargetDataSource("dataSource1")
    Config selectOne(ConfigVo configVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @TargetDataSource("dataSource1")
    int insert(Config config);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @TargetDataSource("dataSource1")
    int update(Config config);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
