package com.ivy.admin.mapper.ppsg;

import com.ivy.admin.vo.ppsg.CheckpointVo;
import com.ivy.admin.entity.ppsg.Checkpoint;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 关卡表
 * @author: Administrator
 * @date: 2020-12-22
 */
@Mapper
public interface CheckpointMapper {

    @TargetDataSource("dataSource1")
	int selectCount(CheckpointVo checkpointVo);

    @TargetDataSource("dataSource1")
	List<Checkpoint> selectPage(CheckpointVo checkpointVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    @TargetDataSource("dataSource1")
    List<Checkpoint> selectList(CheckpointVo checkpointVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    @TargetDataSource("dataSource1")
    Checkpoint selectOne(CheckpointVo checkpointVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    @TargetDataSource("dataSource1")
    int insert(Checkpoint checkpoint);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    @TargetDataSource("dataSource1")
    int update(Checkpoint checkpoint);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
