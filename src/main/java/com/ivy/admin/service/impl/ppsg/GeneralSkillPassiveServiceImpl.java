package com.ivy.admin.service.impl.ppsg;

import com.ivy.admin.vo.ppsg.GeneralSkillPassiveVo;
import com.ivy.admin.service.ppsg.GeneralSkillPassiveService;
import com.ivy.admin.entity.ppsg.GeneralSkillPassive;
import com.ivy.admin.mapper.ppsg.GeneralSkillPassiveMapper;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 被动技能
 * @author: Administrator
 * @date: 2020-12-30
 */
@Service
public class GeneralSkillPassiveServiceImpl implements GeneralSkillPassiveService {

    @Resource
    private GeneralSkillPassiveMapper generalSkillPassiveMapper;

	@Override
	public Pagination<GeneralSkillPassive> selectPage(GeneralSkillPassiveVo generalSkillPassiveVo) {
        Pagination<GeneralSkillPassive> pagination = new Pagination<>();
        int count = generalSkillPassiveMapper.selectCount(generalSkillPassiveVo);
        List<GeneralSkillPassive> list = generalSkillPassiveMapper.selectPage(generalSkillPassiveVo);
        pagination.setPageNo(generalSkillPassiveVo.getPageNo());
        pagination.setPageSize(generalSkillPassiveVo.getPageSize());
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
    public List<GeneralSkillPassive> selectList(GeneralSkillPassiveVo generalSkillPassiveVo) {
        return generalSkillPassiveMapper.selectList(generalSkillPassiveVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public GeneralSkillPassive selectOne(GeneralSkillPassiveVo generalSkillPassiveVo) {
        return generalSkillPassiveMapper.selectOne(generalSkillPassiveVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int insert(GeneralSkillPassive generalSkillPassive) {
        return generalSkillPassiveMapper.insert(generalSkillPassive);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int update(GeneralSkillPassive generalSkillPassive) {
        return generalSkillPassiveMapper.update(generalSkillPassive);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int delete(Long id) {
        return generalSkillPassiveMapper.delete(id);
    }
}
