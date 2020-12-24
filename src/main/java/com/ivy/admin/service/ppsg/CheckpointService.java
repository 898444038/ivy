package com.ivy.admin.service.ppsg;

import com.ivy.admin.vo.ppsg.CheckpointVo;
import com.ivy.admin.entity.ppsg.Checkpoint;

import com.ivy.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 关卡表
 * @author: Administrator
 * @date: 2020-12-22
 */
public interface CheckpointService {

	Pagination<Checkpoint> selectPage(CheckpointVo checkpointVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    List<Checkpoint> selectList(CheckpointVo checkpointVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    Checkpoint selectOne(CheckpointVo checkpointVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    int insert(Checkpoint checkpoint);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    int update(Checkpoint checkpoint);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    int delete(Long id);

}
