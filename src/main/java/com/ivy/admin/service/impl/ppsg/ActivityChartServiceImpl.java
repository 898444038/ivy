package com.ivy.admin.service.impl.ppsg;

import com.ivy.admin.mapper.ppsg.ActivityChartMapper;
import com.ivy.admin.service.ppsg.ActivityChartService;
import com.ivy.admin.vo.ppsg.ActivityChartVo;
import com.ivy.admin.entity.ppsg.ActivityChart;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 活动图
 * @author: Administrator
 * @date: 2020-12-24
 */
@Service
public class ActivityChartServiceImpl implements ActivityChartService {

    @Resource
    private ActivityChartMapper activityChartMapper;

	@Override
	public Pagination<ActivityChart> selectPage(ActivityChartVo activityChartVo) {
        Pagination<ActivityChart> pagination = new Pagination<>();
        int count = activityChartMapper.selectCount(activityChartVo);
        List<ActivityChart> list = activityChartMapper.selectPage(activityChartVo);
        pagination.setPageNo(activityChartVo.getPageNo());
        pagination.setPageSize(activityChartVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    @Override
    public List<ActivityChart> selectList(ActivityChartVo activityChartVo) {
        return activityChartMapper.selectList(activityChartVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    @Override
    public ActivityChart selectOne(ActivityChartVo activityChartVo) {
        return activityChartMapper.selectOne(activityChartVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    @Override
    public int insert(ActivityChart activityChart) {
        return activityChartMapper.insert(activityChart);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    @Override
    public int update(ActivityChart activityChart) {
        return activityChartMapper.update(activityChart);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-24
	 */
    @Override
    public int delete(Long id) {
        return activityChartMapper.delete(id);
    }
}
