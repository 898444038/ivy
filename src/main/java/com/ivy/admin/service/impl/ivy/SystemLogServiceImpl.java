package com.ivy.admin.service.impl.ivy;

import com.ivy.admin.service.ivy.SystemLogService;
import com.ivy.admin.vo.ivy.SystemLogVo;
import com.ivy.admin.mapper.ivy.SystemLogMapper;
import com.ivy.admin.entity.ivy.SystemLog;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 日志
 * @author: Administrator
 * @date: 2020-08-12
 */
@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Resource
    private SystemLogMapper systemLogMapper;

	@Override
	public Pagination<SystemLog> selectPage(SystemLogVo systemLogVo) {
        Pagination<SystemLog> pagination = new Pagination<>();
        int count = systemLogMapper.selectCount(systemLogVo);
        List<SystemLog> list = systemLogMapper.selectPage(systemLogVo);
        pagination.setPageNo(systemLogVo.getPageNo());
        pagination.setPageSize(systemLogVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Override
    public List<SystemLog> selectList(SystemLogVo systemLogVo) {
        return systemLogMapper.selectList(systemLogVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Override
    public SystemLog selectOne(SystemLogVo systemLogVo) {
        return systemLogMapper.selectOne(systemLogVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Override
    public int insert(SystemLog systemLog) {
        return systemLogMapper.insert(systemLog);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Override
    public int update(SystemLog systemLog) {
        return systemLogMapper.update(systemLog);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Override
    public int delete(Long id) {
        return systemLogMapper.delete(id);
    }
}
