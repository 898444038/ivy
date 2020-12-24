package com.ivy.admin.service.impl.ppsg;

import com.ivy.admin.service.ppsg.CheckpointService;
import com.ivy.admin.mapper.ppsg.CheckpointMapper;
import com.ivy.admin.vo.ppsg.CheckpointVo;
import com.ivy.admin.entity.ppsg.Checkpoint;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 关卡表
 * @author: Administrator
 * @date: 2020-12-22
 */
@Service
public class CheckpointServiceImpl implements CheckpointService {

    @Resource
    private CheckpointMapper checkpointMapper;

	@Override
	public Pagination<Checkpoint> selectPage(CheckpointVo checkpointVo) {
        Pagination<Checkpoint> pagination = new Pagination<>();
        int count = checkpointMapper.selectCount(checkpointVo);
        List<Checkpoint> list = checkpointMapper.selectPage(checkpointVo);
        pagination.setPageNo(checkpointVo.getPageNo());
        pagination.setPageSize(checkpointVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    @Override
    public List<Checkpoint> selectList(CheckpointVo checkpointVo) {
        return checkpointMapper.selectList(checkpointVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    @Override
    public Checkpoint selectOne(CheckpointVo checkpointVo) {
        return checkpointMapper.selectOne(checkpointVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    @Override
    public int insert(Checkpoint checkpoint) {
        return checkpointMapper.insert(checkpoint);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    @Override
    public int update(Checkpoint checkpoint) {
        return checkpointMapper.update(checkpoint);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-22
	 */
    @Override
    public int delete(Long id) {
        return checkpointMapper.delete(id);
    }
}
