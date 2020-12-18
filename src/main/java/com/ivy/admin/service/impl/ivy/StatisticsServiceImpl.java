package com.ivy.admin.service.impl.ivy;

import com.ivy.admin.mapper.ivy.StatisticsMapper;
import com.ivy.admin.vo.ivy.StatisticsVo;
import com.ivy.admin.service.ivy.StatisticsService;
import com.ivy.admin.entity.ivy.Statistics;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 统计
 * @author: Administrator
 * @date: 2020-08-12
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Resource
    private StatisticsMapper statisticsMapper;

	@Override
	public Pagination<Statistics> selectPage(StatisticsVo statisticsVo) {
        Pagination<Statistics> pagination = new Pagination<>();
        int count = statisticsMapper.selectCount(statisticsVo);
        List<Statistics> list = statisticsMapper.selectPage(statisticsVo);
        pagination.setPageNo(statisticsVo.getPageNo());
        pagination.setPageSize(statisticsVo.getPageSize());
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
    public List<Statistics> selectList(StatisticsVo statisticsVo) {
        return statisticsMapper.selectList(statisticsVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Override
    public Statistics selectOne(StatisticsVo statisticsVo) {
        return statisticsMapper.selectOne(statisticsVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Override
    public int insert(Statistics statistics) {
        return statisticsMapper.insert(statistics);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Override
    public int update(Statistics statistics) {
        return statisticsMapper.update(statistics);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Override
    public int delete(Long id) {
        return statisticsMapper.delete(id);
    }
}
