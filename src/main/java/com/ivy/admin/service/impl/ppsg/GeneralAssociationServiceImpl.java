package com.ivy.admin.service.impl.ppsg;

import com.ivy.admin.entity.ppsg.GeneralAssociation;
import com.ivy.admin.service.ppsg.GeneralAssociationService;
import com.ivy.admin.mapper.ppsg.GeneralAssociationMapper;
import com.ivy.admin.vo.ppsg.GeneralAssociationVo;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 联协
 * @author: Administrator
 * @date: 2020-12-30
 */
@Service
public class GeneralAssociationServiceImpl implements GeneralAssociationService {

    @Resource
    private GeneralAssociationMapper generalAssociationMapper;

	@Override
	public Pagination<GeneralAssociation> selectPage(GeneralAssociationVo generalAssociationVo) {
        Pagination<GeneralAssociation> pagination = new Pagination<>();
        int count = generalAssociationMapper.selectCount(generalAssociationVo);
        List<GeneralAssociation> list = generalAssociationMapper.selectPage(generalAssociationVo);
        pagination.setPageNo(generalAssociationVo.getPageNo());
        pagination.setPageSize(generalAssociationVo.getPageSize());
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
    public List<GeneralAssociation> selectList(GeneralAssociationVo generalAssociationVo) {
        return generalAssociationMapper.selectList(generalAssociationVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public GeneralAssociation selectOne(GeneralAssociationVo generalAssociationVo) {
        return generalAssociationMapper.selectOne(generalAssociationVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int insert(GeneralAssociation generalAssociation) {
        return generalAssociationMapper.insert(generalAssociation);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int update(GeneralAssociation generalAssociation) {
        return generalAssociationMapper.update(generalAssociation);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int delete(Long id) {
        return generalAssociationMapper.delete(id);
    }
}
