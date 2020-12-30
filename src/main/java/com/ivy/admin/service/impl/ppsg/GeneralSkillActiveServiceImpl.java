package com.ivy.admin.service.impl.ppsg;

import com.ivy.admin.service.ppsg.GeneralSkillActiveService;
import com.ivy.admin.mapper.ppsg.GeneralSkillActiveMapper;
import com.ivy.admin.entity.ppsg.GeneralSkillActive;
import com.ivy.admin.vo.ppsg.GeneralSkillActiveVo;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 主动技能
 * @author: Administrator
 * @date: 2020-12-30
 */
@Service
public class GeneralSkillActiveServiceImpl implements GeneralSkillActiveService {

    @Resource
    private GeneralSkillActiveMapper generalSkillActiveMapper;

	@Override
	public Pagination<GeneralSkillActive> selectPage(GeneralSkillActiveVo generalSkillActiveVo) {
        Pagination<GeneralSkillActive> pagination = new Pagination<>();
        int count = generalSkillActiveMapper.selectCount(generalSkillActiveVo);
        List<GeneralSkillActive> list = generalSkillActiveMapper.selectPage(generalSkillActiveVo);
        pagination.setPageNo(generalSkillActiveVo.getPageNo());
        pagination.setPageSize(generalSkillActiveVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public List<GeneralSkillActive> selectList(GeneralSkillActiveVo generalSkillActiveVo) {
        return generalSkillActiveMapper.selectList(generalSkillActiveVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public GeneralSkillActive selectOne(GeneralSkillActiveVo generalSkillActiveVo) {
        return generalSkillActiveMapper.selectOne(generalSkillActiveVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int insert(GeneralSkillActive generalSkillActive) {
        return generalSkillActiveMapper.insert(generalSkillActive);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int update(GeneralSkillActive generalSkillActive) {
        return generalSkillActiveMapper.update(generalSkillActive);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int delete(Long id) {
        return generalSkillActiveMapper.delete(id);
    }
}
