package com.ivy.admin.service.impl.ppsg;

import com.ivy.admin.entity.ppsg.GeneralSkin;
import com.ivy.admin.mapper.ppsg.GeneralSkinMapper;
import com.ivy.admin.vo.ppsg.GeneralSkinVo;
import com.ivy.admin.service.ppsg.GeneralSkinService;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 幻化
 * @author: Administrator
 * @date: 2020-12-30
 */
@Service
public class GeneralSkinServiceImpl implements GeneralSkinService {

    @Resource
    private GeneralSkinMapper generalSkinMapper;

	@Override
	public Pagination<GeneralSkin> selectPage(GeneralSkinVo generalSkinVo) {
        Pagination<GeneralSkin> pagination = new Pagination<>();
        int count = generalSkinMapper.selectCount(generalSkinVo);
        List<GeneralSkin> list = generalSkinMapper.selectPage(generalSkinVo);
        pagination.setPageNo(generalSkinVo.getPageNo());
        pagination.setPageSize(generalSkinVo.getPageSize());
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
    public List<GeneralSkin> selectList(GeneralSkinVo generalSkinVo) {
        return generalSkinMapper.selectList(generalSkinVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public GeneralSkin selectOne(GeneralSkinVo generalSkinVo) {
        return generalSkinMapper.selectOne(generalSkinVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int insert(GeneralSkin generalSkin) {
        return generalSkinMapper.insert(generalSkin);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int update(GeneralSkin generalSkin) {
        return generalSkinMapper.update(generalSkin);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int delete(Long id) {
        return generalSkinMapper.delete(id);
    }
}
