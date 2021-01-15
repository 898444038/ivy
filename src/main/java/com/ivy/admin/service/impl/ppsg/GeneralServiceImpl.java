package com.ivy.admin.service.impl.ppsg;

import com.ivy.admin.service.ppsg.GeneralService;
import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.vo.ppsg.GeneralVo;
import com.ivy.admin.mapper.ppsg.GeneralMapper;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 武将
 * @author: Administrator
 * @date: 2020-12-30
 */
@Service
public class GeneralServiceImpl implements GeneralService {

    @Resource
    private GeneralMapper generalMapper;

	@Override
	public Pagination<General> selectPage(GeneralVo generalVo) {
        Pagination<General> pagination = new Pagination<>();
        int count = generalMapper.selectCount(generalVo);
        List<General> list = generalMapper.selectPage(generalVo);
        pagination.setPageNo(generalVo.getPageNo());
        pagination.setPageSize(generalVo.getPageSize());
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
    public List<General> selectList(GeneralVo generalVo) {
        return generalMapper.selectList(generalVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public General selectOne(GeneralVo generalVo) {
        return generalMapper.selectOne(generalVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int insert(General general) {
        return generalMapper.insert(general);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int update(General general) {
        return generalMapper.update(general);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int delete(Long id) {
        return generalMapper.delete(id);
    }

    @Override
    public GeneralVo selectByName(String name) {
        return generalMapper.selectByName(name);
    }
}
