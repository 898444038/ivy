package com.ivy.admin.service.impl.monitor;

import com.ivy.admin.vo.monitor.MysqlStatusVo;
import com.ivy.admin.service.monitor.MysqlStatusService;
import com.ivy.admin.entity.monitor.MysqlStatus;
import com.ivy.admin.mapper.monitor.MysqlStatusMapper;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MySQL状态配置表
 * @author: Administrator
 * @date: 2020-10-09
 */
@Service
public class MysqlStatusServiceImpl implements MysqlStatusService {

    @Resource
    private MysqlStatusMapper mysqlStatusMapper;

	@Override
	public Pagination<MysqlStatus> selectPage(MysqlStatusVo mysqlStatusVo) {
        Pagination<MysqlStatus> pagination = new Pagination<>();
        int count = mysqlStatusMapper.selectCount(mysqlStatusVo);
        List<MysqlStatus> list = mysqlStatusMapper.selectPage(mysqlStatusVo);
        pagination.setPageNo(mysqlStatusVo.getPageNo());
        pagination.setPageSize(mysqlStatusVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    @Override
    public List<MysqlStatus> selectList(MysqlStatusVo mysqlStatusVo) {
        return mysqlStatusMapper.selectList(mysqlStatusVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    @Override
    public MysqlStatus selectOne(MysqlStatusVo mysqlStatusVo) {
        return mysqlStatusMapper.selectOne(mysqlStatusVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    @Override
    public int insert(MysqlStatus mysqlStatus) {
        return mysqlStatusMapper.insert(mysqlStatus);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    @Override
    public int update(MysqlStatus mysqlStatus) {
        return mysqlStatusMapper.update(mysqlStatus);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-09
	 */
    @Override
    public int delete(Long id) {
        return mysqlStatusMapper.delete(id);
    }
}
